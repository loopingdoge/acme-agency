package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServer;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServerService;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.utils.AcmeExternalServices;
import org.loopingdoge.acme.utils.AcmeVariables;
import org.loopingdoge.acme.utils.MailServiceAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Date;
import java.util.logging.Logger;

public class SendMeetingConfirm implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("SendMeetingConfirm");
    
    private final String BASE_URL = AcmeExternalServices.MAIL;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private MailServiceAPI mailService = retrofit.create(MailServiceAPI.class);

    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");
        // TODO implement this
        
        // remove session        
        ACMESessionServer sessionWs = new ACMESessionServerService().getACMESessionServerServicePort();
        sessionWs.removeSession(execution.getProcessInstanceId());
        
        String meetingDate = (String) execution.getVariable(AcmeVariables.MEETING_DATE);
        String buyerName = (String) execution.getVariable(AcmeVariables.BUYER_NAME);
        House house = (House) execution.getVariable(AcmeVariables.CHOSEN_HOUSE);
        String sellerName = house.getSellerName();
        
        if (meetingDate != null) {
        	logger.info("Meeting date ok!");
        	mailService.send(
        			buyerName, 
        			"AcmeAgency", 
        			"Meeting date is ok").execute().body();
        	
        	mailService.send(
        			sellerName, 
        			"AcmeAgency", 
        			"Meeting date is ok").execute().body();
        }
        
        else {
        	logger.info("No meeting date found");
        	
        	mailService.send(
        			buyerName, 
        			"AcmeAgency", 
        			"No meeting date found").execute().body();
        	
        	mailService.send(
        			sellerName, 
        			"AcmeAgency", 
        			"No meeting date found").execute().body();
        }
    }

}
