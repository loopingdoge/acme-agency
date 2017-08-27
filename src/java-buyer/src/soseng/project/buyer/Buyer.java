package soseng.project.buyer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.loopingdoge.acme.jolie.sessionmanager.ClientSessionServer;
import org.loopingdoge.acme.jolie.sessionmanager.ClientSessionServerService;
import org.loopingdoge.acme.jolie.sessionmanager.SessionType;

import soseng.project.wsinterface.*;

public class Buyer {
	
	private final static String REPLY_ACCEPT = "accept";
	private final static String REPLY_MORE = "more";
	private final static String REPLY_STOP = "stop";
	private final static String OK = "ok";
	
	public static void main (String[] args) {
		
		
		//houseLookup();
		//acceptDate();
		proposeDifferentDates();
		
	}	
	
	
	public static void houseLookup() {
		BuyerWebService buyerWs = new BuyerWebServiceService().getBuyerWebServicePort();
		
		// Setting requestContext so that session could be maintained
	    Map requestContext = ((BindingProvider)buyerWs).getRequestContext();	    
	    requestContext.put(BindingProvider.SESSION_MAINTAIN_PROPERTY,true);
	    
	    // Set request profile
	    HouseProfile houseProfile = new HouseProfile();
	    houseProfile.setHasGarden(true);
	    houseProfile.setMinPrice(0);
	    houseProfile.setMaxPrice(10000000);
	    houseProfile.setMinSquareFootage(0);
        houseProfile.setMaxSquareFootage(1000000);
        houseProfile.setMaxDistance(8000.0);

		Address address = new Address();
		address.setNation("Italy");
		address.setProvince("BO");
		address.setCity("Minerbio");
		address.setStreetName("Via Roma");
		address.setCivic("88");

		houseProfile.setAddressReference(address);
	    
	    // Send request
	    System.out.println("House request...");
	    HouseRequestReplyMessage response = buyerWs.requestHouses(houseProfile, "Bertoli");
	    List<House> proposedHouses = response.getHouseList();	    
	    
	    // Print response
	    prettyPrintHouses(proposedHouses);
	    
	    Scanner scan = new Scanner(System.in);
	    boolean stop = false;
	    
	    while (!stop) {
		    System.out.println("Select action (more, stop, accept):");
		    String s = scan.next();
		    
		    if (s.matches("stop")) {
		    	response = buyerWs.houseProposalReply(REPLY_STOP, 0);
		    	System.out.println(response.getMessage());
		    	stop = true;
		    }
		    	
		    else if (s.matches("accept")) {
		    	System.out.println("Select house number:");
			    int index = scan.nextInt();
		    	
	    		response = buyerWs.houseProposalReply(REPLY_ACCEPT, index);
	    		System.out.println(response.getMessage());
	    		
	    		if (response.getMessage().matches(OK)) 
	    			stop = true;
		    }
	    
		    else if (s.matches("more")) {
		    	response = buyerWs.houseProposalReply(REPLY_MORE, 0);
		    	System.out.println(response.getMessage());
                proposedHouses = response.getHouseList();
                // Print response
		    	prettyPrintHouses(proposedHouses);
		    }
	    }
	}
	
	
	
	
	
	public static void acceptDate() {
		
		ClientSessionServer sessionWs = new ClientSessionServerService().getClientSessionServerServicePort();
		
		Holder<String> message = new Holder<String>();
		Holder<List<SessionType>> sessions = new Holder<List<SessionType>>();
		
		System.out.println("Asking for active sessions...");
		sessionWs.getSessions("Bertoli", message, sessions);
		System.out.println("Result : " + message.value + " (" + sessions.value.size() + " sessions)");
		
		for (SessionType session : sessions.value) {
			System.out.println(sessions.value.indexOf(session));
			System.out.println("\t" + session.getState());
		}
		
		String processId = sessions.value.get(0).getProcessId();
		
		BuyerWebService buyerWs = new BuyerWebServiceService().getBuyerWebServicePort();
		List<String> sellerDateList = buyerWs.getSellerMeetingDateList(processId);
		
		MeetingProposalReplyMessage meetingReply = new MeetingProposalReplyMessage();
		meetingReply.setAcceptedDate(sellerDateList.get(0));
		meetingReply.setMessage("Ok");
		
		buyerWs.replyToMeetingProposal(
				processId,
				sellerDateList.get(0),
				null);		
	}
	
	
	
	
	
	public static void proposeDifferentDates() {
		
		ClientSessionServer sessionWs = new ClientSessionServerService().getClientSessionServerServicePort();
		
		Holder<String> message = new Holder<String>();
		Holder<List<SessionType>> sessions = new Holder<List<SessionType>>();
		
		System.out.println("Asking for active sessions...");
		sessionWs.getSessions("Bertoli", message, sessions);
		System.out.println("Result : " + message.value + " (" + sessions.value.size() + " sessions)");
		
		for (SessionType session : sessions.value) {
			System.out.println(sessions.value.indexOf(session));
			System.out.println("\t" + session.getState());
		}
		
		String processId = sessions.value.get(0).getProcessId();
		
		BuyerWebService buyerWs = new BuyerWebServiceService().getBuyerWebServicePort();
		List<String> sellerDateList = buyerWs.getSellerMeetingDateList(processId);
		
		List<String> buyerDateList = new ArrayList<String>();
		buyerDateList.add("2017.12.28 14:45");
		
		buyerWs.replyToMeetingProposal(
				processId,
				null,
				buyerDateList);
	}
	
	
	
	
	
	public static void prettyPrintHouses(List<House> proposedHouses) {
		System.out.println("Received " + proposedHouses.size() + " houses...\n");
	    for (House house: proposedHouses) {
	    	System.out.println(proposedHouses.indexOf(house));
	    	System.out.println("\t" + house.getName());
	    	System.out.println("\t" + house.getPrice() + " €");
	    	System.out.println("\t" + house.getSquareFootage() + " sq. meters");
	    	System.out.println("\t" + house.getAddress().getCity() + ", " + house.getAddress().getStreetName());
	    	System.out.println();
		}
	}
}
