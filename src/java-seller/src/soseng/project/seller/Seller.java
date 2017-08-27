package soseng.project.seller;

import java.util.List;

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
		
		requestSessions();
				
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
	
	public static void requestSessions() {
		
		ClientSessionServer sessionWs = new ClientSessionServerService().getClientSessionServerServicePort();
		
		Holder<String> message = new Holder<String>();
		Holder<List<SessionType>> sessions = new Holder<List<SessionType>>();
		
		System.out.println("Asking for active sessions...");
		sessionWs.getSessions("TestUser", message, sessions);
		System.out.println("Result : " + message.value + " (" + sessions.value.size() + " sessions)");
		
		for (SessionType session : sessions.value) {
			System.out.println(sessions.value.indexOf(session));
			System.out.println("\t" + session.getState());
		}
		
	}
}
