package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UtilitySauceDemo extends BaseTest {
    public void clickOnElement(By by){
        //method to click on element in a webpage
        //define the link to click by using findElement method
       WebElement link = driver.findElement(by);
       //click on link
       link.click();
    }
    public void sendTextToElement(By by, String text){
        //method to send text to an element on a webpage
        //define the element to which we will send text
        WebElement element = driver.findElement(by);
        //send text to the element
        element.sendKeys(text);
    }
    public String getTextFromElement(By by){
        //method to get text from an element
        //define the element from which we will get text
       WebElement elementText = driver.findElement(by);
       //return the element text which is obtained using the getText method
        return elementText.getText();
    }
}
