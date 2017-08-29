package soseng.project.buyer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.loopingdoge.acme.jolie.bank.BankService;
import org.loopingdoge.acme.jolie.bank.BankServiceService;
import org.loopingdoge.acme.jolie.sessionmanager.ClientSessionServer;
import org.loopingdoge.acme.jolie.sessionmanager.ClientSessionServerService;
import org.loopingdoge.acme.jolie.sessionmanager.SessionType;

import soseng.project.wsinterface.*;

public class Buyer {
	
	private final static String USER = "BERTOLI";
	private final static String BANK_IBAN = "IT88T1927501600001011018000";
	private final static String BANK_PASSWORD = "qwerty";
	
	private final static String REPLY_ACCEPT = "accept";
	private final static String REPLY_MORE = "more";
	private final static String REPLY_STOP = "stop";
	private final static String OK = "ok";
	
	/* Session wait states */
	public static final String WAIT_BUYER_MEETING_RESPONSE = "WaitingForBuyerMeetingResponse";
	public static final String WAIT_FOR_BUYER_OFFER = "WaitingForBuyerOffer";
	
    public static void main (String[] args) {
		
		interactiveMain();
		
		//houseLookup();
		//acceptDate();
		//proposeDifferentDates();
		
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
		address.setCap("40061");
		address.setStreetName("Via Roma");
		address.setCivic("88");

		houseProfile.setAddressReference(address);
	    
	    // Send request
	    System.out.println("House request...");
	    HouseRequestReplyMessage response = buyerWs.requestHouses(houseProfile, USER);
	    List<House> proposedHouses = response.getHouseList();	    
	    
	    // Print response
	    prettyPrintHouses(proposedHouses);
	    
	    Scanner scan = new Scanner(System.in);
	    boolean stop = false;
	    
	    while (!stop) {
		    System.out.println("Select action (more, stop, accept):");
		    String s = scan.next();
		    
		    if (s.matches(REPLY_STOP)) {
		    	response = buyerWs.houseProposalReply(REPLY_STOP, 0);
		    	System.out.println(response.getMessage());
		    	stop = true;
		    }
		    	
		    else if (s.matches(REPLY_ACCEPT)) {
		    	System.out.println("Select house number:");
			    int index = scan.nextInt();
		    	
	    		response = buyerWs.houseProposalReply(REPLY_ACCEPT, index);
	    		System.out.println(response.getMessage());
	    		
	    		if (response.getMessage().matches(OK)) 
	    			stop = true;
		    }
	    
		    else if (s.matches(REPLY_MORE)) {
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
		sessionWs.getSessions(USER, message, sessions);
		System.out.println("Result : " + message.value + " (" + sessions.value.size() + " sessions)");
		
		for (SessionType session : sessions.value) {
			System.out.println(sessions.value.indexOf(session));
			System.out.println("\t" + session.getState());
		}
		
		String processId = sessions.value.get(0).getProcessId();
		
		BuyerWebService buyerWs = new BuyerWebServiceService().getBuyerWebServicePort();
		List<String> sellerDateList = buyerWs.getSellerMeetingDateList(processId);
		
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
		sessionWs.getSessions(USER, message, sessions);
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
	
	
	
	public static void interactiveMain() {
		Scanner scan = new Scanner(System.in);
		boolean done = false;
		
		while (!done) {
			System.out.println("Select action (lookup or sessions):");
			String action = scan.next();
			
			if (action.matches("lookup")) {
				houseLookup();
			}
			
			else if (action.matches("sessions")) {
				getSessions();
			}
			
			System.out.println();
		}
	}
	
	public static void getSessions() {
		ClientSessionServer sessionWs = new ClientSessionServerService().getClientSessionServerServicePort();
		
		Holder<String> message = new Holder<String>();
		Holder<List<SessionType>> sessions = new Holder<List<SessionType>>();
		
		System.out.println("\nAsking for active sessions...");
		sessionWs.getSessions(USER, message, sessions);
		System.out.println("Result : " + message.value + " (" + sessions.value.size() + " active sessions)");
		
		for (SessionType session : sessions.value) {
			System.out.println(sessions.value.indexOf(session));
			System.out.println("\t" + session.getState());
		}
		
		if (sessions.value.size() > 0) {
			Scanner scan = new Scanner(System.in);
			System.out.println("\nSelect session to continue...");
			int sessionIndex = scan.nextInt();
			if (sessions.value.size() <= sessionIndex) {
				System.out.println("Out of bounds");
				return;
			}
			
			continueSession(sessions.value.get(sessionIndex));
			
		}
	}
	
	
	
	public static void continueSession(SessionType session) {
		
		if (session.getState().matches(WAIT_BUYER_MEETING_RESPONSE)) {
			BuyerWebService buyerWs = new BuyerWebServiceService().getBuyerWebServicePort();
			List<String> sellerDateList = buyerWs.getSellerMeetingDateList(session.getProcessId());
			
			System.out.println("Seller proposed dates:\n");
			for (String d : sellerDateList) {
				System.out.println(sellerDateList.indexOf(d));
				System.out.println("\t" + d);
			}
			
			System.out.println("Select action (accept or propose)");
			Scanner scan = new Scanner(System.in);
			String action = scan.next();
			
			if (action.matches("accept")) {			
				String res = buyerWs.replyToMeetingProposal(
						session.getProcessId(),
						sellerDateList.get(0),
						null);	
				System.out.println(res);
			}
			
			else if (action.matches("propose")) {
				List<String> buyerDateList = new ArrayList<String>();
				buyerDateList.add("2017.12.28 14:45");
				
				String res = buyerWs.replyToMeetingProposal(
						session.getProcessId(),
						null,
						buyerDateList);
				System.out.println(res);
			}
			
			else 
				System.out.println("Error");
		}
		
		else if (session.getState().matches(WAIT_FOR_BUYER_OFFER)) {
			BuyerWebService buyerWs = new BuyerWebServiceService().getBuyerWebServicePort();
			
			System.out.println("Request loan? (yes or no)");
			Scanner scan = new Scanner(System.in);
			String action = scan.next();
			
			if (action.matches("yes")) {
				BankService bankWs = new BankServiceService().getBankServiceServicePort();
				
				Holder<String> sid = new Holder<String>();
				Holder<Boolean> error = new Holder<Boolean>();
				
				// bank login
				bankWs.login(
                        BANK_PASSWORD,
                        USER,
						error,
                        sid);

				if (!error.value) {
				
					boolean loanPerformed = bankWs.loan(10000, sid.value);
					
					if (loanPerformed) {
						System.out.println("Loan accepted");
						String res = buyerWs.makeOffer(session.getProcessId(), 100000);
						System.out.println(res);
					}
					else 
						System.out.println("Loan refused");
				}
			}
			
			else if (action.matches("no")) {
				String res = buyerWs.makeOffer(session.getProcessId(), 100000);
				System.out.println(res);
			}
			
		}
		
		else {
			System.out.println("Unknown state");
		}
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
