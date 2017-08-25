type NOTATIONType:any

type addressType:void {
	.streetName?:string
	.province?:string
	.city?:string
	.nation?:string
	.civic?:string
}

type houseProposalReplyType:void {
	.replyAction?:string
	.selectedHouseIndex:int
}

type requestHousesResponseType:void {
	.return?:HouseRequestReplyMessageType
}

type HouseRequestReplyMessageType:any {
	.houseList*:houseType
	.message?:string
}

type houseProposalReplyResponseType:void {
	.return?:HouseRequestReplyMessageType
}

type houseProfileType:void {
	.addressReference?:addressType
	.maxSquareFootage:int
	.minSquareFootage:int
	.maxKmToAddress:double
	.minPrice:double
	.maxPrice:double
	.hasGarden:bool
}

type houseType:any {
	.address?:addressType
	.squareFootage:int
	.price:double
	.name?:string
	.sellerName?:string
	.hasGarden:bool
}

type requestHousesType:void {
	.houseProfile?:houseProfileType
	.buyerName?:string
}

type houseProposalReply:void {
	.replyAction?:string
	.selectedHouseIndex:int
}

type requestHousesResponse:void {
	.return?:HouseRequestReplyMessageType
}

type HouseRequestReplyMessage:void {
	.houseList*:houseType
	.message?:string
}

type houseProposalReplyResponse:void {
	.return?:HouseRequestReplyMessageType
}

type requestHouses:void {
	.houseProfile?:houseProfileType
	.buyerName?:string
}

interface BuyerWebService {
RequestResponse:
	houseProposalReply(houseProposalReply)(houseProposalReplyResponse),
	requestHouses(requestHouses)(requestHousesResponse)
}

outputPort BuyerWebServicePort {
Location: "socket://localhost:8080/acme-agency-ws-0.0.1-SNAPSHOT/BuyerWebService"
Protocol: soap {
	.wsdl = "http://localhost:8080/acme-agency-ws-0.0.1-SNAPSHOT/BuyerWebService?WSDL";
	.wsdl.port = "BuyerWebServicePort"
}
Interfaces: BuyerWebService
}
