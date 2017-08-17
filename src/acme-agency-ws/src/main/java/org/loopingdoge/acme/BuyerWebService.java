package org.loopingdoge.acme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.*;
import javax.annotation.Resource;

import org.camunda.bpm.engine.ProcessEngine;
import org.loopingdoge.utils.Address;
import org.loopingdoge.utils.House;
import org.loopingdoge.utils.HouseProfile;

@SuppressWarnings("restriction")
@WebService
public class BuyerWebService {
	@Resource(mappedName = "java:global/camunda-bpm-platform/process-engine/default")
	private ProcessEngine processEngine;

	
	public BuyerWebService () {}

	@WebMethod
	public ArrayList<House> requestHouses(
			@WebParam(name="houseProfile")
			HouseProfile houseProfile, 
			@WebParam(name="buyerName")
			String buyerName) {
		
		/* House examples */
		ArrayList<House> houseList = new ArrayList<House>();
		houseList.add(new House(
				new Address("Italia", "MO", "Quarantoli", "Via Unica", "31"),
				"Casa nel Bosco", "Geppetto", 125, true, 125000)
		);
		houseList.add(new House(
				new Address("Italia", "MO", "Mirandola", "Via Secca", "77"), 
				"Grattacielo", "Paperone", 300, false, 500000)
		);
		houseList.add(new House(
				new Address("Italia", "MO", "Medolla", "Via Lunga", "1"), 
				"Casa sull'Albero", "Luciano", 25, true, 7000)
		);
		

		String message = "MSG";
		Map<String, Object> vars = new HashMap<String, Object>();
		/* Process initial variables */
		vars.put("name", message);
		vars.put("emptyMessage", "");
		
		/* Start a process in Camunda, which is waiting on the specified messageId */
		String startMessageId = "AcmeOfferMessage";
		processEngine.getRuntimeService().startProcessInstanceByMessage(startMessageId, vars);
		
		return houseList;
	}
}
