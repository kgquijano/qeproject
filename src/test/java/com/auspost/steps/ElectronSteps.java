package com.auspost.steps;


import com.auspost.pages.ElectronPage;
import com.auspost.pages.SheldePage;
import net.thucydides.core.steps.ScenarioSteps;

public class ElectronSteps extends ScenarioSteps {

    private ElectronPage electronPages;

    public void launchPostPlusElectronApp() throws Exception {
        electronPages.launchPostPlusElectronApp();
    }

    public void login() {
        electronPages.login();
    }

    public void verifyHomePage() { electronPages.verifyHomePage(); }
}
