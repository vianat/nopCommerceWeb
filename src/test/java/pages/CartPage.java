package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseClass;

public class CartPage extends BaseClass {



    @FindBy(id = "add-to-cart-button-4")
    public WebElement addtocart;
    @FindBy(xpath = "//span[@class='cart-label']")
    public WebElement shoppingcart;



    public CartPage(WebDriver driver) {
        driver = BaseClass.driver;
        PageFactory.initElements(driver, this);
    }
}
