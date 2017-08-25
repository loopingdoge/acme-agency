package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.Notary;
import org.loopingdoge.acme.utils.HouseDatabase;
import org.loopingdoge.acme.utils.NotariesDatabase;
import org.loopingdoge.acme.utils.NotaryDistanceTuple;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CollectNotaries implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("CollectNotaries");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");
        List<Notary> notaries = new ArrayList<>(NotariesDatabase.getNotaryList());
        execution.setVariableLocal("notaries", notaries);
        execution.setVariableLocal("notaryDistances", new ArrayList<NotaryDistanceTuple>());
//        execution.setVariable("chosenHouse", HouseDatabase.getHouse(0));          // For debug purposes
    }

}
