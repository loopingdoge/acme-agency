package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.utils.AcmeVariables;

import java.util.List;
import java.util.logging.Logger;

public class RemoveHouseFromAvail implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("RemoveHouseFromAvail");

    public void execute(DelegateExecution delegateExecution) throws Exception {

        List<House> houseList = (List<House>) delegateExecution.getVariable(AcmeVariables.HOUSE_LIST);
        House house = (House) delegateExecution.getVariable(AcmeVariables.CURR_HOUSE);

        houseList.remove(house);

        delegateExecution.setVariable(AcmeVariables.HOUSE_LIST, houseList);

    }
}