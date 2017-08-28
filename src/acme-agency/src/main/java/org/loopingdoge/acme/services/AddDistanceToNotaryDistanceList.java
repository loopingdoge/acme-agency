package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.Notary;
import org.loopingdoge.acme.utils.AcmeVariables;
import org.loopingdoge.acme.utils.NotaryDistanceTuple;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * in:  distance
 * notary
 * notaryDistances
 * <p>
 * out: notaryDistances
 */
public class AddDistanceToNotaryDistanceList implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("AddDistanceToNotaryDistanceList");

    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");

        Notary currNotary = (Notary) execution.getVariable(AcmeVariables.CURR_NOTARY);
        Double distance = (Double) execution.getVariable(AcmeVariables.DISTANCE);
        Object tempNotaryDistances = execution.getVariable(AcmeVariables.NOTARY_DISTANCES);
        if (tempNotaryDistances == null) {
            tempNotaryDistances = new ArrayList<NotaryDistanceTuple>();
        }
        ArrayList<NotaryDistanceTuple> notaryDistances = (ArrayList<NotaryDistanceTuple>) tempNotaryDistances;

        notaryDistances.add(new NotaryDistanceTuple(currNotary, distance.intValue()));

        execution.setVariableLocal(AcmeVariables.NOTARY_DISTANCES, notaryDistances);
    }

}
