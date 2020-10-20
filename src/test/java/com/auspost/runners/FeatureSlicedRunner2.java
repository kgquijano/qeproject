package com.auspost.runners;

import com.auspost.customRunner.CucumberSerneityRunner2;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberSerneityRunner2.class)
@CucumberOptions(features = "classpath:features", glue = "com.auspost", tags = "@type=QEtest")
public class FeatureSlicedRunner2 {
}
