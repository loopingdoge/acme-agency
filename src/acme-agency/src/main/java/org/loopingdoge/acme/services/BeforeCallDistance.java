package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.utils.AcmeVariables;

import java.util.ArrayList;
import java.util.logging.Logger;

public class BeforeCallDistance implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("BeforeCallDistance");

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        ArrayList<House> houseList = (ArrayList<House>) delegateExecution.getVariable(AcmeVariables.HOUSE_LIST);

        House house = houseList.remove(0);

        delegateExecution.setVariable(AcmeVariables.CURR_HOUSE, house);

    }

}
