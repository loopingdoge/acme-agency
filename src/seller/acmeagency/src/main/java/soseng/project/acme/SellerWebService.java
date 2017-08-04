package soseng.project.acme;
import java.util.List;

import javax.jws.*;


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
	
	/*@WebMethod
	public String proposeHouse(
			@WebParam(name="house")
			House house, 
			@WebParam(name="sellerName")
			String sellerName) {
		
		return "Accepted";
	}*/
	
	@WebMethod
	public String proposeHouse(
			@WebParam(name="address")
			HouseAddress address, 
			@WebParam(name="sellerName")
			String sellerName) {
		
		if (address != null) 
			return "Your house at " + address.getCity() + " is accepted";
		
		else
			return "Proposal refused";
	}
}

