package Group2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverClassWithLogin;
import utilities.DriverClassWithoutLogin;

public class US_205_Login_Negative_Melik extends DriverClassWithoutLogin {

    @Test
    void logIn1() {
        Actions actions = new Actions(driver);
        WebElement login = driver.findElement(By.linkText("Log in"));
        actions.click(login).perform();

        WebElement email = driver.findElement(By.id("Email"));
        WebElement password = driver.findElement(By.id("Password"));
        actions.sendKeys(email," ").perform();
        actions.sendKeys(password, " ").perform();

        WebElement submit = driver.findElement(By.cssSelector("input[value=\"Log in\"]"));
        actions.click(submit).perform();

        WebElement check = driver.findElement(By.xpath("//li[text()=\"No customer account found\"]"));

        Assert.assertTrue(check.isDisplayed());
    }
    @Test
    void logIn2(){
        Actions actions = new Actions(driver);
        WebElement login = driver.findElement(By.linkText("Log in"));
        actions.click(login).perform();

        WebElement email = driver.findElement(By.id("Email"));
        WebElement password = driver.findElement(By.id("Password"));
        actions.sendKeys(email,"group_2@gmail.com").perform();
        actions.sendKeys(password, " ").perform();

        WebElement submit = driver.findElement(By.cssSelector("input[value=\"Log in\"]"));
        actions.click(submit).perform();

        WebElement check =
                driver.findElement(By.xpath("//li[text()=\"The credentials provided are incorrect\"]"));

        Assert.assertTrue(check.isDisplayed());
    }
    @Test
    void logIn3(){
        Actions actions = new Actions(driver);
        WebElement login = driver.findElement(By.linkText("Log in"));
        actions.click(login).perform();

        WebElement email = driver.findElement(By.id("Email"));
        WebElement password = driver.findElement(By.id("Password"));
        actions.sendKeys(email," ").perform();
        actions.sendKeys(password, "MichaelKnight1234").perform();

        WebElement submit = driver.findElement(By.cssSelector("input[value=\"Log in\"]"));
        actions.click(submit).perform();

        WebElement check = driver.findElement(By.xpath("//li[text()=\"No customer account found\"]"));

        Assert.assertTrue(check.isDisplayed());
    }
    @Test
    void logIn4(){
        Actions actions = new Actions(driver);
        WebElement login = driver.findElement(By.linkText("Log in"));
        actions.click(login).perform();

        WebElement email = driver.findElement(By.id("Email"));
        WebElement password = driver.findElement(By.id("Password"));
        actions.sendKeys(email,"michaelknight123@gmail.com").perform();
        actions.sendKeys(password, "Mknight123").perform();

        WebElement submit = driver.findElement(By.cssSelector("input[value=\"Log in\"]"));
        actions.click(submit).perform();

        WebElement check = driver.findElement(By.xpath("//li[text()=\"No customer account found\"]"));

        Assert.assertTrue(check.isDisplayed());
    }
}
