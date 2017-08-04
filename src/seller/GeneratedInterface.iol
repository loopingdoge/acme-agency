type NOTATIONType:any

type proposeHouseResponseType:void {
	.return?:string
}

type HouseAddressType:void {
	.civic?:string
	.province?:string
	.nation?:string
	.city?:string
}

type proposeHouseType:void {
	.address?:HouseAddressType
	.sellerName?:string
}

type proposeHouseResponse:void {
	.return?:string
}

type proposeHouse:void {
	.address?:HouseAddressType
	.sellerName?:string
}

interface SellerWebService {
RequestResponse:
	proposeHouse(proposeHouse)(proposeHouseResponse)
}

outputPort SellerWebServicePort {
Location: "socket://localhost:8080/acmeagency-0.1/SellerWebService"
Protocol: soap {
	.wsdl = "http://localhost:8080/acmeagency-0.1/SellerWebService?WSDL";
	.wsdl.port = "SellerWebServicePort"
}
Interfaces: SellerWebService
}


