package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.utils.DistanceResponse;
import org.loopingdoge.acme.utils.DistanceServiceAPI;
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

        String fromDistance = delegateExecution.getVariable("fromDistance").toString();
        String toDistance = delegateExecution.getVariable("toDistance").toString();

        logger.info("CALLDISTANCE " + fromDistance + " " + toDistance);
        DistanceResponse res = service.distance(fromDistance, toDistance).execute().body();

        double distance = Double.parseDouble(res.getDistance());
        delegateExecution.setVariable("distance", distance);

    }

}
