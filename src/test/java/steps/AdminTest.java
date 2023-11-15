package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdminHomePage;

import java.security.Key;
import java.time.Duration;
import java.util.Random;

import static org.testng.Assert.*;

public class AdminTest extends BaseClass {
    AdminHomePage ap = new AdminHomePage(driver);
    Random rand = new Random();
    String email;
    String orderPrice;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @And("Expand customers panel")
    public void expandCustomersPanel() {
        wait.until(ExpectedConditions.elementToBeClickable(ap.expandCustomers));
        ap.expandCustomers.click();
    }

    @And("Click on customers in panel")
    public void clickOnCustomersInPanel() {
        wait.until(ExpectedConditions.elementToBeClickable(ap.customers));
        ap.customers.click();
    }

    @And("Click Add new button")
    public void clickAddNewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ap.addNew));
        ap.addNew.click();
    }

    @And("Type email in [email] field")
    public void typeEmailInEmailField() {
        int random = rand.nextInt(1000 - 1) + 1;
        email = "random" + random + "@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(email);
    }

    @And("Click [save] button")
    public void clickSaveButton() {
        driver.findElement(By.xpath("//button[@name='save']")).click();
    }

    @And("Verify that the client has been created and exists in the client list")
    public void verifyThatTheClientHasBeenCreatedAndExistsInTheClientList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + email + "')]")));
        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'" + email + "')]"));
        assertEquals(el.getText(), email);
    }

    @And("Click [edit] button for this customer")
    public void click_edit_button_for_this_customer() {
        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'" + email + "')]//parent::tr//following::a"));
        el.click();
    }

    @And("Click [delete] button")
    public void click_delete_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-delete")));
        driver.findElement(By.id("customer-delete")).click();
    }

    @And("Accept alert")
    public void AcceptAlert() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Delete')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
    }

    @Then("Verify that the client has been deleted")
    public void verifyThatTheClientHasBeenDeleted() {
        assertEquals(isElementPresented(), true);
    }

    public boolean isElementPresented() {
        WebElement el = driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(2)"));
        if (el.getText().equals(email)) {
            return false;
        }
        return true;
    }

    @And("wait {int}")
    public void wait(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    @Then("Error message {string} is appear")
    public void errorMessageIsAppear(String expected) {
        String actual = driver.findElement(By.xpath("//span[@class='field-validation-error']")).getText();
        assertEquals(actual, expected);
    }

    @Then("Error message in top section {string} is appear")
    public void errorMessageInTopSectionIsAppear(String expected) {
        String actual = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li[1]")).getText();
        assertEquals(actual, expected);
    }

    @And("Clean email field")
    public void cleanEmailField() {
        driver.findElement(By.id("Email")).clear();
        System.out.println(driver.findElement(By.id("Email")).getText());
    }

    @And("Type {string} in [email] field")
    public void typeInEmailField(String email) {
        driver.findElement(By.id("Email")).sendKeys(email);
    }

    @And("Click on sales in panel")
    public void clickOnSalesInPanel() {
        ap.sales.click();
    }

    @And("Click on orders in panel")
    public void clickOnOrdersInPanel() {
        driver.findElement(By.xpath("//li[@class='nav-item has-treeview menu-is-opening menu-open']//li[1]//a[1]")).click();
    }

    @And("Click first view button in table")
    public void clickFirstViewButtonInTable() {
        driver.findElement(By.xpath("//tbody/tr[1]/td[9]/a[1]")).click();
        orderPrice = driver.findElement(By.xpath("//div[5]//div[2]//div[1]")).getText();
    }

    @And("Click [change order status] button")
    public void clickChangeOrderStatusButton() {
        ap.changeOrder.click();
    }

    @And("Set [order statuses] {string}")
    public void setOrderStatuses(String status) throws InterruptedException {
        driver.findElement(By.xpath("//div[5]//div[2]//div[1]//div[1]")).click();
        System.out.println("1");
        Thread.sleep(500);
//        driver.findElement(By.xpath("//option[contains(text(),'" + status + "')]")).click();
        driver.findElement(By.xpath("//div[5]//div[2]//div[1]//div[1]")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("select[id='OrderStatusIds'] option[value='10']")).click();
        System.out.println("2");
//        driver.findElement(By.xpath("//select[@id='OrderStatusIds']//option[@value='10'][normalize-space()='" + status + "']")).click();
    }

    @And("Click [search] button")
    public void clickSearchButton() {
        ap.searchOrders.click();
    }
    @And("Click [delete order] button")
    public void clickDeleteOrderButton() {
        ap.orderDelete.click();
    }

    @And("Click [order status] button")
    public void clickOrderStatusButton() {
        ap.orderStatus.click();
        System.out.println("3");
    }

    @And("Click [cancel order] button")
    public void clickCancelOrderButton() {
        ap.cancelOrder.click();
    }

    @And("Set {string} status")
    public void setStatus(String status) {
        driver.findElement(By.xpath("//option[contains(text(),'" + status + "')]")).click();
//        switch (status) {
//            case "Pending":
//                driver.findElement(By.xpath("//option[contains(text(),'Pending')]")).click();
////                driver.findElement(By.xpath("//option[@value='10']")).click();
//                break;
//            case "Processing":
//                driver.findElement(By.xpath("//option[contains(text(),'Processing')]")).click();
//                break;
//            case "Complete":
//                driver.findElement(By.xpath("//option[contains(text(),'Complete')]")).click();
//                break;
//            case "Cancelled":
//                driver.findElement(By.xpath("//option[contains(text(),'Cancelled')]")).click();
//                break;
//        }
    }

    @And("Click [save] status button")
    public void clickSaveStatusButton() {
        ap.saveOrderStatus.click();
    }

    @And("Accept total confirmation")
    public void acceptTotalConfirmation() {
        ap.acceptTotalConfirmation.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]//div[2]//div[1]")));
    }

    @And("Accept order confirmation")
    public void acceptOrderConfirmation() {
        ap.acceptOrderConfirmation.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='font-weight-bold']")));
    }

    @And("Accept cancel confirmation")
    public void acceptCancelConfirmation() {
        ap.acceptCancelConfirmation.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='font-weight-bold']")));
    }

    @Then("Verify order status is {string}")
    public void verifyOrderStatusIs(String expected) {
        String actual = driver.findElement(By.xpath("//div[@class='font-weight-bold']")).getText();
        assertEquals(actual, expected);
    }

    @And("Click [edit Order Total] button")
    public void clickEditOrderTotalButton() {
        ap.editOrderTotals.click();
    }

    @And("Set [order total] field to {string}")
    public void setOrderTotalFieldTo(String total) {
        String locator = orderPrice.substring(1);
        locator = locator.substring(0, locator.length() - 3);
        locator = locator.replace(",", "");
        System.out.println(locator);
        //input[@title='"+locator +".0000 ']
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ap.orderTotalInput);
//        WebElement el = driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[2]/div[1]/div[6]/div[8]/div[2]/span[1]/span[1]/input[1]"));
//        ap.orderTotalInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE) + total);
//        el.clear();
        WebElement el = driver.findElement(By.xpath("//input[@title='" + locator + ".0000 ']"));
        el.click();
        driver.findElement(By.cssSelector("#trEditOrderTotals > div:nth-child(8) > div.col-md-9 > span > span > input.k-formatted-value.k-input")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE) + total);
        driver.findElement(By.cssSelector("#trEditOrderTotals > div:nth-child(8) > div.col-md-9 > span > span > input.k-formatted-value.k-input")).clear();
        System.out.println("5");
    }

    @And("Click [save order total] button")
    public void clickSaveOrderTotalButton() {
        ap.saveOrderTotals.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]//div[2]//div[1]")));
    }

    @Then("Verify order total is {string}")
    public void verifyOrderTotalIs(String expected) {
        String actual = driver.findElement(By.xpath("//div[5]//div[2]//div[1]")).getText();
        System.out.println("after" + actual);
        System.out.println(expected);
    }


    @And("Accept delete confirmation")
    public void acceptDeleteConfirmation() {
        driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
    }
}