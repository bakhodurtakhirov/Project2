package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class DriverClassWithoutLogin {
    public WebDriver driver;
    
    @BeforeClass(alwaysRun = true) // Before Class doesn't work with groups. Because we are not running the class.
    // We are running some tests in the class. To make sure it runs all the time we should add alwaysRun=true
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://demowebshop.tricentis.com");
        
    }
    
    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        closePreviousDrivers();
    }
    
    public void closePreviousDrivers() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void myWait(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
