package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.utils.AcmeVariables;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AddHouseToReply implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("AddHouseToReply");

    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("service started");

        ArrayList<House> proposalList = (ArrayList<House>) delegateExecution.getVariable(AcmeVariables.PROPOSAL_LIST);
        House house = (House) delegateExecution.getVariable(AcmeVariables.CURR_HOUSE);

        proposalList.add(house);

        delegateExecution.setVariable(AcmeVariables.PROPOSAL_LIST, proposalList);

    }

}
