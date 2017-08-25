package soseng.project.seller;

import soseng.project.wsinterface.Address;
import soseng.project.wsinterface.House;
import soseng.project.wsinterface.SellerWebService;
import soseng.project.wsinterface.SellerWebServiceService;

public class Seller {

	public static void main(String[] args) {
		
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
}
