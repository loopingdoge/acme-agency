package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class SendMeetingConfirm implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("SendMeetingConfirm");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");
        // TODO implement this
    }

}
