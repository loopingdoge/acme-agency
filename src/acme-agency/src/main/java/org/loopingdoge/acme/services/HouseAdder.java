package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HouseAdder implements JavaDelegate {


    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("I'm being called!");
    }

}
