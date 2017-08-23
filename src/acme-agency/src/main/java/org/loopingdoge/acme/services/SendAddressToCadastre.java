package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class SendAddressToCadastre implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("SendAddressToCadastre");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");
        // TODO implement this
        // in: houseAddressForCadastre
        // out: cadastrialResponse
    }

}
