package org.loopingdoge.acme.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "houseprofile")
@XmlType(name = "houseProfile")
public class HouseProfile {

	@XmlElement(name = "minSquareFootage")
	private int minSquareFootage;
	
	@XmlElement(name = "maxSquareFootage")
	private int maxSquareFootage;
	
	@XmlElement(name = "minPrice")
	private double minPrice;
	
	@XmlElement(name = "maxPrice")
	private double maxPrice;
	
	@XmlElement(name = "addressReference")
	private Address addressReference;
	
	@XmlElement(name = "maxKmToAddress")
	private double maxKmToAddress;
	
	@XmlElement(name = "hasGarden")
	private boolean hasGarden;
	
	
	public HouseProfile(int minSquareFootage, int maxSquareFootage, int minPrice, int maxPrice,
			boolean hasGarden, Address addressReference, double maxKmToAddress) {
		this.minSquareFootage = minSquareFootage;
		this.maxSquareFootage = maxSquareFootage;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.hasGarden = hasGarden;
		this.addressReference = addressReference;
		this.maxKmToAddress = maxKmToAddress;
	}
	
	public HouseProfile() {
		this.minSquareFootage = 0;
		this.maxSquareFootage = 0;
		this.minPrice = 0;
		this.maxPrice = 0;
		this.hasGarden = false;
		this.addressReference = null;
		this.maxKmToAddress = 0;
	}

}
