package org.loopingdoge.acme;

import org.camunda.bpm.engine.ProcessEngine;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;

@SuppressWarnings("restriction")
@WebService
public class TestCadastreWebService {
    @Resource(mappedName = "java:global/camunda-bpm-platform/process-engine/default")
    private ProcessEngine processEngine;

    @WebMethod
    public String startCadastreTest() {
        String startMessageId = "startCadastrial";
        processEngine.getRuntimeService().startProcessInstanceByMessage(startMessageId);
        return "Cadastre ok";
    }
}
