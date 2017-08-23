package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.utils.HouseDatabase;
import org.loopingdoge.acme.model.House;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CollectHouses implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("CallDistance");

    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("service started");
        List<House> houseList = new ArrayList<>(HouseDatabase.getHouseList());
        delegateExecution.setVariable("houseList", houseList);
        delegateExecution.setVariable("proposalList", new ArrayList<House>());
        delegateExecution.setVariable("proposalListSize", 0);
    }

}
