package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServer;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServerService;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.utils.AcmeVariables;

import java.util.ArrayList;
import java.util.logging.Logger;

public class RemoveActiveSession implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("RemoveActiveSession");

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
   
    	// Remove current process instance session
        ACMESessionServer sessionWs = new ACMESessionServerService().getACMESessionServerServicePort();
        sessionWs.removeSession(delegateExecution.getProcessInstanceId());
  
    }

}
