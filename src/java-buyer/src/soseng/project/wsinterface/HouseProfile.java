
package soseng.project.wsinterface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for houseProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="houseProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="minSquareFootage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxSquareFootage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="addressReference" type="{http://acme.loopingdoge.org/}houseAddress" minOccurs="0"/>
 *         &lt;element name="maxKmToAddress" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="hasGarden" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "houseProfile", propOrder = {
    "minSquareFootage",
    "maxSquareFootage",
    "minPrice",
    "maxPrice",
    "addressReference",
    "maxKmToAddress",
    "hasGarden"
})
public class HouseProfile {

    protected int minSquareFootage;
    protected int maxSquareFootage;
    protected double minPrice;
    protected double maxPrice;
    protected HouseAddress addressReference;
    protected double maxKmToAddress;
    protected boolean hasGarden;

    /**
     * Gets the value of the minSquareFootage property.
     * 
     */
    public int getMinSquareFootage() {
        return minSquareFootage;
    }

    /**
     * Sets the value of the minSquareFootage property.
     * 
     */
    public void setMinSquareFootage(int value) {
        this.minSquareFootage = value;
    }

    /**
     * Gets the value of the maxSquareFootage property.
     * 
     */
    public int getMaxSquareFootage() {
        return maxSquareFootage;
    }

    /**
     * Sets the value of the maxSquareFootage property.
     * 
     */
    public void setMaxSquareFootage(int value) {
        this.maxSquareFootage = value;
    }

    /**
     * Gets the value of the minPrice property.
     * 
     */
    public double getMinPrice() {
        return minPrice;
    }

    /**
     * Sets the value of the minPrice property.
     * 
     */
    public void setMinPrice(double value) {
        this.minPrice = value;
    }

    /**
     * Gets the value of the maxPrice property.
     * 
     */
    public double getMaxPrice() {
        return maxPrice;
    }

    /**
     * Sets the value of the maxPrice property.
     * 
     */
    public void setMaxPrice(double value) {
        this.maxPrice = value;
    }

    /**
     * Gets the value of the addressReference property.
     * 
     * @return
     *     possible object is
     *     {@link HouseAddress }
     *     
     */
    public HouseAddress getAddressReference() {
        return addressReference;
    }

    /**
     * Sets the value of the addressReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link HouseAddress }
     *     
     */
    public void setAddressReference(HouseAddress value) {
        this.addressReference = value;
    }

    /**
     * Gets the value of the maxKmToAddress property.
     * 
     */
    public double getMaxKmToAddress() {
        return maxKmToAddress;
    }

    /**
     * Sets the value of the maxKmToAddress property.
     * 
     */
    public void setMaxKmToAddress(double value) {
        this.maxKmToAddress = value;
    }

    /**
     * Gets the value of the hasGarden property.
     * 
     */
    public boolean isHasGarden() {
        return hasGarden;
    }

    /**
     * Sets the value of the hasGarden property.
     * 
     */
    public void setHasGarden(boolean value) {
        this.hasGarden = value;
    }

}
