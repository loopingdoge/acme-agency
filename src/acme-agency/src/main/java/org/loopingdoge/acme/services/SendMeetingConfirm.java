package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServer;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServerService;
import org.loopingdoge.acme.utils.AcmeVariables;

import java.util.Date;
import java.util.logging.Logger;

public class SendMeetingConfirm implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("SendMeetingConfirm");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");
        // TODO implement this
        
        // remove session        
        ACMESessionServer sessionWs = new ACMESessionServerService().getACMESessionServerServicePort();
        sessionWs.removeSession(execution.getProcessInstanceId());
        
        String meetingDate = (String) execution.getVariable(AcmeVariables.MEETING_DATE);
        
        if (meetingDate != null) {
        	logger.info("Meeting date ok!");
        }
        
        else {
        	logger.info("No meeting date found");
        }
    }

}
