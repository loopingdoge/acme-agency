package org.loopingdoge.acme;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.loopingdoge.acme.model.Address;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.model.HouseProfile;
import org.loopingdoge.acme.utils.HouseRequestReplyMessage;

import com.sun.mail.mbox.NewlineOutputStream;

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
	
	private final static String CAMUNDA_PROCESS_ID = "camundaProcessId";
	private final static String CAMUNDA_ACTION_MESSAGE = "houseProposalReply";
	private final static String CAMUNDA_ACTION_VARIABLE = "houseProposalReply";
	private final static String CAMUNDA_PROPOSAL_LIST_VARIABLE = "proposalList";
	private final static String REPLY_ACCEPT = "accept";
	private final static String REPLY_MORE = "more";
	private final static String REPLY_STOP = "stop";
	
	
	public BuyerWebService () {}

	@WebMethod
	public HouseRequestReplyMessage requestHouses(
			@WebParam(name="houseProfile") HouseProfile houseProfile,
			@WebParam(name="buyerName") String buyerName) {
		
		// House examples
		ArrayList<House> houseList = new ArrayList<House>();
		houseList.add(new House(
				new Address("Italia", "MO", "Quarantoli", "Via Unica", "31"),
				"Casa nel Bosco", "Geppetto", 125, true, 125000)
		);
		houseList.add(new House(
				new Address("Italia", "MO", "Mirandola", "Via Secca", "77"), 
				"Grattacielo", "Paperone", 300, false, 500000)
		);
		houseList.add(new House(
				new Address("Italia", "MO", "Medolla", "Via Lunga", "1"), 
				"Casa sull'Albero", "Luciano", 25, true, 7000)
		);
		
		// Session management
		MessageContext mc = wsContext.getMessageContext();    	
        HttpSession session = ((HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
        if (session == null) {
        	throw new WebServiceException("No session in WebServiceContext");
        }
		
		// Process initial variables 
		Map<String, Object> vars = new HashMap<String, Object>();
	
		// Start a process in Camunda, which is waiting on the specified messageId
		String startMessageId = "houseLookup";
		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByMessage(startMessageId, vars);
		
		// Associate session with Camunda processId
		String camundaProcessId = (String)session.getAttribute(CAMUNDA_PROCESS_ID);
        if (camundaProcessId == null) {
            camundaProcessId = processInstance.getProcessInstanceId();
            session.setAttribute("camundaProcessId", camundaProcessId);
            LOGGER.info("Starting new buyer session...");
        }
        else {
        	// TODO - Arresto il processo precedente (?)
        	LOGGER.info("Client with active session requested new process");
        }
		
		return new HouseRequestReplyMessage(
				//houseList,
				(ArrayList<House>)processEngine.getRuntimeService().getVariable(camundaProcessId, CAMUNDA_PROPOSAL_LIST_VARIABLE),
				"Ok");
	}
	
	
	
	@WebMethod
	public HouseRequestReplyMessage houseProposalReply (
			@WebParam(name="replyAction") String replyAction) {
		
		// Session management
		MessageContext mc = wsContext.getMessageContext();    	
        HttpSession session = ((HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
        if (session == null) {
        	throw new WebServiceException("No session in WebServiceContext");
        }
        
        // Get Camunda processId from session
        String camundaProcessId = (String)session.getAttribute(CAMUNDA_PROCESS_ID);
        if (camundaProcessId == null) {
            LOGGER.warning("No process associated");
            return new HouseRequestReplyMessage(null, "No process associated");
        }
        
        // Set action in Camunda process
        processEngine.getRuntimeService().setVariable(camundaProcessId, CAMUNDA_ACTION_VARIABLE, replyAction);
        
        // Unlock process using message
        processEngine.getRuntimeService().createMessageCorrelation(CAMUNDA_ACTION_MESSAGE)
		  .processInstanceId(camundaProcessId)
		  .correlate();
        
        // Accept or Stop case
        if (replyAction.matches(REPLY_ACCEPT) || replyAction.matches(REPLY_STOP)) 
        	return new HouseRequestReplyMessage(null, replyAction);
      
        			
        // More case
        else        
        	return new HouseRequestReplyMessage(
        			(ArrayList<House>)processEngine.getRuntimeService().getVariable(camundaProcessId, CAMUNDA_PROPOSAL_LIST_VARIABLE),
        			"Ok, more");
	}
}
