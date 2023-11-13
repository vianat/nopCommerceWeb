package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseClass;

public class DigitalDownloadsPage extends BaseClass {

    @FindBy(xpath = "(//button[@title='Add to wishlist'][normalize-space()='Add to wishlist'])[2]")
    public WebElement addToWish;
    @FindBy(xpath = "//span[@class='wishlist-label']")
    public WebElement wishList;

    public DigitalDownloadsPage(WebDriver driver) {
        driver = BaseClass.driver;
        PageFactory.initElements(driver, this);
    }
}
