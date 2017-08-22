package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HouseAdder implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("acme-agency - House Adder");

    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.log(Level.INFO, "I'm being called!");
    }

}
