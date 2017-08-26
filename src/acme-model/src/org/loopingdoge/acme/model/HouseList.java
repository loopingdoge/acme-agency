package org.loopingdoge.acme.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "houselist")
@XmlType(name = "HouseList")
public class HouseList {
	
	@XmlElement(name = "list")
	protected ArrayList<House> list;
	
	public HouseList() {
		this.list = new ArrayList<House>();
	}

	public HouseList(List<House> houseList) {
		list = new ArrayList<>(houseList);
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
