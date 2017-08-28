package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.loopingdoge.acme.model.Address;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.utils.AcmeVariables;
import org.loopingdoge.acme.utils.HouseDatabase;

public class TestCadastreStart implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        House chosenHouse = HouseDatabase.getHouse(0);
        Address address = chosenHouse.getAddress();
        address.setCap("");
        chosenHouse.setAddress(address);

        ObjectValue houseDataValue = Variables.objectValue(chosenHouse)
                .serializationDataFormat(Variables.SerializationDataFormats.JSON)
                .create();

        execution.setVariable(AcmeVariables.CHOSEN_HOUSE, houseDataValue);
    }
}