package com.auspost.steps;


import com.auspost.pages.RevITPage;
import net.thucydides.core.steps.ScenarioSteps;

public class RevITSteps extends ScenarioSteps {

    private RevITPage revITPages;

    public void launchRevItBrowserUI() {
        revITPages.launchRevItBrowserUI();
    }

    public void verifyHomePageIsDisplayed() {
        revITPages.verifyHomePageIsDisplayed();
    }

    public void verifyRevITAboutPage() {
        revITPages.verifyRevITAboutPage();
    }

}
