package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseClass {

    MainPage mp = new MainPage(driver);
    LoginPage lp = new LoginPage(driver);

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(1500);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        Thread.sleep(2000);
    }

    @When("Click Login button")
    public LoginPage click_login_button() throws InterruptedException {
        mp.loginBtn.click();
        Thread.sleep(300);
        return new LoginPage(driver);
    }

    @And("Enter email {string}")
    public void enterEmail(String email) throws InterruptedException {
        Thread.sleep(1000);
        lp.email.sendKeys(email);
    }

    @And("Enter password {string}")
    public void enterPassword(String pass) throws InterruptedException {
        Thread.sleep(500);
        lp.password.sendKeys(pass);
    }

    @And("Push Enter")
    public MainPage pushEnter() throws InterruptedException {
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        return new MainPage(driver);
    }

    @Then("Make sure you see Log out button and text: {string}")
    public void makeSureYouSeeLogOutButtonAndText(String text) throws InterruptedException {
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String actual = mp.logOutBtn.getText();
        String expected = "Log out";
        assertEquals(actual, expected);
        assertEquals(mp.welcome.getText(), text);
    }

    @And("Click [Register] button")
    public RegisterPage clickRegisterButton() {
        mp.registerBtn.click();
        return new RegisterPage(driver);
    }

}