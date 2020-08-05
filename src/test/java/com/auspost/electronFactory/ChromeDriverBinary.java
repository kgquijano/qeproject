package com.auspost.electronFactory;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverBinary implements DriverSource {
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    @Override
    public WebDriver newDriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\ShettyD\\AppData\\Local\\Programs\\post_plus_ui\\POST+.exe");
            System.setProperty("webdriver.chrome.driver", variables.getProperty("chromeDriverPath"));
            System.setProperty("webdriver.chrome.logfile", "C:\\Tools\\chromedriver.log");
            System.setProperty("webdriver.chrome.verboseLogging", "true");
            return new ChromeDriver(options);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
