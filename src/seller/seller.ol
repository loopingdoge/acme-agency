include "GeneratedInterface.iol"
include "console.iol"
include "string_utils.iol"

main {
	address.civic = "12";
	address.province = "Modena";
	address.nation = "Italy";
	address.city = "Mirandola";

	houseProposalElement.address << address;
	houseProposalElement.sellerName = "Barabba";

	//valueToPrettyString@StringUtils(houseProposalElement) (el);
	//println@Console(el)();
	
	proposeHouse@SellerWebServicePort(houseProposalElement)(response);
	println@Console(response.return)()
}
