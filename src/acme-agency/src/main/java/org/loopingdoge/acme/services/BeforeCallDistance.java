package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.House;

import java.util.ArrayList;
import java.util.logging.Logger;

public class BeforeCallDistance implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("BeforeCallDistance");

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        ArrayList<House> houseList = (ArrayList<House>) delegateExecution.getVariable("houseList");

        House house = houseList.remove(0);

        delegateExecution.setVariable("house", house);

    }

}
