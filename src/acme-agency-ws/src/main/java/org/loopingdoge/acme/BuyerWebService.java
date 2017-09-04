package org.loopingdoge.acme;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.model.HouseProfile;
import org.loopingdoge.acme.utils.AcmeVariables;
import org.loopingdoge.acme.utils.HouseRequestReplyMessage;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@SuppressWarnings("restriction")
@WebService(name = "BuyerWebService")
public class BuyerWebService {
    @Resource(mappedName = "java:global/camunda-bpm-platform/process-engine/default")
    private ProcessEngine processEngine;

    @Resource
    private WebServiceContext wsContext;

	private final static Logger LOGGER = Logger.getLogger("acme-agency-ws");

	private final static String PROCESS_ID = "camundaProcessId";

	private final static String REPLY_ACCEPT = "accept";
	private final static String REPLY_MORE = "more";
	private final static String REPLY_STOP = "stop";
	private final static String ERROR = "error";
	private final static String OK = "ok";

	public BuyerWebService () {}

    @WebMethod
    public HouseRequestReplyMessage requestHouses(
            @WebParam(name = "houseProfile") HouseProfile houseProfile,
            @WebParam(name = "buyerName") String buyerName) {

        // Session management
        MessageContext mc = wsContext.getMessageContext();
        HttpSession session = ((HttpServletRequest) mc.get(MessageContext.SERVLET_REQUEST)).getSession();
        if (session == null) {
            throw new WebServiceException("No session in WebServiceContext");
        }

        // Process initial variables
        Map<String, Object> vars = new HashMap<String, Object>();

//        TODO usare new HouseProfile
        vars.put("houseProfile", houseProfile);
        vars.put("buyerName", buyerName);


        // Start a process in Camunda, which is waiting on the specified messageId
        String startMessageId = "houseLookup";
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByMessage(startMessageId, vars);

        // Associate session with Camunda processId
        String camundaProcessId = (String) session.getAttribute(PROCESS_ID);
        if (camundaProcessId == null) {
            camundaProcessId = processInstance.getProcessInstanceId();
            session.setAttribute(PROCESS_ID, camundaProcessId);
            LOGGER.info("Starting new buyer session...");
        } else {
            // TODO - Arresto il processo precedente (?)
            LOGGER.info("Client with active session requested new process");
        }

        ArrayList<House> proposalList = (ArrayList<House>)
                processEngine.getRuntimeService().getVariable(camundaProcessId, AcmeVariables.PROPOSAL_LIST);

        return new HouseRequestReplyMessage(proposalList,
                "Ok");
    }
	
