package Group2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.DriverClassWithLogin;

import java.time.Duration;

public class US_209_InvoiceDownload_Bakhodur extends DriverClassWithLogin {
    @Test
    void test1() {
        /*
        - Open the web browser and navigate to "Demowebshop.tricentis.com".
        - If the user session is not open, log in (login).
        - navigate to the "My Account" page by clicking on your username or e-mail address on the homepage.
        - View your orders by clicking on the "Orders" (Orders) link.
        - Click the "Details" link of the order (or Enson order) you want to view.
        - Download and view the invoice by clicking on the PDF Invioice link.
         */
        Actions actions = new Actions(driver);
        
        WebElement myAccount = driver.findElement(By.linkText("My account"));
        Action action = actions.click(myAccount).build();
        action.perform();
        
        WebElement orders = driver.findElement(By.linkText("Orders"));
        action = actions.click(orders).build();
        action.perform();
        
        WebElement order1 = driver.findElement(By.className("order-details-button"));
        action = actions.click(order1).build();
        action.perform();
        
        //In my browser it's automatically downloading the file without dialog box, so will not use Robot class
        WebElement pdfInvoice = driver.findElement(By.linkText("PDF Invoice"));
        action = actions.click(pdfInvoice).build();
        action.perform();
        
        myWait(10);
    }
}
