package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.Notary;
import org.loopingdoge.acme.utils.NotaryDistanceTuple;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * in:  distance
 *      notary
 *      notaryDistances
 *
 * out: notaryDistances
 */
public class AddDistanceToNotaryDistanceList implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("AddDistanceToNotaryDistanceList");

    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");

        Notary currNotary = (Notary) execution.getVariable("notary");
        Integer distance = (Integer) execution.getVariable("distance");
        Object tempNotaryDistances = execution.getVariable("notaryDistances");
        if (tempNotaryDistances == null) {
            tempNotaryDistances = new ArrayList<NotaryDistanceTuple>();
        }
        ArrayList<NotaryDistanceTuple> notaryDistances = (ArrayList<NotaryDistanceTuple>) tempNotaryDistances;

        notaryDistances.add(new NotaryDistanceTuple(currNotary, distance));

        execution.setVariableLocal("notaryDistances", notaryDistances);
    }

}
