package com.auspost.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


public class SheldePage extends PageObject {

    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    @FindBy(xpath = "//a[contains(@href,'services')]//strong")
    private WebElement homePageServiceLink;



    public void launchSheldeBrowserUI() {
        try {
            getDriver().get("https://shelde.com/");
        } catch (Exception e) {
            Assert.fail("Exception found while launching RevIT in browser mode : ");
        }
    }

    public void verifyHomePageIsDisplayed() {
        try {
            if (!getDriver().getTitle().equalsIgnoreCase("Home - Shelde")) {
                Assert.fail("Shelde Home page is not displayed.");
            }else{
                System.out.println("Successfully navigated to Shelde Home Page!");
            }
        } catch (Exception e) {
            Assert.fail("Exception found while navigating back to Shelde home page : ");
        }
    }


    public void verifySheldeServicePage() {
        try {
            waitFor(homePageServiceLink);
            homePageServiceLink.click();
            if (!getDriver().getTitle().equalsIgnoreCase("Services - Shelde")) {
                Assert.fail("Shelde Service page is not displayed.");
            }else{
                System.out.println("Successfully navigated to Shelde Service page!");
            }
        } catch (Exception e) {
            Assert.fail("Exception found while navigating to Shelde Service page : ");
        }
    }



}
