include "GeneratedInterface.iol"
include "console.iol"
include "string_utils.iol"

main {
	houseProfile.minSquareFootage = 50;
	houseProfile.maxSquareFootage = 500;
	houseProfile.minPrice = 0;
	houseProfile.maxPrice = 300000;
	houseProfile.hasGarden = true;

	houseProfile.maxKmToAddress = 10;
	address.nation = "Italia";
	address.province = "MO";
	address.city = "Mirandola";
	address.streetName = "Via Sana";
	houseProfile.addressReference << address;

	requestHousesElement.houseProfile << houseProfile;
	requestHousesElement.buyerName = "Ex";

	//valueToPrettyString@StringUtils(houseProposalElement) (el);
	//println@Console(el)();
	
	requestHouses@BuyerWebServicePort(requestHousesElement)(response);
	println@Console("Found " + #response.return + " houses\n")();
	
	for (i = 0, i < #response.return, i++) {
		valueToPrettyString@StringUtils(response.return[i]) (el);
		println@Console(el)()
	}
}
