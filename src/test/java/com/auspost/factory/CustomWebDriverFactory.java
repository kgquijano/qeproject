package com.auspost.factory;

import net.serenitybdd.core.webdriver.driverproviders.FirefoxDriverCapabilities;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CustomWebDriverFactory implements DriverSource {
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    @Override
    public WebDriver newDriver() {
        try {

            return new RemoteWebDriver(
                    new URL("http://" + variables.getProperty("HostMachine") + ":4444/wd/hub"),
                    new FirefoxDriverCapabilities(Injectors.getInjector().getProvider(EnvironmentVariables.class).get()).getCapabilities());
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
