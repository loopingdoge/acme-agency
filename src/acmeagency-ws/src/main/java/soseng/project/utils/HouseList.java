package soseng.project.utils;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "houselist")
@XmlType(name = "HouseList")
public class HouseList {
	
	@XmlElement(name = "list")
	private ArrayList<House> list;
	
	public HouseList() {
		this.list = new ArrayList<House>();
	}
	
	
	public ArrayList<House> getList() {
		return list;
	}
	
	public void setList(ArrayList<House> list) {
		this.list = list;
	}
	
	
	public void add(House house) {
		list.add(house);
	}

}
