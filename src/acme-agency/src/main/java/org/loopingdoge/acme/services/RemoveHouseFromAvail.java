package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.House;

import java.util.List;
import java.util.logging.Logger;

public class RemoveHouseFromAvail implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("RemoveHouseFromAvail");

    public void execute(DelegateExecution delegateExecution) throws Exception {

        List<House> houseList = (List<House>) delegateExecution.getVariable("houseList" );
        House house = (House) delegateExecution.getVariable("house");

        houseList.remove(house);

        delegateExecution.setVariable("houseList" , houseList);

    }
}