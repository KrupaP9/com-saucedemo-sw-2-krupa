package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    //WebDriver declared as public and static to allow access from other packages without creating instances
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        //set key to value of webdriver location
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //create an instance of ChromeDriver class and store with the name driver
        driver = new ChromeDriver();
        //launch URL
        driver.get(baseUrl);
        //maximise window
        driver.manage().window().maximize();
        //set implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        //close browser
        driver.quit();
    }
}
