package org.loopingdoge.acme;

import org.camunda.bpm.engine.ProcessEngine;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;

@SuppressWarnings("restriction")
@WebService
public class TestNotaryWebService {
    @Resource(mappedName = "java:global/camunda-bpm-platform/process-engine/default")
    private ProcessEngine processEngine;

    @WebMethod
    public String startNotaryTest() {
        String message = "MSG";
        String startMessageId = "startNotary";
        processEngine.getRuntimeService().startProcessInstanceByMessage(startMessageId);
        return "Notary ok";
    }
}
