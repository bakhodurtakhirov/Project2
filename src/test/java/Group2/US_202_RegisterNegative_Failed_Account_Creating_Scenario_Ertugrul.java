package Group2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.DriverClassWithLogin;

public class US_202_RegisterNegative_Failed_Account_Creating_Scenario_Ertugrul  {

/**
               1.Open the web browser and navigate to ""Demowebshop.tricentis.com "".
             2. Click the ""Register"" button on the 2nd homepage.
             3. In the ""Your Personal Details"" section, fill out the information given in the test data:
               Click the ""Register"" button to register.

 **/


@Test
void Test2(){

    WebDriver driver = new ChromeDriver();
    Actions actions = new Actions(driver);

    driver.get("https://demowebshop.tricentis.com/");

    WebElement registerLink = driver.findElement(By.xpath("//a[@href='/register' and contains(@class, 'ico-register')]"));
    actions.click(registerLink).perform();



    WebElement maleRadio = driver.findElement(By.xpath("//input[@id='gender-female' and @name='Gender' and @type='radio' and @value='F']"));
    actions.click(maleRadio).perform();

    WebElement eMail1 = driver.findElement(By.id("Email"));
    actions.sendKeys(eMail1, "techno.team12@gmail.com").perform();

    WebElement register1 = driver.findElement(By.id("register-button"));
    register1.click();

    WebElement firstName = driver.findElement(By.id("FirstName"));
    actions.sendKeys(firstName, "Mary").perform();

    WebElement lastName = driver.findElement(By.id("LastName"));
    actions.sendKeys(lastName, "Johnson").perform();


    WebElement password = driver.findElement(By.id("Password"));
    actions.sendKeys(password, "pass1234").perform();

    WebElement Confirmpassword = driver.findElement(By.id("ConfirmPassword"));
    actions.sendKeys(Confirmpassword, "pass1234").perform();

    if (password.getAttribute("value").equals(Confirmpassword.getAttribute("value"))) {
        System.out.println("Passwords match.");
    } else {
        System.out.println("Passwords do not match. Please enter the correct passwords.");
    }


    WebElement register = driver.findElement(By.id("register-button"));
    register.click();


    WebElement eMailagain = driver.findElement(By.id("Email"));
    eMailagain.clear();
    eMailagain.sendKeys("123456asdf2h2@gmail.com");

    WebElement registeragain = driver.findElement(By.id("register-button"));
    registeragain.click();




}

}
