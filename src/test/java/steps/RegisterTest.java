package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.MainPage;
import pages.RegisterPage;

import java.security.Key;
import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;

public class RegisterTest extends BaseClass {
    RegisterPage rp = new RegisterPage(driver);
    String name;
    String email;
    String password = "Pas#ddfr2452";
    Random rand = new Random();

    @Then("Verify you on register page and see {string}")
    public void verifyYouOnRegisterPageAndSee(String expected) {
        String actual = driver.findElement(By.tagName("h1")).getText();
        assertEquals(actual, expected);
    }

    @And("Select female gender")
    public void selectFemaleGender() {
        rp.genderFemale.click();
    }

    @And("Enter valid first name in [first name] field")
    public void enterValidFirstNameInFirstNameField() {
        int random = rand.nextInt(1000 - 1) + 1;
        name = "generateName" + random;
        rp.firstName.sendKeys(name);
    }

    @And("Enter valid last name in [last name] field")
    public void enterValidLastNameInLastNameField() {
        rp.lastName.sendKeys("Last" + name);
    }

    @And("Enter valid email in [email] field")
    public void enterValidEmailInEmailField() {
        email = name + "@gmail.com";
        rp.email.sendKeys(email);
    }

    @And("Enter valid password in [password] field")
    public void enterValidPasswordInPasswordField() {
        rp.password.sendKeys(password);
    }

    @And("Enter valid password in [confirm password] field")
    public void enterValidPasswordInConfirmPasswordField() {
        rp.confirmPassword.sendKeys(password);
    }

    @And("Click [Register] button for register form")
    public void clickRegisterButtonForRegisterForm() {
        rp.registerBtn.click();
    }

    @Then("Verify you see message {string}")
    public void verifyYouSeeMessage(String expected) {
        String actual = driver.findElement(By.xpath("//div[@class='result']")).getText();
        assertEquals(actual, expected);
    }

    @And("Enter invalid email {string} in [email] field")
    public void enterInvalidEmailInEmailField(String invEmail) {
        rp.email.sendKeys(invEmail);
    }

    @Then("Verify you see message {string} bellow email field")
    public void verifyYouSeeMessageBellowEmailField(String expected) {
        String actual = driver.findElement(By.xpath("//span[@class='field-validation-error']")).getText();
        assertEquals(actual, expected);
    }
}