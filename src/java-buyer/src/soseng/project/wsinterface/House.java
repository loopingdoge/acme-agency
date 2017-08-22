
package soseng.project.wsinterface;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for house complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="house">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://acme.loopingdoge.org/}houseAddress" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sellerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="squareFootage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hasGarden" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "house", propOrder = {
    "address",
    "name",
    "sellerName",
    "squareFootage",
    "hasGarden",
    "price"
})
public class House {

    @XmlElementRef(name = "address", type = JAXBElement.class, required = false)
    protected JAXBElement<HouseAddress> address;
    @XmlElementRef(name = "name", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "sellerName", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sellerName;
    protected int squareFootage;
    protected boolean hasGarden;
    protected double price;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link HouseAddress }{@code >}
     *     
     */
    public JAXBElement<HouseAddress> getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link HouseAddress }{@code >}
     *     
     */
    public void setAddress(JAXBElement<HouseAddress> value) {
        this.address = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = value;
    }

    /**
     * Gets the value of the sellerName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSellerName() {
        return sellerName;
    }

    /**
     * Sets the value of the sellerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSellerName(JAXBElement<String> value) {
        this.sellerName = value;
    }

    /**
     * Gets the value of the squareFootage property.
     * 
     */
    public int getSquareFootage() {
        return squareFootage;
    }

    /**
     * Sets the value of the squareFootage property.
     * 
     */
    public void setSquareFootage(int value) {
        this.squareFootage = value;
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
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

}
