package it.ex.joliecallsjava;
import javax.jws.*;

@SuppressWarnings("restriction")
@WebService
public class HelloService {
	private final String helloString = "Hello ";
	
	public HelloService () {}

	@WebMethod
	public String sayHello(String name) {
		return helloString + name;
	}
	
	
}
