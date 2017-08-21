package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.database.HouseDatabase;
import org.loopingdoge.acme.model.House;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HouseCollector implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("acme-agency - House Collector");

    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.log(Level.INFO, "I'm being called!");
        List<House> houseList = HouseDatabase.getHouseList();
        delegateExecution.setVariable("houseList", houseList);
        delegateExecution.setVariable("proposalList", new ArrayList<House>());
    }

}
