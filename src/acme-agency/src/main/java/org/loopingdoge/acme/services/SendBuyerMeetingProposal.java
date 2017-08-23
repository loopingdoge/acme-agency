package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class SendBuyerMeetingProposal implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("SendBuyerMeetingProposal");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");
        // TODO implement this
        // settare la variabile di processo String buyerMeetingReply = "retry" || "accept"
    }

}
