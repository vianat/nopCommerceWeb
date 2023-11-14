package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseClass;

public class CartPage extends BaseClass {

    @FindBy(xpath = "//button[@id='add-to-cart-button-4']")
    public WebElement addToCart;
    @FindBy(xpath = "//a[@class='ico-cart']")
    public WebElement shoppingCart;

    public CartPage(WebDriver driver) {
        driver = BaseClass.driver;
        PageFactory.initElements(driver, this);
    }
}
