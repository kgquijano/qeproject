package com.auspost.steps;


import com.auspost.messageObjects.MessageFactory;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class APISteps extends ScenarioSteps {
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

   private MessageFactory messageFactory;

    public void authorizeRequest(String searchString,String modifyValue,String templateType,String templateIdValue) throws Exception {
       messageFactory.authorizeRequest(searchString,modifyValue,templateType,templateIdValue);
    }

    public void submitSOAPRequest(String searchString,String modifyValue,String templateType,String templateIdValue) throws Exception {
        messageFactory.submitSOAPRequest( searchString, modifyValue, templateType, templateIdValue);
    }

    public void submitRequest(String templateType) throws Exception {
       messageFactory.submitRequest(templateType);
    }

    public void validateResponse(String statusCode){
        messageFactory.validateResponse(statusCode);}
    }



