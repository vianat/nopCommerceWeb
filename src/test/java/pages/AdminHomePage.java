package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseClass;

public class AdminHomePage extends BaseClass{
    @FindBy(xpath = "//p[normalize-space()='Customers']//i[@class='right fas fa-angle-left']")
    public WebElement expandCustomers;

    @FindBy(xpath = "//a[@href='/Admin/Customer/List']")
    public WebElement customers;

    @FindBy(xpath = "//a[normalize-space()='Add new']")
    public WebElement addNew;
    @FindBy(xpath = "//i[@class='nav-icon fas fa-shopping-cart']")
    public WebElement sales;

    public AdminHomePage(WebDriver driver) {
        driver = BaseClass.driver;
        PageFactory.initElements(driver, this);
    }
}