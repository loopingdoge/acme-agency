
package org.loopingdoge.acme.jolie.cadastre;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Coordinate complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Coordinate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nord" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="east" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Coordinate", propOrder = {
    "nord",
    "east"
})
public class Coordinate {

    @XmlElement(required = true)
    protected String nord;
    @XmlElement(required = true)
    protected String east;

    /**
     * Recupera il valore della proprietà nord.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNord() {
        return nord;
    }

    /**
     * Imposta il valore della proprietà nord.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNord(String value) {
        this.nord = value;
    }

    /**
     * Recupera il valore della proprietà east.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEast() {
        return east;
    }

    /**
     * Imposta il valore della proprietà east.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEast(String value) {
        this.east = value;
    }

}
