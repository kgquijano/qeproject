package com.auspost.steps;


import com.auspost.pages.SheldePage;
import net.thucydides.core.steps.ScenarioSteps;

public class SheldeSteps extends ScenarioSteps {

    private SheldePage sheldePages;

    public void launchSheldeBrowserUI() {
        sheldePages.launchSheldeBrowserUI();
    }

    public void verifyHomePageIsDisplayed() {
        sheldePages.verifyHomePageIsDisplayed();
    }

    public void verifySheldeServicePage() { sheldePages.verifySheldeServicePage(); }
}
