package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseClass;

public class MainPage extends BaseClass {
    @FindBy(xpath="//a[contains(text(),'Register')]")
    public WebElement registerBtn;

    @FindBy(xpath = "//a[@class='ico-login']")
    public WebElement loginBtn;
    @FindBy(xpath = "//a[@class='ico-logout']")
    public WebElement logOutBtn;
    @FindBy(tagName = "h2")
    public WebElement welcome;
    @FindBy(xpath = "//*[contains(text(),'Digital downloads ')]")
    public WebElement digitalDownloads;
    @FindBy(xpath = "//*[contains(text(),'Computers ')]")
    public WebElement Computers;
    @FindBy(xpath = "//img[@title='Show products in category Notebooks']")
    public WebElement Notebooks;
    @FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'FINAL SALE!!!! Apple MacBook Pro 13-inch')]")
    public WebElement appleMac;

    public MainPage(WebDriver driver) {
        driver = BaseClass.driver;
        PageFactory.initElements(driver, this);
    }
}