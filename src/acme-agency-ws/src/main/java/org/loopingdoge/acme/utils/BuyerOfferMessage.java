package org.loopingdoge.acme.utils;

import org.loopingdoge.acme.model.House;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;


@SuppressWarnings("restriction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "BuyerOfferMessage")
@XmlType(name = "BuyerOfferMessage")
public class BuyerOfferMessage {

    @XmlElement(name = "buyerName")
    private String buyerName;

    @XmlElement(name = "buyerOffer")
    private Double buyerOffer;
    
    @XmlElement(name = "chosenHouse")
    private House chosenHouse;

    public BuyerOfferMessage() {
        this.buyerName = null;
        this.buyerOffer = null;
        this.chosenHouse = null;
    }

    public BuyerOfferMessage(String buyerName, Double buyerOffer, House chosenHouse) {
    	this.buyerName = buyerName;
        this.buyerOffer = buyerOffer;
        this.chosenHouse = chosenHouse;
    }

    public String getBuyerName() {
		return buyerName;
	}
    
    public double getBuyerOffer() {
		return buyerOffer;
	}
    
    public House getChosenHouse() {
		return chosenHouse;
	}
    
    public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
    
    public void setBuyerOffer(double buyerOffer) {
		this.buyerOffer = buyerOffer;
	}
    
    public void setChosenHouse(House chosenHouse) {
		this.chosenHouse = chosenHouse;
	}
}
