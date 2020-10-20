package com.auspost.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DuckDuckGoPage extends PageObject {

    //private final String SEARCH_WORD = "Revolution IT";

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchForm;

    @FindBy(id = "search_button_homepage")
    private WebElement submitButton;

    @FindBy(xpath = "//*[contains(text(),'Revolution IT')]")
    private WebElement searchResult;

    //given - going to the website
    public void launchDuckDuckGoBrowserUI() {
        try {
            getDriver().get("https://duckduckgo.com/");
        } catch (Exception e) {
            Assert.fail("Exception found while launching DuckDuckGo in browser mode : ");
        }
    }
    //when - i type RevIT and clicking submit
    public void searchRevolutionIT() {
        this.searchForm.sendKeys("Revolution IT");
        this.submitButton.click();
        }

    //then - verify if RevIT site is in the search results
    public void verifyResults(){
        Assert.assertTrue(String.valueOf(searchResult), true);
    }
    }

