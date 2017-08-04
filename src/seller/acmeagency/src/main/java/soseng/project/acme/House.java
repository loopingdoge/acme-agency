package soseng.project.acme;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "House")
public class House {

	
	@XmlElement(name = "address")
	private HouseAddress address;
	
	@XmlElement(name = "name")
	private String name;
	
	@XmlElement(name = "sellerName")
	private String sellerName; // TODO Seller class?
	
	@XmlElement(name = "squareFootage")
	private int squareFootage;
	
	@XmlElement(name = "hasGarden")
	private boolean hasGarden;
	
	@XmlElement(name = "price")
	private double price;
	
	public House(HouseAddress address, String name, String sellerName,
					int squareFootage, boolean hasGarden, double price) {
		
		this.address = address;
		this.name = name;
		this.sellerName = sellerName;
		this.squareFootage = squareFootage;
		this.hasGarden = hasGarden;
		this.price = price;
		
	}

}
