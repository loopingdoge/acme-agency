package it.ex.restapitest.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("second")
public class SecondService {
     
	@GET
    public String getValues() {
        return "Should return all values";
    }

    @GET
    @Path("/{orderId}")
    public String getValueById(
            @PathParam("orderId") String orderId) {
        return "Should return value with id " + orderId;
    }
    
    @POST
    public String createValue( @FormParam("name") String name) {
    	if (name == null) {
    		return "Should create value (no name specified)";
    	}
    	else 
    		return "Should create value, named " + name;
    }
}