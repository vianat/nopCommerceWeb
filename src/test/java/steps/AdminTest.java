package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdminHomePage;
import java.time.Duration;
import java.util.Random;
import static org.testng.Assert.*;

public class AdminTest extends BaseClass {
    AdminHomePage ap = new AdminHomePage(driver);
    Random rand = new Random();
    String email;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @And("Expand customers panel")
    public void expandCustomersPanel() {
        wait.until(ExpectedConditions.elementToBeClickable(ap.expandCustomers));
        ap.expandCustomers.click();
    }

    @And("Click on customers in panel")
    public void clickOnCustomersInPanel() {
        wait.until(ExpectedConditions.elementToBeClickable(ap.customers));
        ap.customers.click();
    }

    @And("Click Add new button")
    public void clickAddNewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ap.addNew));
        ap.addNew.click();
    }

    @And("Type email in [email] field")
    public void typeEmailInEmailField() {
        int random = rand.nextInt(1000 - 1) + 1;
        email = "random" + random + "@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(email);
    }

    @And("Click [save] button")
    public void clickSaveButton() {
        driver.findElement(By.name("save")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + email + "')]")));
    }

    @And("Verify that the client has been created and exists in the client list")
    public void verifyThatTheClientHasBeenCreatedAndExistsInTheClientList() {
        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'" + email + "')]"));
        assertEquals(el.getText(), email);
    }

    @And("Click [edit] button for this customer")
    public void click_edit_button_for_this_customer() {
        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'" + email + "')]//parent::tr//following::a"));
        el.click();
    }

    @And("Click [delete] button")
    public void click_delete_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-delete")));
        driver.findElement(By.id("customer-delete")).click();
    }

    @And("Accept alert")
    public void AcceptAlert(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Delete')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
    }

    @Then("Verify that the client has been deleted")
    public void verifyThatTheClientHasBeenDeleted() {
        assertEquals(isElementPresented(), true);
    }

    public boolean isElementPresented() {
        WebElement el = driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(2)"));
        if (el.getText().equals(email)){
            return false;
        }
        return true;
    }

    @And("wait {int}")
    public void wait(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }
}