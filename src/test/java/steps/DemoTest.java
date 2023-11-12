package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.MainPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class DemoTest extends BaseClass {

    MainPage mp = new MainPage(driver);
    LoginPage lp= new LoginPage(driver);
    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
    }

    @When("Click Login button")
    public void click_login_button() {

        mp.loginbtn.click();

    }
    @And("Enter email {string}")
    public void enterEmail(String email) {
        lp.email.sendKeys(email);
    }

    @And("Enter password {string}")
    public void enterPassword(String pass) {
        lp.password.sendKeys(pass);
    }

    @And("Push Enter")
    public void pushEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }


    @Then("Make sure you see Log out button")
    public void makeSureYouSeeLogOutButton() {
    }



}


