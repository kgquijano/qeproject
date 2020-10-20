package com.auspost.steps;

import com.auspost.pages.DuckDuckGoPage;
import net.thucydides.core.steps.ScenarioSteps;

public class DuckDuckGoSteps extends ScenarioSteps {

    private DuckDuckGoPage duckDuckGoPages;

    public void launchDuckDuckGoBrowserUI() {
        duckDuckGoPages.launchDuckDuckGoBrowserUI();
    }

    public void searchRevolutionIT() { duckDuckGoPages.searchRevolutionIT(); }

    public void verifyResults() {duckDuckGoPages.verifyResults();}
}
