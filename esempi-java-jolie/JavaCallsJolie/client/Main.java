import java.util.ArrayList;
import java.util.List;

import jolie.it.ServiceForJava;
import jolie.it.ServiceForJavaService;


public class Main {

	public static void main(String[] args) {
		
		ServiceForJavaService service = new ServiceForJavaService();
		ServiceForJava server = service.getServiceForJavaServicePort();
		
		System.out.println(server.sum(10.0, 11.5));		
		
		List<String> stringList = new ArrayList<String>();
		stringList.add("Uno");
		stringList.add("Due");
		
		System.out.println(server.concatenate((java.util.List<String>) stringList));

	}

}
