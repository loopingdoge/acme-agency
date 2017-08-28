package org.loopingdoge.acme.utils;

import org.loopingdoge.acme.model.House;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;


@SuppressWarnings("restriction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "HouseRequestReplyMessage")
@XmlType(name = "HouseRequestReplyMessage")
public class HouseRequestReplyMessage {

    @XmlElement(name = "houseList")
    private ArrayList<House> houseList;

    @XmlElement(name = "message")
    private String message;

    public HouseRequestReplyMessage() {
        this.houseList = null;
        this.message = null;
    }

    public HouseRequestReplyMessage(ArrayList<House> houseList, String message) {
        this.houseList = houseList;
        this.message = message;
    }

    public void setHouseList(ArrayList<House> houseList) {
        this.houseList = houseList;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public ArrayList<House> getHouseList() {
        return this.houseList;
    }

    public String getMessage() {
        return this.message;
    }
}
