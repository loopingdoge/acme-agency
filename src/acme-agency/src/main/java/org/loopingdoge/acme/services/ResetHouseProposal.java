package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.House;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ResetHouseProposal implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("ResetHouseProposal");

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("SERVICE STARTED!");

        delegateExecution.setVariable("proposalList", new ArrayList<House>());

    }

}
