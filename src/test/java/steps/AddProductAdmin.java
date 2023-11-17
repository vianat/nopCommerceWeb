package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AdminHomePage;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddProductAdmin extends BaseClass {

    AdminHomePage ap = new AdminHomePage(driver);

    @And("Click Catalog")
    public void clickCatalog() throws InterruptedException {
        Thread.sleep(500);
        ap.catalog.click();
    }

    @And("Click Products")
    public void clickProducts() throws InterruptedException {
        Thread.sleep(500);
        ap.products.click();
    }

    @And("Click Add New")
    public void clickAddNew() throws InterruptedException {
        Thread.sleep(500);
        ap.addNew.click();
    }

    @And("Fill in Product Name {string}")
    public void fillInProductName(String productname) throws InterruptedException {
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Name']")));
        ap.productName.sendKeys(productname);
    }

    @And("Fill in Product Short Description {string}")
    public void fillInProductShortDescription(String shortdesc) throws InterruptedException {
        Thread.sleep(500);
        ap.shortDescription.sendKeys(shortdesc);

    }

    @And("Clean the textbox and add price {int}")
    public void cleanTheTextboxAndAddPrice(int price) throws InterruptedException {
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ap.price);
        ap.price.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE) + price);
    }

    @And("Clean the shippingtxtbox and add weight {int}")
    public void cleanTheShippingtxtboxAndAddWeight(int weight) throws InterruptedException {
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ap.weight);
        ap.weight.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE) + weight);
    }

    @And("Choose inventory method")
    public void chooseInventoryMethod() throws InterruptedException {
        Thread.sleep(500);

        Select inventory = new Select(ap.inventory);

        List<WebElement> options = inventory.getOptions();

        for (int i = 0; i < options.size(); i++) {
            WebElement option = options.get(i);
        }
        if (!options.isEmpty()) {
            inventory.selectByIndex(1);
        }
    }

    @And("Click Save button")
    public void clickSaveButton() throws InterruptedException {
        Thread.sleep(500);
        ap.save.click();
    }

    @Then("Verify the product added message {string}")
    public void verifyTheProductAddedMessage(String expected) throws InterruptedException {
        Thread.sleep(500);
        String actual = ap.alertMsg.getText().substring(1).trim();
        Assert.assertEquals(expected, actual);
    }
}

