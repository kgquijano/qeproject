package com.auspost.customRunner;

import org.junit.runners.model.InitializationError;

public class CucumberSerneityRunner1 extends AbstractCucumberSerenityRunner {

    public CucumberSerneityRunner1(Class clazz) throws InitializationError {
        super(clazz, "1");
    }
}
