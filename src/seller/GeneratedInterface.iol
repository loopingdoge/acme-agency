type NOTATIONType:any

type proposeHouseResponseType:void {
	.return?:string
}

type proposeHouseType:void {
	.house?:houseType
}

type houseType:any {
	.address?:houseAddressType
	.squareFootage:int
	.price:double
	.name?:void | string
	.sellerName?:void | string
	.hasGarden:bool
}

type houseAddressType:any {
	.streetName?:string
	.province?:string
	.nation?:string
	.city?:string
	.civic?:string
}

type houseaddress:void {
	.streetName?:string
	.province?:string
	.nation?:string
	.city?:string
	.civic?:string
}

type proposeHouseResponse:void {
	.return?:string
}

type proposeHouse:void {
	.house?:houseType
}

type house:void {
	.address?:houseAddressType
	.squareFootage:int
	.price:double
	.name?:void | string
	.sellerName?:void | string
	.hasGarden:bool
}

interface SellerWebService {
RequestResponse:
	proposeHouse(proposeHouse)(proposeHouseResponse)
}

outputPort SellerWebServicePort {
Location: "socket://localhost:8080/acme-agency-ws-0.0.1-SNAPSHOT/SellerWebService"
Protocol: soap {
	.wsdl = "http://localhost:8080/acme-agency-ws-0.0.1-SNAPSHOT/SellerWebService?WSDL";
	.wsdl.port = "SellerWebServicePort"
}
Interfaces: SellerWebService
}
