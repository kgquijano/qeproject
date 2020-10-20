package com.auspost.runners;

import com.auspost.customRunner.CucumberSerneityRunner1;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberSerneityRunner1.class)
@CucumberOptions(features = "classpath:features", glue = "com.auspost", tags = "@type=kay")
public class FeatureSlicedRunner1 {
}
