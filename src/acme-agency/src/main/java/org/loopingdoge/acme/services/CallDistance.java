package org.loopingdoge.acme.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CallDistance implements JavaDelegate {

    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("130, Retrofit sta arrivando mmmerdeeee");
    }

}
