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

public class US_206_OrederTest_Ziyo extends DriverClassWithLogin {
    //1.Open the web browser and navigate to "Demo Web Shop  ".//abcdef1234567890@gmail.com
//2 If the user session is not open, log in (log in).
//3 In the homepage, click "14.1-inin Laptop" under "Notebook" from the "Computers" menu.
//4 On the product page, click the "Add to Cart" button to add the product to the basket.
//5 Click the "Shopping Cart" button to navigate to your basket.
//6 Fill the necessary information for the cargo details:
//7 Choose a country and state.
//8 Accept the conditions.
//9.Click the "Checkout" (payment) button to navigate to the payment page.
//10.Fill the payment information and confirm the order.
//11.Verify the message "Your order has been successfully processed" ("Your Order Has Been SuccessFully Processed!").
//12.Verify that the order number exists on the Orders link on the home page. [For example: Order #1499948].


    @Test
    public void Test() {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        WebElement computers = driver.findElement(By.linkText("Computers"));
        Action action = actions.click(computers).build();
        action.perform();

        WebElement notebooks = driver.findElement(By.linkText("Notebooks"));
        action = actions.click(notebooks).build();
        action.perform();

        WebElement addToCart = driver.findElement(By.xpath("//input[@value=\"Add to cart\"]"));
        addToCart.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()=\"shopping cart\"]")));

        WebElement shoppingCart = driver.findElement(By.xpath("//a[text()=\"shopping cart\"]"));
        action = actions.click(shoppingCart).build();
        action.perform();

        WebElement country = driver.findElement(By.xpath("(//div[@class=\"inputs\"]//select)[1]"));
        Select select = new Select(country);
        select.selectByVisibleText("United States");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[text()=\"Alaska\"]")));

        WebElement state = driver.findElement(By.xpath("(//div[@class=\"inputs\"]//select)[2]"));
        Select select1 = new Select(state);
        select1.selectByVisibleText("Alaska");

        WebElement terms = driver.findElement(By.cssSelector("input[id=\"termsofservice\"]"));
        action = actions.click(terms).build();
        action.perform();

        WebElement checkOut = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        action = actions.click(checkOut).build();
        action.perform();

        wait.until(ExpectedConditions.urlContains("onepagecheckout"));

        WebElement newAddress = driver.findElement(By.xpath("//select[@id=\"billing-address-select\"]"));
        Select select2 = new Select(newAddress);
        select2.selectByVisibleText("New Address");

        WebElement country2 = driver.findElement(By.xpath("//select[@id=\"BillingNewAddress_CountryId\"]"));
        Select select3 = new Select(country2);
        select3.selectByVisibleText("United States");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[text()=\"Alaska\"]")));

        WebElement stateProvince = driver.findElement(By.xpath("//select[@id=\"BillingNewAddress_StateProvinceId\"]"));
        Select select4 = new Select(stateProvince);
        select4.selectByVisibleText("Alabama");

        WebElement city = driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_City\"]"));
        action = actions.click(city).sendKeys("Birmingham").build();
        action.perform();

        WebElement address = driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_Address1\"]"));
        action = actions.click(address).sendKeys("1234 Main Street").build();
        action.perform();

        WebElement postalCode = driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_ZipPostalCode\"]"));
        action = actions.click(postalCode).sendKeys("09876").build();
        action.perform();

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_PhoneNumber\"]"));
        action = actions.click(phoneNumber).sendKeys("1234567890").build();
        action.perform();

        WebElement continueButton = driver.findElement(By.xpath("(//input[@title=\"Continue\"])[1]"));
        action = actions.click(continueButton).build();
        action.perform();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@name=\"shipping_address_id\"]")));
        WebElement shippingAddress = driver.findElement(By.xpath("//select[@name=\"shipping_address_id\"]"));
        Select select5 = new Select(shippingAddress);
        select5.selectByVisibleText("Michael Knight, 1234 Main Street, Birmingham, Alabama 09876, United States");

        WebElement continue2 = driver.findElement(By.xpath("(//input[@value=\"Continue\"])[2]"));
        action = actions.click(continue2).build();
        action.perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value=\"Continue\"])[3]")));

        WebElement continue3 = driver.findElement(By.xpath("(//input[@value=\"Continue\"])[3]"));
        action = actions.click(continue3).build();
        action.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"button-1 payment-method-next-step-button\"]")));

        WebElement continue4 = driver.findElement(By.xpath("//input[@class=\"button-1 payment-method-next-step-button\"]"));
        action = actions.click(continue4).build();
        action.perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"button-1 payment-info-next-step-button\"]")));

        WebElement continue5 = driver.findElement(By.xpath("//input[@class=\"button-1 payment-info-next-step-button\"]"));
        action = actions.click(continue5).build();
        action.perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"button-1 confirm-order-next-step-button\"]")));

        WebElement confirm = driver.findElement(By.xpath("//input[@class=\"button-1 confirm-order-next-step-button\"]"));
        action = actions.click(confirm).build();
        action.perform();
        wait.until(ExpectedConditions.urlContains("completed"));

        WebElement message = driver.findElement(By.xpath("//strong[text()=\"Your order has been successfully processed!\"]"));
        Assert.assertTrue(message.getText().equals("Your order has been successfully processed!"));

        WebElement continue6 = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        action = actions.click(continue6).build();
        action.perform();

        WebElement orders = driver.findElement(By.xpath("//a[text()=\"Orders\"]"));
        action = actions.click(orders).build();
        action.perform();
        wait.until(ExpectedConditions.urlContains("orders"));

        WebElement orderNumber = driver.findElement(By.xpath("//strong[text()=\"Order Number: 1582796\"]"));
        Assert.assertTrue(orderNumber.isDisplayed());
    }
}
