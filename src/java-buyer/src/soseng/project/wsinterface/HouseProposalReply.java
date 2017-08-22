
package soseng.project.wsinterface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for houseProposalReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="houseProposalReply">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="replyAction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "houseProposalReply", propOrder = {
    "replyAction"
})
public class HouseProposalReply {

    protected String replyAction;

    /**
     * Gets the value of the replyAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplyAction() {
        return replyAction;
    }

    /**
     * Sets the value of the replyAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplyAction(String value) {
        this.replyAction = value;
    }

}
