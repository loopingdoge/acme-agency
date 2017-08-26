package org.loopingdoge.acme.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "houseaddress")
@XmlType(name = "houseAddress")
public class Address {

	@XmlElement(name = "streetName")
	protected String streetName;

	@XmlElement(name = "civic")
	protected String civic;

	@XmlElement(name = "city")
	protected String city;

	@XmlElement(name = "cap")
	protected String cap;
	
	@XmlElement(name = "province")
	protected String province;

	@XmlElement(name = "nation")
	protected String nation;
	
	public Address(String streetName, String civic, String city, String cap, String province, String nation) {
		this.nation = nation;
		this.province = province;
		this.city = city;
		this.streetName = streetName;
		this.civic = civic;
		this.cap = cap;
	}

	public Address() {
		this.nation = null;
		this.province = null;
		this.city = null;
		this.streetName = null;
		this.civic = null;
		this.cap = null;
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

	public void setCap(String cap) {
		this.cap = cap;
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

	public String getCap() {
		return cap;
	}

	public String toCadastreFormat() {
		return String.format("%s;%s;%s;%s;%s;%s",
				this.streetName,
				this.civic,
				this.city,
				this.cap,
				this.province,
				this.nation
		);
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s, %s",
			this.streetName,
			this.civic,
			this.city,
			this.cap,
			this.province,
			this.nation
		);
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
			civic.isEmpty() ||
			cap == null ||
			cap.isEmpty())
			return false;
		
		return true;
	}

}
