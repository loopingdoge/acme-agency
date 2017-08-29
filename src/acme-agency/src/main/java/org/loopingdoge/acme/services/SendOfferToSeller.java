package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServer;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServerService;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.utils.AcmeExternalServices;
import org.loopingdoge.acme.utils.AcmeVariables;
import org.loopingdoge.acme.utils.AcmeWaitStateNames;
import org.loopingdoge.acme.utils.MailServiceAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.logging.Logger;

public class SendOfferToSeller implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("SendOfferToSeller");

    private final String BASE_URL = AcmeExternalServices.MAIL;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private MailServiceAPI mailService = retrofit.create(MailServiceAPI.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");

        House chosenHouse = (House) execution.getVariable(AcmeVariables.CHOSEN_HOUSE);
        String buyerName = (String) execution.getVariable(AcmeVariables.BUYER_NAME);
        Double buyerOffer = (Double) execution.getVariable(AcmeVariables.BUYER_OFFER);

        // Add seller session
        ACMESessionServer sessionWs = new ACMESessionServerService().getACMESessionServerServicePort();
        sessionWs.addSession(
        		chosenHouse.getSellerName(), 
        		execution.getProcessInstanceId(), 
        		AcmeWaitStateNames.WAIT_SELLER_OFFER_REPLY);
        logger.info("Session wait for offer reply added");
        
        mailService.send(
                chosenHouse.getSellerName(),
                "AcmeAgency",
                buyerName + " has offered you " + buyerOffer + " euros for your " + chosenHouse.getName() + " house")
                .execute().body();

    }

}
