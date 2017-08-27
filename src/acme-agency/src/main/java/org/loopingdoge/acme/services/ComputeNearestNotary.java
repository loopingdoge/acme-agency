package org.loopingdoge.acme.services;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.utils.AcmeVariables;
import org.loopingdoge.acme.utils.NotaryDistanceTuple;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ComputeNearestNotary implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("ComputeNearestNotary");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");

        ArrayList<NotaryDistanceTuple> notaryDistances = (ArrayList<NotaryDistanceTuple>) execution.getVariable(AcmeVariables.NOTARY_DISTANCES);

        NotaryDistanceTuple nearestTuple = notaryDistances.get(0);

        for (NotaryDistanceTuple tuple : notaryDistances) {
            if (tuple.getDistance() < nearestTuple.getDistance()) {
                nearestTuple = tuple;
            }
        }

        execution.setVariable(AcmeVariables.CHOSEN_NOTARY, nearestTuple.getNotary());

        logger.info("Nearest notary: " + nearestTuple.getNotary().getName());
    }

}
