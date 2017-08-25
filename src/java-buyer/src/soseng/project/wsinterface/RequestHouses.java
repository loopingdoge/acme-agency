
package soseng.project.wsinterface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestHouses complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestHouses"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="houseProfile" type="{http://acme.loopingdoge.org/}houseProfile" minOccurs="0"/&gt;
 *         &lt;element name="buyerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestHouses", propOrder = {
    "houseProfile",
    "buyerName"
})
public class RequestHouses {

    protected HouseProfile houseProfile;
    protected String buyerName;

    /**
     * Gets the value of the houseProfile property.
     * 
     * @return
     *     possible object is
     *     {@link HouseProfile }
     *     
     */
    public HouseProfile getHouseProfile() {
        return houseProfile;
    }

    /**
     * Sets the value of the houseProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link HouseProfile }
     *     
     */
    public void setHouseProfile(HouseProfile value) {
        this.houseProfile = value;
    }

    /**
     * Gets the value of the buyerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * Sets the value of the buyerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerName(String value) {
        this.buyerName = value;
    }

}
