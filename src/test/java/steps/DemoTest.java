package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.MainPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class DemoTest extends BaseClass {

    MainPage mp = new MainPage(driver);
    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
    }

    @When("Type {string} in search field")
    public void typeInSearchField(String txt) {

        mp.search.sendKeys(txt);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    @When("Click on first link")
    public void clickOnFirstLink() {
        driver.findElement(By.xpath("(//a[@jsname='UWckNb'])[1]")).click();
    }

    @Then("Make sure the page title is {string}")
    public void makeSureThePageTitleIs(String arg0) {
        String actual = driver.getTitle();
        assertEquals(actual, arg0);
    }
}

