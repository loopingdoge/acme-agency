package org.loopingdoge.acme;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.*;

import org.camunda.bpm.engine.ProcessEngine;
import org.loopingdoge.utils.House;

@SuppressWarnings("restriction")
@WebService
public class SellerWebService {
	@Resource(mappedName = "java:global/camunda-bpm-platform/process-engine/default")
	private ProcessEngine processEngine;
	
	public SellerWebService () {}

	/*@WebMethod
	public String listTest(List<String> list) {
		String result = "";
	    if(list == null) {
	        result = "list is null";
	    } else if(list.size() == 0) {
	        result = "list is empty";
	    } else {
	        for(String elem : list) {
	            result += elem + " ";
	        }
	    }
	    return result;
	}*/

	
	@WebMethod
	public String proposeHouse(
			@WebParam(name="house")
			House house) {
		
		System.out.println(house);
		if (house != null && house.isComplete()) {
			String message = "MSG";
			Map<String, Object> vars = new HashMap<String, Object>();
			/* Process initial variables */
			vars.put("name", message);
			vars.put("emptyMessage", "");
			/* Start a process in Camunda, which i
			s waiting on the specified messageId */
			String startMessageId = "houseAddition";
			System.out.println(startMessageId);
			processEngine.getRuntimeService().startProcessInstanceByMessage(startMessageId, vars);
			return "Proposal accepted";
		} else
			return "Proposal refused: data is missing";
	}
}
