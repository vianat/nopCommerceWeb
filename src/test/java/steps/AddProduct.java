package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.LoginPage;
import pages.MainPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class AddProduct extends BaseClass {

    CartPage cp = new CartPage(driver);
    MainPage mp = new MainPage(driver);

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @And("Click add to cart button")
    public void clickAddToCartButton() {
        cp.addtocart.click();
    }

    @And("Click shopping cart")
    public void clickShoppingCart() {
        cp.shoppingcart.click();
    }

    @Then("Verify the product is added")
    public void verifyTheProductIsAdded() {
        System.out.println("_-----------");
    }

    @And("Scroll down to element and click")
    public void scrollDownToElementAndClick() throws InterruptedException {
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1200);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mp.applemac);
        mp.applemac.click();
    }
}