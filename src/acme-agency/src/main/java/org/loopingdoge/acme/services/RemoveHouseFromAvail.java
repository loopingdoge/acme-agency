package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.House;

import java.util.ArrayList;
import java.util.logging.Logger;

public class RemoveHouseFromAvail implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("RemoveHouseFromAvail");

    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("WKEKEKJE " + Integer.toString((int)delegateExecution.getVariable("distance")));

    }
}