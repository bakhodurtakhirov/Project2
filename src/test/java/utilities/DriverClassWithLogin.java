package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class DriverClassWithLogin {
    public static WebDriver driver;
    
    @BeforeClass(alwaysRun = true) // Before Class doesn't work with groups. Because we are not running the class.
    // We are running some tests in the class. To make sure it runs all the time we should add alwaysRun=true
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://demowebshop.tricentis.com");
        
        login();
    }
    
    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        closePreviousDrivers();
    }
    
    public void login() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("group_2@gmail.com");
        
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("MichaelKnight1234");
        
        WebElement loginButton = driver.findElement(By.cssSelector("input[value=\"Log in\"]"));
        loginButton.click();
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
