package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseClass;

public class RegisterPage extends BaseClass {

    @FindBy(id="gender-female")
    public WebElement genderFemale;
    @FindBy(id="FirstName")
    public WebElement firstName;
    @FindBy(id="LastName")
    public WebElement lastName;

    @FindBy(id="Email")
    public WebElement email;
    @FindBy(id="Password")
    public WebElement password;
    @FindBy(id="ConfirmPassword")
    public WebElement confirmPassword;
    @FindBy(xpath="//select[@name='DateOfBirthDay']")
    public WebElement day;
    @FindBy(xpath="//select[@name='DateOfBirthMonth']")
    public WebElement month;
    @FindBy(xpath="//select[@name='DateOfBirthYear']")
    public WebElement year;
    @FindBy(id="register-button")
    public WebElement registerBtn;

    public RegisterPage(WebDriver driver) {
        driver = BaseClass.driver;
        PageFactory.initElements(driver, this);
    }
}