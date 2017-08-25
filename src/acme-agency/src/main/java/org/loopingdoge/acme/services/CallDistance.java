package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.model.Address;
import org.loopingdoge.acme.utils.DistanceResponse;
import org.loopingdoge.acme.utils.DistanceServiceAPI;
import org.loopingdoge.acme.model.House;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.logging.Logger;

public class CallDistance implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("CallDistance");
    private final String BASE_URL = "http://localhost:7778/";

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private DistanceServiceAPI service = retrofit.create(DistanceServiceAPI.class);

    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("service started");

        Address fromDistance = (Address) delegateExecution.getVariable("fromDistance");
        Address toDistance = (Address) delegateExecution.getVariable("toDistance");

//        TODO usare gli indirizzi completi escaped
        DistanceResponse res = service.distance(fromDistance.getCity(), toDistance.getCity()).execute().body();
        delegateExecution.setVariable("distance", Integer.parseInt(res.getDistance()));

    }

}
