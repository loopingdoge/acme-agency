
package soseng.project.wsinterface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for confirmMeeting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="confirmMeeting">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="processId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accept" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="accepedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "confirmMeeting", propOrder = {
    "processId",
    "accept",
    "accepedDate"
})
public class ConfirmMeeting {

    protected String processId;
    protected boolean accept;
    protected String accepedDate;

    /**
     * Gets the value of the processId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * Sets the value of the processId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessId(String value) {
        this.processId = value;
    }

    /**
     * Gets the value of the accept property.
     * 
     */
    public boolean isAccept() {
        return accept;
    }

    /**
     * Sets the value of the accept property.
     * 
     */
    public void setAccept(boolean value) {
        this.accept = value;
    }

    /**
     * Gets the value of the accepedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccepedDate() {
        return accepedDate;
    }

    /**
     * Sets the value of the accepedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccepedDate(String value) {
        this.accepedDate = value;
    }

}
