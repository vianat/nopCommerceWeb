package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    public static WebDriver navigateTo(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
    public static void waitUntilElementToAppear(WebDriver driver, WebElement el){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) el));
    }
    public static void waitUntilElementToDisAppear(WebDriver driver, WebElement el){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(el));
    }

    public static void dynamicClickOnElement(WebDriver driver, WebElement element) {
//		 Actions actions = new Actions(driver);
//		 actions.moveToElement(element).click().perform();
        element.click();
    }
    public static void rightClickOnElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
    public static void doubleClickOnElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }
    public static void clickAndHoldOnElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold().perform();
    }
    public static String getTextFromElement (WebDriver driver, WebElement el) {
        return el.getText();
    }
    public static void switchToNewTab (WebDriver driver) {
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }

        }
    }
}
