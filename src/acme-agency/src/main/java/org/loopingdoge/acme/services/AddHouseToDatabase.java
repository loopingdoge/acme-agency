package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.utils.HouseDatabase;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AddHouseToDatabase implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("AddHouseToDatabase");

    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("service started");
        House newHouse = (House) delegateExecution.getVariable("newHouse");
        HouseDatabase.addHouse(newHouse);
    }

}
