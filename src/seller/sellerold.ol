include "GeneratedInterface.iol"
include "console.iol"
include "string_utils.iol"

main {
	address.civic = "12";
	address.province = "Modena";
	address.nation = "Italy";
	address.city = "Mirandola";

	house.price = 122000;
	house.hasGarden = true;
	house.name = "Casa sull'Albero";
	house.squareFootage = 300;
	house.sellerName = "Barabba";
	house.address << address;
	
	houseProposalElement.house << house;
	houseProposalElement.sellerName = "Barabba";

	valueToPrettyString@StringUtils(houseProposalElement) (el);
	println@Console(el)();
	
	proposeHouse@SellerWebServicePort(houseProposalElement)(response);
	println@Console(response.return)()
}
