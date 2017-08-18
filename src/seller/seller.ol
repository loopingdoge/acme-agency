include "GeneratedInterface.iol"
include "console.iol"
include "string_utils.iol"

main {
	address.nation = "Italy";
	address.province = "Modena";
	address.city = "Mirandola";
	address.streetName = "Via Garibanzi";
	address.civic = "12";

	// houseProposalElement.address << address;
	// houseProposalElement.sellerName = "Barabba";
	house.address << address;
	house.name = "Casa di barabba";
	house.sellerName = "Barabba";
	house.squareFootage = 100;
	house.hasGarden = true;
	house.price = 100.0;

	houseProposalElement.house << house;

	//valueToPrettyString@StringUtils(houseProposalElement) (el);
	//println@Console(el)();
	
	proposeHouse@SellerWebServicePort(houseProposalElement)(response);
	println@Console(response.return)()
}
