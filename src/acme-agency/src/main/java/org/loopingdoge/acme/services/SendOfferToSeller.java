package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.utils.MailServiceAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.logging.Logger;

public class SendOfferToSeller implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("SendOfferToSeller");

    private final String BASE_URL = "http://localhost:7774/";

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private MailServiceAPI mailService = retrofit.create(MailServiceAPI.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");

        House acceptedHouse = (House) execution.getVariable("chosenHouse");
        String buyerName = (String) execution.getVariable("buyerName");
        Double buyerOffer = (Double) execution.getVariable("buyerOffer");

        mailService.send(
                acceptedHouse.getSellerName(),
                "AcmeAgency",
                buyerName + " has offered you  " + buyerOffer)
                .execute().body();

    }

}
