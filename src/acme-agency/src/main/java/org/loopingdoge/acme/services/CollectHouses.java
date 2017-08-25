package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.HouseProfile;
import org.loopingdoge.acme.utils.HouseDatabase;
import org.loopingdoge.acme.model.House;

import java.util.ArrayList;
import java.util.List;

public class CollectHouses implements JavaDelegate {

    public void execute(DelegateExecution delegateExecution) throws Exception {

        List<House> houseList = new ArrayList<>(HouseDatabase.getHouseList());
        delegateExecution.setVariable("houseList", houseList);
        delegateExecution.setVariable("proposalList", new ArrayList<House>());

    }

}
