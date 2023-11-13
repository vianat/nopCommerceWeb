package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
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

    @When("click Digital downloads")
    public DigitalDownloadsPage clickDigitalDownloads() {
        mp.digitalDownloads.click();
        return new DigitalDownloadsPage(driver);
    }
    @And("add to wishlist second product")
    public void addToWishlistSecondProduct() {
        dd.addToWish.click();
    }

    @And("close header pop-up notification")
    public void closeHeaderPopUpNotification() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Close']")));
        driver.findElement(By.xpath("//span[@title='Close']")).click();
        Thread.sleep(1500);
    }

    @And("open wishlist")
    public WishListPage openWishlist() {
        dd.wishList.click();
        return new WishListPage(driver);
    }

    @And("check wishlist is not empty")
    public void checkWishlistIsNotEmpty() {
        boolean actual = wp.updateWishlist.isDisplayed();
        assertEquals(actual, true);
    }

    @And("change number of product to {string}")
    public void changeNumberOfProductTo(String arg0) {
        WebElement qty = driver.findElement(By.className("qty-input"));
        qty.clear();
        qty.sendKeys(arg0);
    }

    @And("click update wishlist button")
    public void clickUpdateWishlistButton() {
        wp.updateWishlist.click();
    }

    @And("verify qty of items is {string}")
    public void verifyQtyOfItemsIs(String arg0) {
        assertEquals(driver.findElement(By.className("qty-input")).getAttribute("value"), arg0);
    }

    @And("click remove btn")
    public void clickRemoveBtn() {
        wp.removeBtn.click();
    }

    @Then("verify the wishlist is empty and you see {string}")
    public void verifyTheWishlistIsEmptyAndYouSee(String expeted) {
        WebElement actual = driver.findElement(By.xpath("//div[@class='no-data']"));
        assertEquals(actual.getText(), expeted);
    }
}