	@SuppressWarnings("unchecked")
	@WebMethod
	public HouseRequestReplyMessage houseProposalReply (
			@WebParam(name="replyAction") String replyAction,
			@WebParam(name="selectedHouseIndex") int selectedHouseIndex){
		// Session management
		
		MessageContext mc = wsContext.getMessageContext();    	
        HttpSession session = ((HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
        if (session == null) {
            throw new WebServiceException("No session in WebServiceContext");
        }

        // Get Camunda processId from session
        String camundaProcessId = (String)session.getAttribute(PROCESS_ID);
        if (camundaProcessId == null) {
            LOGGER.warning("No process associated");
            return new HouseRequestReplyMessage(null, "No process associated");
        }

        // Set action in Camunda process
        processEngine.getRuntimeService().setVariable(
        		camundaProcessId, 
        		AcmeVariables.HOUSE_LOOKUP_ACTION_VARIABLE, 
        		replyAction);
  
        
        
        // Stop case
        if (replyAction.matches(REPLY_STOP)) {
            // Unlock process using message
            processEngine.getRuntimeService().createMessageCorrelation(AcmeVariables.HOUSE_LOOKUP_ACTION_MESSAGE)
    		  .processInstanceId(camundaProcessId)
    		  .correlate();
        
        	return new HouseRequestReplyMessage(null, replyAction);   
        }

        // More case
        else if (replyAction.matches(REPLY_MORE)) {
        	// Unlock process using message
            processEngine.getRuntimeService().createMessageCorrelation(AcmeVariables.HOUSE_LOOKUP_ACTION_MESSAGE)
    		  .processInstanceId(camundaProcessId)
    		  .correlate();
            
        	return new HouseRequestReplyMessage(
        			(ArrayList<House>)processEngine.getRuntimeService().getVariable(
        					camundaProcessId,
        					AcmeVariables.PROPOSAL_LIST),
        			OK);
        }

        // Accept case
        if (replyAction.matches(REPLY_ACCEPT)) {
            // check if selectedHouseIndex is acceptable
            ArrayList<House> proposedHouseList = (ArrayList<House>) processEngine.getRuntimeService().getVariable(camundaProcessId, AcmeVariables.PROPOSAL_LIST);

            if (proposedHouseList.size() <= selectedHouseIndex)
                return new HouseRequestReplyMessage(null, ERROR);

            else {
                // Set accepted house in Camunda process

                LOGGER.info("Name: " + proposedHouseList.get(selectedHouseIndex).getName());

                ObjectValue houseDataValue = Variables.objectValue(proposedHouseList.get(selectedHouseIndex))
                        .serializationDataFormat(Variables.SerializationDataFormats.JSON)
                        .create();

                LOGGER.info("Serialization: " + houseDataValue.getValueSerialized());

                processEngine.getRuntimeService().setVariable(
                        camundaProcessId,
                        AcmeVariables.CHOSEN_HOUSE,
                        houseDataValue);

                // Unlock process using message
                processEngine.getRuntimeService().createMessageCorrelation(AcmeVariables.HOUSE_LOOKUP_ACTION_MESSAGE)
                        .processInstanceId(camundaProcessId)
                        .correlate();

                return new HouseRequestReplyMessage(null, OK);
            }
        }

        return new HouseRequestReplyMessage(null, ERROR);
	}
	
	
	@SuppressWarnings("unchecked")
	@WebMethod
	public List<String> getSellerMeetingDateList (@WebParam(name="processId") String processId) {
		List<String> dateList = (List<String>) processEngine.getRuntimeService().getVariable(
				processId, 
				"meetingDateList");
		return dateList;
	}
	
	@WebMethod
	public String replyToMeetingProposal (
			@WebParam(name="processId") String processId,
			@WebParam(name="acceptedDate") String acceptedDate,
			@WebParam(name="newDateList") List<String> newDateList) {
		
		// Buyer has accepted a date
		if (acceptedDate != null) {
			// set meeting accepted
			processEngine.getRuntimeService().setVariable(
					processId, 
					AcmeVariables.BUYER_MEETING_REPLY, 
					REPLY_ACCEPT);
			
			// set meeting accepted
			processEngine.getRuntimeService().setVariable(
					processId, 
					AcmeVariables.MEETING_DATE, 
					acceptedDate);
		}
		
		// Buyer proposed new dates
		else {
			// set meeting accepted
			processEngine.getRuntimeService().setVariable(
					processId, 
					AcmeVariables.BUYER_MEETING_REPLY, 
					"newDateProposed");
			
			// set new meeting date list
			processEngine.getRuntimeService().setVariable(
					processId, 
					AcmeVariables.MEETING_DATE_LIST, 
					newDateList);
		}
		
		// Unlock process using message
        processEngine.getRuntimeService().createMessageCorrelation(AcmeVariables.BUYER_MEETING_REPLY_MESSAGE)
		  .processInstanceId(processId)
		  .correlate();
		
		return OK;
	}


	@WebMethod
	public String makeOffer (
			@WebParam(name="processId") String processId,
			@WebParam(name="buyerOffer") double buyerOffer) {

		// Set buyer offer variable
		processEngine.getRuntimeService().setVariable(
				processId,
				AcmeVariables.BUYER_OFFER,
				buyerOffer);

		// Unlock process using message
		processEngine.getRuntimeService().createMessageCorrelation(AcmeVariables.BUYER_OFFER)
				.processInstanceId(processId)
				.correlate();

		return "Ok";
	}

	@WebMethod
	public House getChosenHouse (
			@WebParam(name="processId") String processId ){

		// Get chosen house data
		House chosenHouse = (House) processEngine.getRuntimeService().getVariable(
				processId,
				AcmeVariables.CHOSEN_HOUSE);

		return chosenHouse;
	}
	
	@WebMethod
	public Double getBuyerOffer (
			@WebParam(name="processId") String processId ){

		// Get buyer offer data
		Double buyerOffer = (Double) processEngine.getRuntimeService().getVariable(
				processId,
				AcmeVariables.BUYER_OFFER);

		return buyerOffer;
	}
	
}
