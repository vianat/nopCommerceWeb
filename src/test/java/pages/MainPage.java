package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseClass;

public class MainPage extends BaseClass {

    @FindBy(xpath = "//a[@class='ico-login']")
    public WebElement loginbtn;
    @FindBy(xpath = "//a[@class='ico-logout']")
    public WebElement logoutbtn;
    @FindBy(tagName = "h2")
    public WebElement welcome;
    @FindBy(xpath = "//*[contains(text(),'Digital downloads ')]")
    public WebElement digitalDownloads;

    public MainPage(WebDriver driver) {
        driver = BaseClass.driver;
        PageFactory.initElements(driver, this);
    }
}
