package soseng.project.buyer;

import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import soseng.project.wsinterface.BuyerWebService;
import soseng.project.wsinterface.BuyerWebServiceService;
import soseng.project.wsinterface.House;
import soseng.project.wsinterface.HouseProfile;
import soseng.project.wsinterface.HouseRequestReplyMessage;

public class Buyer {
	
	private final static String REPLY_ACCEPT = "accept";
	private final static String REPLY_MORE = "more";
	private final static String REPLY_STOP = "stop";
	
	public static void main (String[] args) {
		
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
	    
	    // Send request
	    System.out.println("House request...");
	    HouseRequestReplyMessage response = buyerWs.requestHouses(houseProfile, "Test Username");
	    List<House> proposedHouses = response.getHouseList();	    
	    
	    // Print response
	    System.out.println("Received " + proposedHouses.size() + " houses...\n");
	    for (House house: proposedHouses) {
	    	System.out.println(proposedHouses.indexOf(house));
	    	System.out.println("\t" + house.getName().getValue());
	    	System.out.println("\t" + house.getPrice() + " €");
	    	System.out.println("\t" + house.getSquareFootage() + " sq. meters");
	    	System.out.println("\t" + house.getAddress().getValue().getCity() + ", " + house.getAddress().getValue().getStreetName());
	    	System.out.println();
	    }
	    
	    response = buyerWs.houseProposalReply(REPLY_MORE);
	    
	    // Print response
	    System.out.println("Received " + proposedHouses.size() + " houses...\n");
	    for (House house: proposedHouses) {
	    	System.out.println(proposedHouses.indexOf(house));
	    	System.out.println("\t" + house.getName().getValue());
	    	System.out.println("\t" + house.getPrice() + " €");
	    	System.out.println("\t" + house.getSquareFootage() + " sq. meters");
	    	System.out.println("\t" + house.getAddress().getValue().getCity() + ", " + house.getAddress().getValue().getStreetName());
	    	System.out.println();
	    }
	}
}
