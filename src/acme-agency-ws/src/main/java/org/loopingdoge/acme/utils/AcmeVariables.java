package org.loopingdoge.acme.utils;

public class AcmeVariables {
	
	/**
     * House
     * Used by the seller WS to add a new house to the database
     */
    public static final String NEW_HOUSE = "newHouse";

    /**
     * ArrayList<House>
     * House proposal subprocess
     * Contains all the available houses in the database.
     */
    public static final String HOUSE_LIST = "houseList";

    /**
     * ArrayList<House>
     * House proposal subprocess
     * Contains only the house presented to the buyer in a single message exchange.
     */
    public static final String PROPOSAL_LIST = "proposalList";

    /**
     * House
     * House proposal subprocess
     * The current house from HOUSE_LIST list inside the proposal list population loop.
     */
    public static final String CURR_HOUSE = "house";
    
    /**
     * HouseProfile
     * House lookup subprocess
     * House profile specified by a potential buyer.
     */
    public static final String HOUSE_PROFILE = "houseProfile";

    /**
     * String
     * Local to CallDistance service
     * The "from" address
     */
    public static final String FROM_DISTANCE = "fromDistance";

    /**
     * String
     * Local to CallDistance service
     * The "to" address
     */
    public static final String TO_DISTANCE = "toDistance";

    /**
     * Integer
     * CallDistance service
     * The "distance" output of the service
     */
    public static final String DISTANCE = "distance";

    /**
     * House
     * Global
     * The house which the buyer is willing to buy
     */
    public static final String CHOSEN_HOUSE = "chosenHouse";

    /**
     * String
     * Global
     * The buyer's name
     */
    public static final String BUYER_NAME = "buyerName";

    /**
     * List<Notary>
     * Nearest notary subprocess
     * A list containing all the notaries
     */
    public static final String NOTARIES = "notaries";

    /**
     * ArrayList<NotaryDistanceTuple>
     * Nearest notary subprocess
     * A list containing the calculated distances from the chosen house to the current notary
     */
    public static final String NOTARY_DISTANCES = "notaryDistances";

    /**
     * Notary
     * Nearest notary subprocess
     * The current notary from NOTARIES list inside the notary distance loop.
     */
    public static final String CURR_NOTARY = "notary";

    /**
     * Notary
     * Global
     * The nearest notary calculated
     */
    public static final String CHOSEN_NOTARY = "chosenNotary";

    /**
     * String
     * Cadastrial coordinates subprocess
     * The error message returned by the cadastre service
     */
    public static final String CADASTRIAL_ERROR = "cadastrialError";

    /**
     * Coordinate
     * Global
     * The chosen house's cadatrial coordinates
     */
    public static final String CADASTRIAL_COORDINATES = "cadastrialCoordinates";

    /**
     * Double
     * Global
     * The buyer's offer
     */
    public static final String BUYER_OFFER = "buyerOffer";
    
    /**
     * boolean
     * Global
     * Seller reply to buyer/s offer
     */
    public static final String OFFER_REPLY = "offerReply";

    /**
     * String
     * Global
     * The chosen meeting date
     */
    public static final String MEETING_DATE = "meetingDate";
    
    /**
     * List<String>
     * Global
     * Proposed meeting date list
     */
    public static final String MEETING_DATE_LIST = "meetingDateList";
    
    /**
     * String
     * Global
     * Status of the meeting subprocess
     */
    public final static String HOUSE_LOOKUP_ACTION_VARIABLE = "houseProposalReply";
    
    /**
     * String
     * Global
     * Buyer reply to meeting proposal
     */
    public final static String BUYER_MEETING_REPLY = "buyerMeetingReply";
    
    
    
    /* Camunda messages */ 
    
    public static final String HOUSE_LOOKUP_MESSAGE = "houseLookup";
    
    public final static String HOUSE_LOOKUP_ACTION_MESSAGE = "houseProposalReply";
    
    public final static String SELLER_AVAILABILITY_MESSAGE = "sellerAvailabilityMessage";
    
    public final static String BUYER_MEETING_REPLY_MESSAGE = "buyerMeetingResponseMessage";
    
    public final static String SELLER_MEETING_REPLY_MESSAGE = "sellerMeetingResponseMessage";

    public final static String SELLER_OFFER_REPLY_MESSAGE = "offerReply";
}
