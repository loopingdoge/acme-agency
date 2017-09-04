package soseng.project.seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import org.loopingdoge.acme.jolie.sessionmanager.ClientSessionServer;
import org.loopingdoge.acme.jolie.sessionmanager.ClientSessionServerService;
import org.loopingdoge.acme.jolie.sessionmanager.SessionType;

import soseng.project.wsinterface.Address;
import soseng.project.wsinterface.BuyerOfferMessage;
import soseng.project.wsinterface.House;
import soseng.project.wsinterface.SellerWebService;
import soseng.project.wsinterface.SellerWebServiceService;

public class Seller {
	
	private final static String USER = "Paperone";
	
	/* Session wait states */
	public static final String WAIT_SELLER_AVAILABILITY = "WaitingForSellerAvailabilityDates";
    public static final String WAIT_SELLER_MEETING_RESPONSE = "WaitingForSellerMeetingResponse";
    public static final String WAIT_SELLER_OFFER_REPLY = "WaitingForSellerOfferReply";

	public static void main(String[] args) {
		
		interactiveMain();
	
	}
	
	
	public static void proposeNewHouse() {
		SellerWebService sellerWs = new SellerWebServiceService().getSellerWebServicePort();
		
		House house = new House();
		
		house.setName("Casa Aggiunta");
		house.setHasGarden(false);
		house.setSquareFootage(150);
		house.setPrice(200000);
		
		Address address = new Address();
		address.setNation("Italia");
		address.setProvince("MO");
		address.setCity("Modena");
		address.setCap("41100");
		address.setStreetName("Via Emilia Ovest");
		address.setCivic("12");
		
		house.setAddress(address); 
		
		System.out.println("Proposing house...");
		String ret = sellerWs.proposeHouse(house);
		System.out.println(ret); 
	}
	
	
	
	
	public static void proposeDateForMeeting() {
		
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
		
		SellerWebService sellerWs = new SellerWebServiceService().getSellerWebServicePort();
		
		ArrayList<String> dateList = new ArrayList<String>();
		
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyy.MM.dd HH:mm");
		try {
			date = new SimpleDateFormat("yyy.MM.dd HH:mm").parse("2017.12.11 18:30");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dateList.add(dateFormat.format(date));
		
		sellerWs.sendAvailability(sessions.value.get(0).getProcessId(), dateList);
	}
	
	
	
	
	public static void acceptBuyerDate() {
		
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
		
		SellerWebService sellerWs = new SellerWebServiceService().getSellerWebServicePort();
		
		List<String> buyerDateList = sellerWs.getBuyerMeetingDateList(sessions.value.get(0).getProcessId());
		
		sellerWs.confirmMeeting(
				sessions.value.get(0).getProcessId(), 
				true, 
				buyerDateList.get(0));
	}


	public static void refuseBuyerDate() {
	
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
		
		SellerWebService sellerWs = new SellerWebServiceService().getSellerWebServicePort();
		
		List<String> buyerDateList = sellerWs.getBuyerMeetingDateList(sessions.value.get(0).getProcessId());
		
		sellerWs.confirmMeeting(
				sessions.value.get(0).getProcessId(), 
				false, 
				null);
	}
	
	
	
	
	
	public static void interactiveMain() {
		Scanner scan = new Scanner(System.in);
		boolean done = false;
		
		while (!done) {
			System.out.println("Select action (propose or sessions):");
			String action = scan.next();
			
			if (action.matches("propose")) {
				proposeNewHouse();
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
		
		if (session.getState().matches(WAIT_SELLER_AVAILABILITY)) {
			SellerWebService sellerWs = new SellerWebServiceService().getSellerWebServicePort();
			
			ArrayList<String> dateList = new ArrayList<String>();
			
			Date date = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyy.MM.dd HH:mm");
			try {
				date = new SimpleDateFormat("yyy.MM.dd HH:mm").parse("2017.12.11 18:30");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			dateList.add(dateFormat.format(date));
			
			String res = sellerWs.sendAvailability(session.getProcessId(), dateList);
			System.out.println(res);
		}
		
		else if (session.getState().matches(WAIT_SELLER_MEETING_RESPONSE)) {
			SellerWebService sellerWs = new SellerWebServiceService().getSellerWebServicePort();
			
			List<String> buyerDateList = sellerWs.getBuyerMeetingDateList(session.getProcessId());
			
			System.out.println("Buyer proposed dates:\n");
			for (String d : buyerDateList) {
				System.out.println(buyerDateList.indexOf(d));
				System.out.println("\t" + d);
			}
			
			System.out.println("Select action (accept or refuse)");
			Scanner scan = new Scanner(System.in);
			String action = scan.next();
			
			if (action.matches("accept")) {			
				String res = sellerWs.confirmMeeting(
						session.getProcessId(), 
						true, 
						buyerDateList.get(0));
				System.out.println(res);
			}
			
			else if (action.matches("refuse")) {			
				String res = sellerWs.confirmMeeting(
						session.getProcessId(), 
						false, 
						null);
				System.out.println(res);
			}
		}
		
		else if (session.getState().matches(WAIT_SELLER_OFFER_REPLY)) {
			SellerWebService sellerWs = new SellerWebServiceService().getSellerWebServicePort();	
			BuyerOfferMessage offer = sellerWs.getOffer(session.getProcessId());
			
			System.out.println("\n" + offer.getBuyerName() + " ha offerto " + offer.getBuyerOffer());
			System.out.println("Select action (accept or refuse)");
			Scanner scan = new Scanner(System.in);
			String action = scan.next();
			
			if (action.matches("accept")) {			
				String res = sellerWs.offerReply(session.getProcessId(), true);
				System.out.println(res);
			}
			
			else if (action.matches("refuse")) {			
				String res = sellerWs.offerReply(session.getProcessId(), false);
				System.out.println(res);
			}
		}
		
		else {
			System.out.println("Unknown state");
		}
	}
}
