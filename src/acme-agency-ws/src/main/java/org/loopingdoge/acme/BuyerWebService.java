package org.loopingdoge.acme;

import org.camunda.bpm.engine.ProcessEngine;
import org.loopingdoge.acme.model.Address;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.model.HouseProfile;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@SuppressWarnings("restriction")
@WebService
public class BuyerWebService {
	@Resource(mappedName = "java:global/camunda-bpm-platform/process-engine/default")
	private ProcessEngine processEngine;

	private final static Logger LOGGER = Logger.getLogger("acme-agency-ws");
	
	public BuyerWebService () {}

	@WebMethod
	public ArrayList<House> requestHouses(
			@WebParam(name="houseProfile") HouseProfile houseProfile,
			@WebParam(name="buyerName") String buyerName) {
		
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
		String startMessageId = "houseLookup";
		processEngine.getRuntimeService().startProcessInstanceByMessage(startMessageId, vars);
		
		return houseList;
	}
}
