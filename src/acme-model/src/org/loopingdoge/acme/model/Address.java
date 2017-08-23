package org.loopingdoge.acme.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "houseaddress")
@XmlType(name = "houseAddress")
public class Address implements Serializable {
	
	@XmlElement(name = "nation")
	private String nation;
	
	@XmlElement(name = "province")
	private String province;
	
	@XmlElement(name = "city")
	private String city;
	
	@XmlElement(name = "streetName")
	private String streetName;
	
	@XmlElement(name = "civic")
	private String civic;
	
	public Address(String nation, String province, String city, 
			String streetName, String civic) {
		this.nation = nation;
		this.province = province;
		this.city = city;
		this.streetName = streetName;
		this.civic = civic;
	}

	public Address() {
		this.nation = null;
		this.province = null;
		this.city = null;
		this.streetName = null;
		this.civic = null;
	}
	
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public void setCivic(String civic) {
		this.civic = civic;
	}
	
	
	public String getNation() {
		return nation;
	}
	
	public String getProvince() {
		return province;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public String getCivic() {
		return civic;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s", 
			this.streetName,
			this.civic,
			this.city,
			this.province,
			this.nation);
	}
	
	// Check if every field is not null
	public boolean isComplete() {
		if (nation == null || 
			nation.isEmpty() ||
			province == null || 
			province.isEmpty() ||
			city == null ||
			city.isEmpty() ||
			streetName == null ||
			streetName.isEmpty() ||
			civic == null ||
			civic.isEmpty())
			return false;
		
		return true;
	}

}
