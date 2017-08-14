package soseng.project.acme;
import java.util.List;

import javax.jws.*;

import soseng.project.utils.House;


@SuppressWarnings("restriction")
@WebService
public class SellerWebService {
	
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
			House house, 
			@WebParam(name="sellerName")
			String sellerName) {
		
		if (house != null && house.isComplete()) 
			return "Your house '" + house.getName() + "' is accepted";
		else
			return "Proposal refused: data is missing";
	}
}

