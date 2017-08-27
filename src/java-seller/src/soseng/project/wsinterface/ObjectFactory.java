
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
    private final static QName _ConfirmMeetingResponse_QNAME = new QName("http://acme.loopingdoge.org/", "confirmMeetingResponse");
    private final static QName _SendAvailabilityResponse_QNAME = new QName("http://acme.loopingdoge.org/", "sendAvailabilityResponse");
    private final static QName _GetBuyerMeetingDateListResponse_QNAME = new QName("http://acme.loopingdoge.org/", "getBuyerMeetingDateListResponse");
    private final static QName _SendAvailability_QNAME = new QName("http://acme.loopingdoge.org/", "sendAvailability");
    private final static QName _ConfirmMeeting_QNAME = new QName("http://acme.loopingdoge.org/", "confirmMeeting");
    private final static QName _GetBuyerMeetingDateList_QNAME = new QName("http://acme.loopingdoge.org/", "getBuyerMeetingDateList");
    private final static QName _ProposeHouse_QNAME = new QName("http://acme.loopingdoge.org/", "proposeHouse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soseng.project.wsinterface
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendAvailabilityResponse }
     * 
     */
    public SendAvailabilityResponse createSendAvailabilityResponse() {
        return new SendAvailabilityResponse();
    }

    /**
     * Create an instance of {@link ProposeHouseResponse }
     * 
     */
    public ProposeHouseResponse createProposeHouseResponse() {
        return new ProposeHouseResponse();
    }

    /**
     * Create an instance of {@link ConfirmMeetingResponse }
     * 
     */
    public ConfirmMeetingResponse createConfirmMeetingResponse() {
        return new ConfirmMeetingResponse();
    }

    /**
     * Create an instance of {@link GetBuyerMeetingDateList }
     * 
     */
    public GetBuyerMeetingDateList createGetBuyerMeetingDateList() {
        return new GetBuyerMeetingDateList();
    }

    /**
     * Create an instance of {@link ConfirmMeeting }
     * 
     */
    public ConfirmMeeting createConfirmMeeting() {
        return new ConfirmMeeting();
    }

    /**
     * Create an instance of {@link ProposeHouse }
     * 
     */
    public ProposeHouse createProposeHouse() {
        return new ProposeHouse();
    }

    /**
     * Create an instance of {@link GetBuyerMeetingDateListResponse }
     * 
     */
    public GetBuyerMeetingDateListResponse createGetBuyerMeetingDateListResponse() {
        return new GetBuyerMeetingDateListResponse();
    }

    /**
     * Create an instance of {@link SendAvailability }
     * 
     */
    public SendAvailability createSendAvailability() {
        return new SendAvailability();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmMeetingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "confirmMeetingResponse")
    public JAXBElement<ConfirmMeetingResponse> createConfirmMeetingResponse(ConfirmMeetingResponse value) {
        return new JAXBElement<ConfirmMeetingResponse>(_ConfirmMeetingResponse_QNAME, ConfirmMeetingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendAvailabilityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "sendAvailabilityResponse")
    public JAXBElement<SendAvailabilityResponse> createSendAvailabilityResponse(SendAvailabilityResponse value) {
        return new JAXBElement<SendAvailabilityResponse>(_SendAvailabilityResponse_QNAME, SendAvailabilityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBuyerMeetingDateListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "getBuyerMeetingDateListResponse")
    public JAXBElement<GetBuyerMeetingDateListResponse> createGetBuyerMeetingDateListResponse(GetBuyerMeetingDateListResponse value) {
        return new JAXBElement<GetBuyerMeetingDateListResponse>(_GetBuyerMeetingDateListResponse_QNAME, GetBuyerMeetingDateListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendAvailability }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "sendAvailability")
    public JAXBElement<SendAvailability> createSendAvailability(SendAvailability value) {
        return new JAXBElement<SendAvailability>(_SendAvailability_QNAME, SendAvailability.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmMeeting }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "confirmMeeting")
    public JAXBElement<ConfirmMeeting> createConfirmMeeting(ConfirmMeeting value) {
        return new JAXBElement<ConfirmMeeting>(_ConfirmMeeting_QNAME, ConfirmMeeting.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBuyerMeetingDateList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "getBuyerMeetingDateList")
    public JAXBElement<GetBuyerMeetingDateList> createGetBuyerMeetingDateList(GetBuyerMeetingDateList value) {
        return new JAXBElement<GetBuyerMeetingDateList>(_GetBuyerMeetingDateList_QNAME, GetBuyerMeetingDateList.class, null, value);
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
