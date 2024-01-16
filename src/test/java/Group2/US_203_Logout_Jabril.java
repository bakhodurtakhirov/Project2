package Group2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverClassWithLogin;

import java.time.Duration;

public class US_203_Logout_Jabril extends DriverClassWithLogin {
    @Test
    void test1() {
        //1. Open the web browser and navigate to "Demowebshop.tricentis.com ".
        // 2. On the homepage, log in (login).
        // 3. When the login is opened, verify that your user name appears.
        // 4. Click the "Logout" or "Output" link next to your username.
        // 5. Verify the output.
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
        myWait(3);

        WebElement logoutLink = driver.findElement(By.xpath("//a[@href='/logout']"));
        actions.click(logoutLink).perform();
        myWait(5);



        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals (currentUrl,"https://demowebshop.tricentis.com/"); {

            System.out.println("Log out is successful");

        }

    }
}























