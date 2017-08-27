package soseng.project.seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import org.loopingdoge.acme.jolie.sessionmanager.ClientSessionServer;
import org.loopingdoge.acme.jolie.sessionmanager.ClientSessionServerService;
import org.loopingdoge.acme.jolie.sessionmanager.SessionType;

import soseng.project.wsinterface.Address;
import soseng.project.wsinterface.House;
import soseng.project.wsinterface.SellerWebService;
import soseng.project.wsinterface.SellerWebServiceService;

public class Seller {

	public static void main(String[] args) {
		
		//proposeDateForMeeting();
		//acceptBuyerDate();
		refuseBuyerDate();
				
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
		sessionWs.getSessions("Paperone", message, sessions);
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
		sessionWs.getSessions("Paperone", message, sessions);
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
		sessionWs.getSessions("Paperone", message, sessions);
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
}
