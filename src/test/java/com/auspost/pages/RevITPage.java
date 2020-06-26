package com.auspost.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class RevITPage extends PageObject {

    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    @FindBy(xpath = "//a[@title='Revolution IT']")
    private WebElement homePageTitle;

    @FindBy(xpath = "//span[text()='About Us']")
    private WebElement aboutMenu;

    @FindBy(xpath = "//h2[text()='About Revolution IT']")
    private WebElement aboutPageHeader;

    public void launchRevItBrowserUI() {
        try {
            getDriver().get("https://www.revolutionit.com.au/");
        } catch (Exception e) {
            Assert.fail("Exception found while launching RevIT in browser mode : ");
        }
    }

    public void verifyHomePageIsDisplayed() {
        try {
            waitFor(homePageTitle);
            if (!homePageTitle.isDisplayed()) {
                Assert.fail("Home page is not displayed.");
            }else{
                System.out.println("Successfully navigated to Home Page!");
            }
        } catch (Exception e) {
            Assert.fail("Exception found while navigating back to home page : ");
        }
    }


    public void verifyRevITAboutPage() {
        try {
            waitFor(aboutMenu);
            aboutMenu.click();
            waitFor(aboutPageHeader);
            if (!aboutPageHeader.isDisplayed()) {
                Assert.fail("About page is not displayed.");
            }else{
                System.out.println("Successfully navigated to About Page!");
            }
        } catch (Exception e) {
            Assert.fail("Exception found while navigating back to home page : ");
        }
    }

    public void maximizeWindow(String mode) {
        try {
            if (mode.equals("fullscreen")) {
                getDriver().manage().window().fullscreen();
            } else if (mode.equals("maximum")) {
                getDriver().manage().window().maximize();
            } else {
                Assert.fail("Invalid argument :" + mode);
            }

        } catch (Exception e) {
            Assert.fail("Exception found while maximizing the window: " + e);
        }
    }

    public void refreshCurrentPage() {
        getDriver().navigate().refresh();
        waitForAngularRequestsToFinish();
    }

    public void openNewTab() {
        try {
            ((JavascriptExecutor)getDriver()).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
            getDriver().switchTo().window(tabs.get(1));
        } catch (Exception e) {
            Assert.fail("Exception found while opening new tab window : " + e);
        }
    }

    public void closeTheBrowser() {
        getDriver().quit();
    }

}
