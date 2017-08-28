package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.utils.AcmeExternalServices;
import org.loopingdoge.acme.utils.AcmeVariables;
import org.loopingdoge.acme.utils.DistanceResponse;
import org.loopingdoge.acme.utils.DistanceServiceAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.logging.Logger;

public class CallDistance implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("CallDistance");
    private final String BASE_URL = AcmeExternalServices.DISTANCE;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private DistanceServiceAPI service = retrofit.create(DistanceServiceAPI.class);

    public void execute(DelegateExecution delegateExecution) throws Exception {

        String fromDistance = delegateExecution.getVariable(AcmeVariables.FROM_DISTANCE).toString();
        String toDistance = delegateExecution.getVariable(AcmeVariables.TO_DISTANCE).toString();

        DistanceResponse res = service.distance(fromDistance, toDistance).execute().body();

        double distance = Double.parseDouble(res.getDistance());
        delegateExecution.setVariable(AcmeVariables.DISTANCE, distance);

        logger.info("DISTANCE: " + distance + "\nfrom: " + fromDistance + "\nto: " + toDistance);

    }

}
