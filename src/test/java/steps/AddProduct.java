package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.CartPage;
import pages.MainPage;

import static org.testng.Assert.assertEquals;

public class AddProduct extends BaseClass {

    CartPage cp = new CartPage(driver);
    MainPage mp = new MainPage(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String productName;

    @And("Add product to cart")
    public void addProductToCart() {
        productName = driver.findElement(By.tagName("h1")).getText();
        cp.addToCart.click();
    }

    @And("Click shopping cart")
    public void clickShoppingCart() {
        cp.shoppingCart.click();
    }

//    @And("Scroll down to element and click")
//    public void scrollDownToElementAndClick() throws InterruptedException {
//        js.executeScript("window.scrollBy(0,1000)");
//        Thread.sleep(1200);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mp.appleMac);
//        mp.appleMac.click();
//    }

    @And("Click on the Computers category")
    public void clickOnTheComputersCategory() {
        mp.Computers.click();
    }

    @And("Click on the Notebooks category")
    public void clickOnTheNotebooksCategory() {
        mp.Notebooks.click();
    }

    @And("Click on the product")
    public void clickOnTheProduct() {
        mp.appleMac.click();
    }

    @Then("Verify the product is added")
    public void verifyTheProductIsAdded() {
        String actual = driver.findElement(By.xpath("//a[@class='product-name'][normalize-space()='"+ productName +"']")).getText();
        assertEquals(actual, productName);
    }

    @And("remove all items from cart")
    public void removeAllItemsFromCart() throws InterruptedException {
        int productCount = driver.findElements(By.className("remove-btn")).size();
        for(int x = 1; x <= productCount; x++){
            driver.findElement(By.className("remove-btn")).click();
            Thread.sleep(200);
        }
    }
}