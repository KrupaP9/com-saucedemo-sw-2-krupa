package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.UtilitySauceDemo;

public class LoginTest extends UtilitySauceDemo {
    @Before
    public void openBrowsers(){
        //open the browser and load URL
        openBrowser("https://www.saucedemo.com/");
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter "standard_user" to the username box
        sendTextToElement(By.xpath("//input[@name='user-name']"),"standard_user");
        //Enter "secret_sauce" to the password box
        sendTextToElement(By.xpath("//input[@name='password']"),"secret_sauce");
        //Click on the login button
        clickOnElement(By.xpath("//input[@name='login-button']"));
        //define the expected text when user is logged in
        String expectedText = "PRODUCTS";
        //get actual text on page
        String actualText = getTextFromElement(By.xpath("//span[@class='title']"));
        //verify whether expected and actual text match
        Assert.assertEquals("Not logged in ",expectedText,actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter "standard_user" to the username box
        sendTextToElement(By.xpath("//input[@name='user-name']"),"standard_user");
        //Enter "secret_sauce" to the password box
        sendTextToElement(By.xpath("//input[@name='password']"),"secret_sauce");
        //Click on the login button
        clickOnElement(By.xpath("//input[@name='login-button']"));
        //Verify that six products are displayed on page
        //define expected products per page
        int expectedProductsPerPage = 6;
        //get size of actual products per page
        int actualProductsPerPage = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        //use assert to check expected is equal to actual
        Assert.assertEquals("Not 6 products per page",expectedProductsPerPage,actualProductsPerPage);
        }
    @After
    public void tearDown(){
        //close the browser
        closeBrowser();
    }
}
