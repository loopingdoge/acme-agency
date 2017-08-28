package org.loopingdoge.acme.services;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.http.HTTPTransportFactory;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServer;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServerService;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.utils.AcmeExternalServices;
import org.loopingdoge.acme.utils.AcmeVariables;
import org.loopingdoge.acme.utils.AcmeWaitStateNames;
import org.loopingdoge.acme.utils.DistanceServiceAPI;
import org.loopingdoge.acme.utils.MailServiceAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.logging.Logger;

public class AskSellerAvailability implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("AskSellerAvailability");

    private final String BASE_URL = AcmeExternalServices.MAIL;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private MailServiceAPI mailService = retrofit.create(MailServiceAPI.class);

    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");
        
        House acceptedHouse = (House) execution.getVariable(AcmeVariables.CHOSEN_HOUSE);
        String buyerName = (String) execution.getVariable(AcmeVariables.BUYER_NAME);
        
        // Send mail notification to house owner
        mailService.send(
        		acceptedHouse.getSellerName(), 
        		"AcmeAgency", 
        		buyerName + " ha richiesto di incontro per la tua casa " + acceptedHouse.getName())
        		.execute().body();
        
        // Add session info
        final Bus defaultBus = BusFactory.getDefaultBus();
        final ConduitInitiatorManager extension = defaultBus.getExtension(ConduitInitiatorManager.class);
        extension.registerConduitInitiator("http://schemas.xmlsoap.org/soap/http/", new HTTPTransportFactory());
        
        ACMESessionServer sessionWs = new ACMESessionServerService().getACMESessionServerServicePort();
        sessionWs.addSession(
        		acceptedHouse.getSellerName(),
        		execution.getProcessInstanceId(), 
        		AcmeWaitStateNames.WAIT_SELLER_AVAILABILITY);
    }

}
