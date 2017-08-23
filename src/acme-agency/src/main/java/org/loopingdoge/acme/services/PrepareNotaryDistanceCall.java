package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.model.Notary;

import java.util.logging.Logger;

/**
 * in:  notary
 *      house
 *
 * out: fromAddress
 *      toAddress
 */
public class PrepareNotaryDistanceCall implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("PrepareNotaryDistanceCall");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");
        Notary currNotary = (Notary) execution.getVariable("notary");
        House house = (House) execution.getVariable("house");
        execution.setVariableLocal("fromAddress", currNotary.getAddress());
        execution.setVariableLocal("toAddress", house.getAddress());
    }

}
