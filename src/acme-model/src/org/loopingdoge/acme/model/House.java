package org.loopingdoge.acme.model;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "house")
@XmlType(name = "house")
public class House implements Serializable {

	@XmlElement(name = "address", nillable = true)
	protected Address address;
	
	@XmlElement(name = "name", nillable = true)
	protected String name;
	
	@XmlElement(name = "sellerName", nillable = true)
	protected String sellerName; // TODO Seller class?
	
	@XmlElement(name = "squareFootage")
	protected int squareFootage;
	
	@XmlElement(name = "hasGarden")
	protected boolean hasGarden;
	
	@XmlElement(name = "price")
	protected double price;
	
	public House(Address address, String name, String sellerName,
					int squareFootage, boolean hasGarden, double price) {
		
		this.address = address;
		this.name = name;
		this.sellerName = sellerName;
		this.squareFootage = squareFootage;
		this.hasGarden = hasGarden;
		this.price = price;		
	}
	
	public House() {

		this.address = null;
		this.name = null;
		this.sellerName = null;
		this.squareFootage = 0;
		this.hasGarden = false;
		this.price = 0;		
	}
	
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	public void setSquareFootage(int squareFootage) {
		this.squareFootage = squareFootage;
	}
	
	public void setHasGarden(boolean hasGarden) {
		this.hasGarden = hasGarden;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public Address getAddress() {
		return address;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSellerName() {
		return sellerName;
	}
	
	public int getSquareFootage() {
		return squareFootage;
	}
	
	public boolean getHasGarden() {
		return hasGarden;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "\n [HOUSE]" + this.name + ", owned by: " + this.sellerName + " - " + this.address + "\n";
	}

	// Check if every field is not null
	public boolean toComplete() {
		if (this.address == null ||
			!this.address.toComplete() ||
			this.squareFootage == 0 ||
			this.price == 0 ||
			this.name == null ||
			this.name.isEmpty())
			return false;

		return true;
	}

}
