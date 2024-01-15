package Group2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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
        
        WebElement computers = driver.findElement(By.linkText("Computers"));
        Action action = actions.click(computers).build();
        action.perform();
        
        WebElement notebooks = driver.findElement(By.cssSelector("li[class=\"inactive\"]>[href=\"/notebooks\"]"));
        action = actions.click(notebooks).build();
        action.perform();
        
        WebElement laptop14inch = driver.findElement(By.linkText("14.1-inch Laptop"));
        action = actions.click(laptop14inch).build();
        action.perform();
        
        WebElement adToCart = driver.findElement(By.id("add-to-cart-button-31"));
        action = actions.click(adToCart).build();
        action.perform();
        
        WebElement shoppingCart = driver.findElement(By.className("cart-label"));
        action = actions.click(shoppingCart).build();
        action.perform();
        
        WebElement applyCoupon = driver.findElement(By.name("applydiscountcouponcode"));
        action = actions.click(applyCoupon).build();
        action.perform();
        
        WebElement couponMessage = driver.findElement(By.className("message"));
        Assert.assertTrue(couponMessage.getText().contains("couldn't be applied"));
        
        WebElement addGiftCard = driver.findElement(By.name("applygiftcardcouponcode"));
        action = actions.click(addGiftCard).build();
        action.perform();
        
        WebElement giftCardMessage = driver.findElement(By.className("message"));
        Assert.assertTrue(giftCardMessage.getText().contains("couldn't be applied"));
        
        WebElement termsofservice = driver.findElement(By.name("termsofservice"));
        action = actions.click(termsofservice).build();
        action.perform();
        
        WebElement checkOut = driver.findElement(By.cssSelector("button[id=checkout]"));
        action = actions.click(checkOut).build();
        action.perform();
        
        WebElement selectAddress = driver.findElement(By.id("billing-address-select"));
        Select select = new Select(selectAddress);
        select.selectByVisibleText("New Address");
        
        WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
        select = new Select(country);
        select.selectByVisibleText("United States");
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[text()=\"Alaska\"]")));
        WebElement stateProvince = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
        select = new Select(stateProvince);
        select.selectByVisibleText("Alaska");
        
        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
        action = actions.sendKeys(city, "Anycity").build();
        action.perform();
        
        WebElement address1 = driver.findElement(By.id("BillingNewAddress_Address1"));
        action = actions.sendKeys(address1, "AnyAddress").build();
        action.perform();
        
        WebElement zipCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        action = actions.sendKeys(zipCode, "11111").build();
        action.perform();
        
        WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        action = actions.sendKeys(phoneNumber, "1111111111").build();
        action.perform();
        
        WebElement continue1 = driver.findElement(By.xpath("(//input[@title=\"Continue\"])[1]"));
        action = actions.click(continue1).build();
        action.perform();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@title=\"Continue\"])[2]")));
        WebElement continue2 = driver.findElement(By.xpath("(//input[@title=\"Continue\"])[2]"));
        action = actions.click(continue2).build();
        action.perform();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shipping-method-next-step-button")));
        WebElement continue3 = driver.findElement(By.className("shipping-method-next-step-button"));
        action = actions.click(continue3).build();
        action.perform();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payment-method-next-step-button")));
        WebElement continue4 = driver.findElement(By.className("payment-method-next-step-button"));
        action = actions.click(continue4).build();
        action.perform();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payment-info-next-step-button")));
        WebElement continue5 = driver.findElement(By.className("payment-info-next-step-button"));
        action = actions.click(continue5).build();
        action.perform();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("confirm-order-next-step-button")));
        WebElement continue6 = driver.findElement(By.className("confirm-order-next-step-button"));
        action = actions.click(continue6).build();
        action.perform();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("strong")));
        WebElement orderMessage = driver.findElement(By.tagName("strong"));
        System.out.println("orderMessage.getText() = " + orderMessage.getText());
        Assert.assertTrue(orderMessage.getText().contains("Your order has been successfully processed!"));
        
        myWait(10);
    }
}
