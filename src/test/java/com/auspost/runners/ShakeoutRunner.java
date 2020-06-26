package com.auspost.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "classpath:features", glue = "com.auspost", tags = "@type=api")
public class ShakeoutRunner {
}
