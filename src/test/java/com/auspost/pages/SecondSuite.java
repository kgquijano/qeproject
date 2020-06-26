package com.auspost.pages;

import net.serenitybdd.core.pages.PageObject;

public class SecondSuite extends PageObject {
    public void launchYahoo(){
        getDriver().get("https://au.yahoo.com/");
    }

    public void launchShelde(){
        getDriver().get("https://shelde.com/");
    }
}
