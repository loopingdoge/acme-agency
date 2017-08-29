package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServer;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServerService;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.utils.AcmeExternalServices;
import org.loopingdoge.acme.utils.AcmeVariables;
import org.loopingdoge.acme.utils.MailServiceAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.logging.Logger;

public class SendRefusalToBuyer implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("SendRefusalToBuyer");

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

        // Remove seller session info
        ACMESessionServer sessionWs = new ACMESessionServerService().getACMESessionServerServicePort();
        sessionWs.removeSession(execution.getProcessInstanceId());
        
        mailService.send(
                buyerName,
                "AcmeAgency",
                chosenHouse.getSellerName() + " has refused your " + buyerOffer + " euro offer")
                .execute().body();
    }

}
