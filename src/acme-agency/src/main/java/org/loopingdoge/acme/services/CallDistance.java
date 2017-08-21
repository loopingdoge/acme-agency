package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.connect.Connectors;
import org.camunda.connect.httpclient.HttpConnector;
import org.camunda.connect.httpclient.HttpResponse;
import org.camunda.connect.httpclient.impl.HttpConnectorImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CallDistance implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("acme-agency - Call Distance");

    public void execute(DelegateExecution delegateExecution) throws Exception {
        HttpConnectorImpl http = Connectors.getConnector(HttpConnector.ID);
        Map<String, String> payload = new HashMap<String, String>();
        String url = "http://localhost:7778/ferrara/mirandola";
        HttpResponse response = http.createRequest()
                .get()
                .header("Accept", "application/json")
                .url(url)
                .execute();
        LOGGER.log(Level.INFO, response.getResponse());
    }

}
