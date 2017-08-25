
package soseng.project.wsinterface;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soseng.project.wsinterface package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProposeHouseResponse_QNAME = new QName("http://acme.loopingdoge.org/", "proposeHouseResponse");
    private final static QName _ProposeHouse_QNAME = new QName("http://acme.loopingdoge.org/", "proposeHouse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soseng.project.wsinterface
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProposeHouseResponse }
     * 
     */
    public ProposeHouseResponse createProposeHouseResponse() {
        return new ProposeHouseResponse();
    }

    /**
     * Create an instance of {@link ProposeHouse }
     * 
     */
    public ProposeHouse createProposeHouse() {
        return new ProposeHouse();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link House }
     * 
     */
    public House createHouse() {
        return new House();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProposeHouseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "proposeHouseResponse")
    public JAXBElement<ProposeHouseResponse> createProposeHouseResponse(ProposeHouseResponse value) {
        return new JAXBElement<ProposeHouseResponse>(_ProposeHouseResponse_QNAME, ProposeHouseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProposeHouse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "proposeHouse")
    public JAXBElement<ProposeHouse> createProposeHouse(ProposeHouse value) {
        return new JAXBElement<ProposeHouse>(_ProposeHouse_QNAME, ProposeHouse.class, null, value);
    }

}
