
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
 * &lt;complexType name="houseProfile"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="addressReference" type="{http://acme.loopingdoge.org/}address" minOccurs="0"/&gt;
 *         &lt;element name="hasGarden" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="maxDistance" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="maxPrice" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="maxSquareFootage" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="minPrice" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="minSquareFootage" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "houseProfile", propOrder = {
    "addressReference",
    "hasGarden",
    "maxDistance",
    "maxPrice",
    "maxSquareFootage",
    "minPrice",
    "minSquareFootage"
})
public class HouseProfile {

    protected Address addressReference;
    protected boolean hasGarden;
    protected double maxDistance;
    protected double maxPrice;
    protected int maxSquareFootage;
    protected double minPrice;
    protected int minSquareFootage;

    /**
     * Gets the value of the addressReference property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddressReference() {
        return addressReference;
    }

    /**
     * Sets the value of the addressReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddressReference(Address value) {
        this.addressReference = value;
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

    /**
     * Gets the value of the maxDistance property.
     * 
     */
    public double getMaxDistance() {
        return maxDistance;
    }

    /**
     * Sets the value of the maxDistance property.
     * 
     */
    public void setMaxDistance(double value) {
        this.maxDistance = value;
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

}
