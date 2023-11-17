package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DigitalDownloadsPage;
import pages.MainPage;
import pages.WishListPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class WishlistTest extends BaseClass {

    DigitalDownloadsPage dd = new DigitalDownloadsPage(driver);
    MainPage mp = new MainPage(driver);
    WishListPage wp = new WishListPage(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebDriverWait wait;

    // sdsd
    @When("click Digital downloads")
    public DigitalDownloadsPage clickDigitalDownloads() throws InterruptedException {
        Thread.sleep(500);
        mp.digitalDownloads.click();
        return new DigitalDownloadsPage(driver);
    }

    @And("add to wishlist second product")
    public void addToWishlistSecondProduct() throws InterruptedException {
        Thread.sleep(500);
        dd.addToWish.click();
    }

    @And("close header pop-up notification")
    public void closeHeaderPopUpNotification() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Close']")));
        driver.findElement(By.xpath("//span[@title='Close']")).click();
        js.executeScript("window.scrollBy(0,10)");
    }

    @And("open wishlist")
    public WishListPage openWishlist() throws InterruptedException {
        Thread.sleep(1000);
        dd.wishList.click();
        return new WishListPage(driver);
    }

    @And("check wishlist is not empty")
    public void checkWishlistIsNotEmpty() throws InterruptedException {
        Thread.sleep(500);
        boolean actual = wp.updateWishlist.isDisplayed();
        assertEquals(actual, true);
    }

    @And("change number of product to {int}")
    public void changeNumberOfProductTo(int arg0) throws InterruptedException {
        Thread.sleep(500);
        WebElement qty = driver.findElement(By.className("qty-input"));
        qty.clear();
        qty.sendKeys("" + arg0);
    }

    @And("click update wishlist button")
    public void clickUpdateWishlistButton() throws InterruptedException {
        Thread.sleep(500);
        wp.updateWishlist.click();
    }

    @And("verify qty of items is {int}")
    public void verifyQtyOfItemsIs(int qty) throws InterruptedException {
        Thread.sleep(500);
        assertEquals(driver.findElement(By.className("qty-input")).getAttribute("value"), "" + qty);
    }

    @And("click remove btn")
    public void clickRemoveBtn() throws InterruptedException {
        Thread.sleep(500);
        wp.removeBtn.click();
    }

    @Then("Check if the message {string} appeared")
    public void checkIfTheMessageAppeared(String expected) throws InterruptedException {
        Thread.sleep(500);
        String actual = driver.findElement(By.xpath("//div[@class='no-data']")).getText().trim();
        assertEquals(actual, expected);
    }
}