package com.auspost.pages;


import com.auspost.electronFactory.ChromeDriverBinary;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class ElectronPage extends PageObject {

    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    @FindBy(xpath = "//a[@title='Revolution IT']")
    private WebElement homePageTitle;

    @FindBy(xpath = "//span[text()='About Us']")
    private WebElement aboutMenu;

    @FindBy(xpath = "//h2[text()='About Revolution IT']")
    private WebElement aboutPageHeader;

    public void launchPostPlusElectronApp() throws Exception {
        try {
            getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            waitInSec(10);
            //input device alias name
            // driver.findElement(By.xpath("//input[@id='commonTextField_RegistrationCardInput']")).sendKeys("347047s0c10");
            WebElement aliasEle= getDriver().findElement(By.xpath("//input[@id='commonTextField_RegistrationCardInput']"));
            aliasEle.sendKeys("dev10");
            waitInSec(1);
            //print till ID
            //System.out.println("Till ID: " + driver.findElement(By.xpath("//p[@id='RegistrationCardLastInput']")).getText());
            waitInSec(1);
            //click on device registration button
           WebElement registerEle= getDriver().findElement(By.xpath("//button/span[text()='Register device']"));
            registerEle.click();
            waitInSec(5);
            int errorPage = getDriver().findElements(By.xpath("//button/span[text()='Register device']")).size();

            int count = 0;

            while(errorPage>=1 && count<=7){
                System.out.println("reg ele - "+errorPage);
                count++;
                System.out.println("ERRROR Count- "+count);
               getDriver().quit();

               ChromeDriverBinary binary = new ChromeDriverBinary();

              setDriver( binary.newDriver());
                waitInSec(10);
                getDriver().findElement(By.xpath("//input[@id='commonTextField_RegistrationCardInput']")).sendKeys("dev10");
                waitInSec(1);
                //print till ID
                //System.out.println("Till ID: " + driver.findElement(By.xpath("//p[@id='RegistrationCardLastInput']")).getText());
                waitInSec(1);
               // getDriver().findElement(By.xpath("//button/span[text()='Register device']")).click();
               waitInSec(5);
                errorPage = getDriver().findElements(By.xpath("//button/span[text()='Register device']")).size();
            }



            System.out.println("Launched");
        } catch (Exception e) {

        }
    }

    public void login() {
        try {
            System.out.println("loged IN");


            //Enter user-name
            getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys("scanner1.ovc@test.npe.auspost.com.au");

            waitInSec(2);
            //click on next button
            getDriver().findElement(By.xpath("//input[@id='idSIButton9']")).click();

            waitInSec(2);
            //Enter Password
            getDriver().findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("Testing+06");

            waitInSec(2);
            //Click on submit
            getDriver().findElement(By.xpath("//span[@id='submitButton']")).click();

            waitInSec(2);
            //Click on No to stay signed in
            getDriver().findElement(By.xpath("//input[@id='idBtn_Back']")).click();

            waitInSec(5);

        } catch (Exception e) {
            Assert.fail("Exception found while navigating back to home page : ");
        }
    }

    public void waitInSec(int sec) throws Exception {
        try {
            Thread.sleep(sec*1000);
        } catch (Exception e) {
            throw new Exception("Exception found during sleep : " + e);
        }
    }


    public void verifyHomePage() {
        try {
            System.out.println("Verified");
            waitInSec(5);
            String element_id = "//div//input[@id='searchContainerInput_searchMain']";
            try {
                //Search for product ID.
                getDriver().findElement(By.xpath(element_id)).sendKeys("29883");
            } catch (Exception e) {
                //Assert.fail("Exception while searching for product with product ID :" + e);
                //Search for product ID.
                getDriver().findElement(By.xpath(element_id)).sendKeys("29883");
            }

            //Click on Search button
            getDriver().findElement(By.xpath("//div//div[@id='searchContainerSearchMainButtonText_searchMain']")).click();

            //System.out.println(driver.getTitle());
            getDriver().quit();
        } catch (Exception e) {
            Assert.fail("Exception found while navigating back to home page : ");
        }
    }



}
