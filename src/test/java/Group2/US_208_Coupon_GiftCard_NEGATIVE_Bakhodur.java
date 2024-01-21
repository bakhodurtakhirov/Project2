package Group2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverClassWithLogin;

import java.time.Duration;

public class US_208_Coupon_GiftCard_NEGATIVE_Bakhodur extends DriverClassWithLogin {
    
    @Test
    void test1() {
        /*
        1. Open the web browser and navigate to "Demowebshop.tricentis.com ".
        2. If the user session is not open, log in (log in).
        3. In the homepage, click "14.1-inin Laptop" under "Notebook" from the "Computers" menu.
        4. On the product page, click the "Add to Cart" button to add the product to the basket.
        5. Click the "Shopping Cart" button to navigate to your basket.
        6. Click the "Apply Coupon" button (Use Coupon) (click on the Coupon Code If you do not enter the code).
        7. Verify that there is no coupon code to be used.
        8.
        9. Verify that there is no Gift Card to be used.
        10. Fill the necessary information for the cargo details:
        11. Choose a country and state.
        12. Accept the conditions.
        13. Click the "Checkout" (payment) button to navigate to the payment page.
        14. Fill the payment information and confirm the order.
        15 "Your order has been successfully processed!" Verify that the message is displayed.
        */
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        actions.click(driver.findElement(By.linkText("Computers"))).perform();
        
        actions.click(driver.findElement(By.cssSelector("li[class=\"inactive\"]>[href=\"/notebooks\"]"))).perform();
        
        actions.click(driver.findElement(By.linkText("14.1-inch Laptop"))).perform();
        
        actions.click(driver.findElement(By.id("add-to-cart-button-31"))).perform();
        
        actions.click(driver.findElement(By.className("cart-label"))).perform();
        
        actions.click(driver.findElement(By.name("applydiscountcouponcode"))).perform();
        
        Assert.assertTrue(driver.findElement(By.className("message")).getText().contains("couldn't be applied"));
        
        actions.click(driver.findElement(By.name("applygiftcardcouponcode"))).perform();
        
        Assert.assertTrue(driver.findElement(By.className("message")).getText().contains("couldn't be applied"));
        
        actions.click(driver.findElement(By.name("termsofservice")));
        
        actions.click(driver.findElement(By.cssSelector("button[id=checkout]"))).perform();
        
        new Select(driver.findElement(By.id("billing-address-select"))).selectByVisibleText("New Address");
        
        new Select(driver.findElement(By.id("BillingNewAddress_CountryId"))).selectByVisibleText("United States");
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[text()=\"Alaska\"]")));
        new Select(driver.findElement(By.id("BillingNewAddress_StateProvinceId"))).selectByVisibleText("Alaska");
        
        actions.sendKeys(driver.findElement(By.id("BillingNewAddress_City")), "Anycity");
        actions.sendKeys(driver.findElement(By.id("BillingNewAddress_Address1")), "AnyAddress");
        actions.sendKeys(driver.findElement(By.id("BillingNewAddress_ZipPostalCode")), "11111");
        actions.sendKeys(driver.findElement(By.id("BillingNewAddress_PhoneNumber")), "1111111111");
        actions.click(driver.findElement(By.xpath("(//input[@title=\"Continue\"])[1]"))).perform();
        
        actions.click(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@title=\"Continue\"])[2]")))).perform();
        
        actions.click(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shipping-method-next-step-button")))).perform();
        
        actions.click(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payment-method-next-step-button")))).perform();
        
        actions.click(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payment-info-next-step-button")))).perform();
        
        actions.click(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("confirm-order-next-step-button")))).perform();
        
        System.out.println("orderMessage.getText() = " + wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("strong"))).getText());
        Assert.assertTrue(driver.findElement(By.tagName("strong")).getText().contains("Your order has been successfully processed!"));
        
        myWait(5);
    }
}
