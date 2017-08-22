package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.database.HouseDatabase;
import org.loopingdoge.acme.model.House;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HouseCollector implements JavaDelegate {

    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("I'm being called!");
        List<House> houseList = HouseDatabase.getHouseList();
        delegateExecution.setVariable("houseList", houseList);
//        delegateExecution.setVariable("proposalList", new ArrayList<House>());
    }

}
