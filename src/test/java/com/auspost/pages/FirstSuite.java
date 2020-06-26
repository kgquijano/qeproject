package com.auspost.pages;

import net.serenitybdd.core.pages.PageObject;

public class FirstSuite extends PageObject {
    public void launchGoogle(){
        getDriver().get("https://www.google.com/");
    }

    public void launchRevit(){
        getDriver().get("https://www.revolutionit.com.au/");
    }

    public void launchAuspost(){
        getDriver().get("https://auspost.com.au/");
    }
}
