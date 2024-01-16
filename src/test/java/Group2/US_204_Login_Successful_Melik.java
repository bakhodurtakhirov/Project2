package Group2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.DriverClassWithoutLogin;

public class US_204_Login_Successful_Melik extends DriverClassWithoutLogin {
    @Test
    void logIn(){
        Actions actions = new Actions(driver);
        WebElement login = driver.findElement(By.linkText("Log in"));
        actions.click(login).perform();

        WebElement email = driver.findElement(By.id("Email"));
        WebElement password = driver.findElement(By.id("Password"));
        actions.sendKeys(email,"group_2@gmail.com").perform();
        actions.sendKeys(password, "MichaelKnight1234").perform();

        WebElement submit = driver.findElement(By.cssSelector("input[value=\"Log in\"]"));
        actions.click(submit).perform();
    }
}
