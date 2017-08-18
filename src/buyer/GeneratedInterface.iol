type NOTATIONType:any

type houseAddressType:void {
	.civic?:string
	.province?:string
	.streetName?:string
	.nation?:string
	.city?:string
}

type requestHousesType:void {
	.houseProfile?:houseProfileType
	.buyerName?:string
}

type houseProfileType:any {
	.minSquareFootage:int
	.hasGarden:bool
	.maxKmToAddress:double
	.addressReference?:houseAddressType
	.maxPrice:double
	.maxSquareFootage:int
	.minPrice:double
}

type houseType:void {
	.price:double
	.address?:houseAddressType
	.hasGarden:bool
	.name?:any
	.squareFootage:int
	.sellerName?:any
}

type requestHousesResponseType:void {
	.return*:houseType
}

type requestHouses:void {
	.houseProfile?:houseProfileType
	.buyerName?:string
}

type houseprofile:void {
	.minSquareFootage:int
	.hasGarden:bool
	.maxKmToAddress:double
	.addressReference?:houseAddressType
	.maxPrice:double
	.maxSquareFootage:int
	.minPrice:double
}

type houseaddress:void {
	.civic?:string
	.province?:string
	.streetName?:string
	.nation?:string
	.city?:string
}

type house:void {
	.price:double
	.address?:houseAddressType
	.hasGarden:bool
	.name?:any
	.squareFootage:int
	.sellerName?:any
}

type requestHousesResponse:void {
	.return*:houseType
}

interface BuyerWebService {
RequestResponse:
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


