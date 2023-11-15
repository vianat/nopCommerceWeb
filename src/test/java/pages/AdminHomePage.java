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

    @FindBy(xpath = "//i[@class='nav-icon fas fa-book']")
    public WebElement catalog;

    @FindBy(xpath = "//a[@href='/Admin/Product/List']")
    public WebElement products;

    @FindBy(id = "Name")
    public WebElement productName;

    @FindBy(id = "ShortDescription")
    public WebElement shortDescription;

    @FindBy(xpath = "//div[@id='product-price-area']//input[@title='0.0000 USD']")
    public WebElement price;

    @FindBy(xpath = "//input[@title='0.0000 lb(s)']")
    public WebElement weight;

    @FindBy(id = "ManageInventoryMethodId")
    public WebElement inventory;

    @FindBy(xpath = "//button[@name='save']")
    public WebElement save;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    public WebElement alertMsg;
    @FindBy(id = "btnChangeOrderStatus")
    public WebElement changeOrder;
    @FindBy(name = "btnEditOrderTotals")
    public WebElement editOrderTotals;
    @FindBy(id = "btnSaveOrderTotals")
    public WebElement saveOrderTotals;
    @FindBy(id = "OrderStatusId")
    public WebElement orderStatus;
    @FindBy(xpath = "(//span[@class='k-numeric-wrap k-state-default'])[11]//following::input")
    public WebElement orderTotalInput;
    @FindBy(id = "btnSaveOrderStatus")
    public WebElement saveOrderStatus;
    @FindBy(id = "btnSaveOrderStatus-action-confirmation-submit-button")
    public WebElement acceptOrderConfirmation;
    @FindBy(id = "btnSaveOrderTotals-action-confirmation-submit-button")
    public WebElement acceptTotalConfirmation;

    public AdminHomePage(WebDriver driver) {
        driver = BaseClass.driver;
        PageFactory.initElements(driver, this);
    }
}