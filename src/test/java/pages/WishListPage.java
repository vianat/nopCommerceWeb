package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseClass;

public class WishListPage extends BaseClass {

    @FindBy(id = "updatecart")
    public WebElement updateWishlist;
    @FindBy(css = "button[name='addtocartbutton']")
    public WebElement addToCart;
    @FindBy(xpath = "//button[@class='remove-btn']")
    public WebElement removeBtn;

    public WishListPage(WebDriver driver) {
        driver = BaseClass.driver;
        PageFactory.initElements(driver, this);
    }
}
