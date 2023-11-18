package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseClass;

public class LoginPage extends BaseClass {

    @FindBy(css="#Email")
    public WebElement email;

    @FindBy(css="#Password")
    public WebElement password;

    public LoginPage(WebDriver driver) {
        driver = BaseClass.driver;
        PageFactory.initElements(driver, this);
    }
}