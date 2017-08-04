package soseng.project.acme;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "houseaddress")
@XmlType(name = "houseaddress")
public class HouseAddress {
	
	@XmlElement(name = "nation")
	private String nation;
	
	@XmlElement(name = "city")
	private String city;
	
	@XmlElement(name = "province")
	private String province;
	
	@XmlElement(name = "civic")
	private String civic;
	
	public HouseAddress(String nation, String city, String province, String civic) {
		this.nation = nation;
		this.city = city;
		this.province = province;
		this.civic = civic;
	}
	
	public HouseAddress() {
		this.nation = null;
		this.city = null;
		this.province = null;
		this.civic = null;
	}
	
	
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public void setCivic(String civic) {
		this.civic = civic;
	}
	
	
	public String getNation() {
		return nation;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getProvince() {
		return province;
	}
	
	public String getCivic() {
		return civic;
	}

}
