package soseng.project.acme;
import java.util.ArrayList;
import java.util.List;

import javax.jws.*;

import soseng.project.utils.Address;
import soseng.project.utils.House;
import soseng.project.utils.HouseList;
import soseng.project.utils.HouseProfile;


@SuppressWarnings("restriction")
@WebService
public class BuyerWebService {
	
	public BuyerWebService () {}

	
	@WebMethod
	public ArrayList<House> requestHouses(
			@WebParam(name="houseProfile")
			HouseProfile houseProfile, 
			@WebParam(name="buyerName")
			String buyerName) {
		
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
		
		return houseList;
	}
}

