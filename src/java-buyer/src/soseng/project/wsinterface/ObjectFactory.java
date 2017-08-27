
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

    private final static QName _HouseRequestReplyMessage_QNAME = new QName("http://acme.loopingdoge.org/", "HouseRequestReplyMessage");
    private final static QName _ReplyToMeetingProposalResponse_QNAME = new QName("http://acme.loopingdoge.org/", "replyToMeetingProposalResponse");
    private final static QName _HouseProposalReplyResponse_QNAME = new QName("http://acme.loopingdoge.org/", "houseProposalReplyResponse");
    private final static QName _RequestHouses_QNAME = new QName("http://acme.loopingdoge.org/", "requestHouses");
    private final static QName _ReplyToMeetingProposal_QNAME = new QName("http://acme.loopingdoge.org/", "replyToMeetingProposal");
    private final static QName _GetSellerMeetingDateList_QNAME = new QName("http://acme.loopingdoge.org/", "getSellerMeetingDateList");
    private final static QName _HouseProposalReply_QNAME = new QName("http://acme.loopingdoge.org/", "houseProposalReply");
    private final static QName _RequestHousesResponse_QNAME = new QName("http://acme.loopingdoge.org/", "requestHousesResponse");
    private final static QName _GetSellerMeetingDateListResponse_QNAME = new QName("http://acme.loopingdoge.org/", "getSellerMeetingDateListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soseng.project.wsinterface
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestHouses }
     * 
     */
    public RequestHouses createRequestHouses() {
        return new RequestHouses();
    }

    /**
     * Create an instance of {@link HouseProposalReplyResponse }
     * 
     */
    public HouseProposalReplyResponse createHouseProposalReplyResponse() {
        return new HouseProposalReplyResponse();
    }

    /**
     * Create an instance of {@link ReplyToMeetingProposal }
     * 
     */
    public ReplyToMeetingProposal createReplyToMeetingProposal() {
        return new ReplyToMeetingProposal();
    }

    /**
     * Create an instance of {@link GetSellerMeetingDateList }
     * 
     */
    public GetSellerMeetingDateList createGetSellerMeetingDateList() {
        return new GetSellerMeetingDateList();
    }

    /**
     * Create an instance of {@link HouseRequestReplyMessage }
     * 
     */
    public HouseRequestReplyMessage createHouseRequestReplyMessage() {
        return new HouseRequestReplyMessage();
    }

    /**
     * Create an instance of {@link ReplyToMeetingProposalResponse }
     * 
     */
    public ReplyToMeetingProposalResponse createReplyToMeetingProposalResponse() {
        return new ReplyToMeetingProposalResponse();
    }

    /**
     * Create an instance of {@link GetSellerMeetingDateListResponse }
     * 
     */
    public GetSellerMeetingDateListResponse createGetSellerMeetingDateListResponse() {
        return new GetSellerMeetingDateListResponse();
    }

    /**
     * Create an instance of {@link HouseProposalReply }
     * 
     */
    public HouseProposalReply createHouseProposalReply() {
        return new HouseProposalReply();
    }

    /**
     * Create an instance of {@link RequestHousesResponse }
     * 
     */
    public RequestHousesResponse createRequestHousesResponse() {
        return new RequestHousesResponse();
    }

    /**
     * Create an instance of {@link HouseProfile }
     * 
     */
    public HouseProfile createHouseProfile() {
        return new HouseProfile();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link HouseRequestReplyMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "HouseRequestReplyMessage")
    public JAXBElement<HouseRequestReplyMessage> createHouseRequestReplyMessage(HouseRequestReplyMessage value) {
        return new JAXBElement<HouseRequestReplyMessage>(_HouseRequestReplyMessage_QNAME, HouseRequestReplyMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReplyToMeetingProposalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "replyToMeetingProposalResponse")
    public JAXBElement<ReplyToMeetingProposalResponse> createReplyToMeetingProposalResponse(ReplyToMeetingProposalResponse value) {
        return new JAXBElement<ReplyToMeetingProposalResponse>(_ReplyToMeetingProposalResponse_QNAME, ReplyToMeetingProposalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HouseProposalReplyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "houseProposalReplyResponse")
    public JAXBElement<HouseProposalReplyResponse> createHouseProposalReplyResponse(HouseProposalReplyResponse value) {
        return new JAXBElement<HouseProposalReplyResponse>(_HouseProposalReplyResponse_QNAME, HouseProposalReplyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestHouses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "requestHouses")
    public JAXBElement<RequestHouses> createRequestHouses(RequestHouses value) {
        return new JAXBElement<RequestHouses>(_RequestHouses_QNAME, RequestHouses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReplyToMeetingProposal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "replyToMeetingProposal")
    public JAXBElement<ReplyToMeetingProposal> createReplyToMeetingProposal(ReplyToMeetingProposal value) {
        return new JAXBElement<ReplyToMeetingProposal>(_ReplyToMeetingProposal_QNAME, ReplyToMeetingProposal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSellerMeetingDateList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "getSellerMeetingDateList")
    public JAXBElement<GetSellerMeetingDateList> createGetSellerMeetingDateList(GetSellerMeetingDateList value) {
        return new JAXBElement<GetSellerMeetingDateList>(_GetSellerMeetingDateList_QNAME, GetSellerMeetingDateList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HouseProposalReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "houseProposalReply")
    public JAXBElement<HouseProposalReply> createHouseProposalReply(HouseProposalReply value) {
        return new JAXBElement<HouseProposalReply>(_HouseProposalReply_QNAME, HouseProposalReply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestHousesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "requestHousesResponse")
    public JAXBElement<RequestHousesResponse> createRequestHousesResponse(RequestHousesResponse value) {
        return new JAXBElement<RequestHousesResponse>(_RequestHousesResponse_QNAME, RequestHousesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSellerMeetingDateListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.loopingdoge.org/", name = "getSellerMeetingDateListResponse")
    public JAXBElement<GetSellerMeetingDateListResponse> createGetSellerMeetingDateListResponse(GetSellerMeetingDateListResponse value) {
        return new JAXBElement<GetSellerMeetingDateListResponse>(_GetSellerMeetingDateListResponse_QNAME, GetSellerMeetingDateListResponse.class, null, value);
    }

}
