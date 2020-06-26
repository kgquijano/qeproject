package com.auspost.definitions;

import com.auspost.pages.FirstSuite;
import com.auspost.pages.SecondSuite;
import com.auspost.steps.APISteps;
import com.auspost.steps.RevITSteps;
import com.auspost.steps.SheldeSteps;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.cucumber.suiteslicing.SerenityTags;
import net.thucydides.core.annotations.Steps;

public class Definitions {

    @Steps
    FirstSuite firstSuite;

    @Steps
    SecondSuite secondSuite;

    @Steps
    RevITSteps revITSteps;

    @Steps
    SheldeSteps sheldeSteps;

    @Steps
    APISteps apiSteps;

    @Before
    public void before() {
        SerenityTags.create().tagScenarioWithBatchingInfo();
    }

    @Given("there {int} cucumber(s) in my belly")
    public void putCucumbersInBelly(Integer num) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(num + " cucumbers have been eaten");
    }

    @io.cucumber.java.en.Given("navigate Google")
    public void navigateGoogle() {
        firstSuite.launchGoogle();
        System.out.println(" SUCCESSFULLY NAVIGATED TO GOOGLE!!!!!!!!!!");
    }

    @io.cucumber.java.en.Given("Navigate to Yahoo")
    public void navigateToYahoo() {
        secondSuite.launchYahoo();
        System.out.println(" SUCCESSFULLY NAVIGATED TO YAHOO!!!!!!!!!!");
    }

    @io.cucumber.java.en.Given("navigate Revit")
    public void navigateRevit() {
        firstSuite.launchRevit();
        System.out.println(" SUCCESSFULLY NAVIGATED TO REVIT!!!!!!!!!!");
    }

    @io.cucumber.java.en.Given("Navigate to Shelde")
    public void navigateToShelde() {
        secondSuite.launchShelde();
        System.out.println(" SUCCESSFULLY NAVIGATED TO SHELDE!!!!!!!!!!");
    }

    @io.cucumber.java.en.Given("navigate Auspost")
    public void navigateAuspost() {
        firstSuite.launchAuspost();
        System.out.println(" SUCCESSFULLY NAVIGATED TO AUSPOST!!!!!!!!!!");
    }


    @io.cucumber.java.en.Given("Launch RevIT Page")
    public void launchRevITPage() {
        revITSteps.launchRevItBrowserUI();
    }

    @And("Verify the RevIT HomePage")
    public void verifyTheRevITHomePage() {
        revITSteps.verifyHomePageIsDisplayed();
    }

    @And("Click About Us and validate the RevIT About Page")
    public void clickAboutUsAndValidateTheRevITAboutPage() {
        revITSteps.verifyRevITAboutPage();
    }

    @io.cucumber.java.en.Given("Launch Shelde Page")
    public void launchSheldePage() {
        sheldeSteps.launchSheldeBrowserUI();
    }


    @And("Verify the Shelde HomePage")
    public void verifyTheSheldeHomePage() {
        sheldeSteps.verifyHomePageIsDisplayed();
    }

    @And("Click Services and validate the Shelde Services Page")
    public void clickServicesAndValidateTheSheldeServicesPage() {
        sheldeSteps.verifySheldeServicePage();
    }


    @io.cucumber.java.en.Given("Validate the {string} request by changing the City {string} for the Object {string} with the ID {string}")
    public void validateTheRequestByChangingTheCityForTheObjectWithTheID(String arg0, String arg1, String arg2, String arg3) throws Exception {
        apiSteps.authorizeRequest(arg2,arg1,arg0,arg3);
    }

    @And("Submit the {string} request")
    public void submitTheRequest(String arg0) throws Exception {
        apiSteps.submitRequest(arg0);
    }

    @Then("response is {string}")
    public void responseIs(String arg0) {
        apiSteps.validateResponse(arg0);
    }

    @io.cucumber.java.en.Given("Validate the {string} request by changing the Product {string} for the Object {string}")
    public void validateTheRequestByChangingTheProductForTheObject(String arg0, String arg1, String arg2) throws Exception {
        apiSteps.authorizeRequest(arg2,arg1,arg0,"");
    }
}
