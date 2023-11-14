package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseClass;

public class RegisterPage extends BaseClass {

    @FindBy(xpath="//a[contains(text(),'Register')]")
    public WebElement registerBtn;

    public RegisterPage(WebDriver driver) {
        driver = BaseClass.driver;
        PageFactory.initElements(driver, this);
    }
}