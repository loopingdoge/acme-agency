package it.ex.restapitest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("first")
public class FirstService {
     
    @GET
    @Path("{name}")
    public String test(@PathParam("name") String name) {
        return "Hello " + name.toUpperCase();
    }
}