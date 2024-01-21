package Group2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.DriverClassWithLogin;

public class US_207_SurveyVoting_ZIyo extends DriverClassWithLogin {
    //1.Open the web browser and navigate to "Demo Web Shop ".
//2.If the user session is not open, log in (log in).
//3.On the homepage, "Do you like nopcommerce?" Answer the question.
//4.Select the "Excellent" option for voting.
//5.Click the relevant button to vote.

    @Test
    public void Test() {
        Actions actions = new Actions(driver);

        WebElement answers = driver.findElement(By.xpath("//li[@class=\"answer\"]"));
        if (answers.isDisplayed()){

        }else {

            WebElement questions = driver.findElement(By.xpath("(//ul[@class=\"poll-options\"]//li)[1]"));

            Action action = actions.click(questions).build();
            action.perform();

            WebElement vote = driver.findElement(By.cssSelector("input[id=\"vote-poll-1\"]"));
            action = actions.click(vote).build();
            action.perform();

        }
    }
}
