package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.House;

import java.util.ArrayList;

public class AddHouseToReply implements JavaDelegate {

    public void execute(DelegateExecution delegateExecution) throws Exception {
        ArrayList<House> proposalList = (ArrayList<House>) delegateExecution.getVariable("proposalList");
        House currHouse = (House) delegateExecution.getVariable("house");
        proposalList.add(currHouse);
        System.out.println("Proposal list: " + proposalList);
        delegateExecution.setVariable("proposalList", proposalList);
        delegateExecution.setVariable("proposalListSize", proposalList.size());
    }

}
