package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.House;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AddHouseToReply implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("AddHouseToReply");

    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("service started");

        ArrayList<House> proposalList = (ArrayList<House>) delegateExecution.getVariable("proposalList");
        House currHouse = (House) delegateExecution.getVariable("house");

        proposalList.add(currHouse);

        delegateExecution.setVariable("proposalList", proposalList);

    }

}
