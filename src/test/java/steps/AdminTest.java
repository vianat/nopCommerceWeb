package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdminHomePage;

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
    public void expandCustomersPanel() throws InterruptedException {
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(ap.expandCustomers));
        ap.expandCustomers.click();
    }

    @And("Click on customers in panel")
    public void clickOnCustomersInPanel() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(ap.customers));
        ap.customers.click();
    }

    @And("Click Add new button")
    public void clickAddNewButton() throws InterruptedException {
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(ap.addNew));
        ap.addNew.click();
    }

    @And("Type email in [email] field")
    public void typeEmailInEmailField() throws InterruptedException {
        Thread.sleep(500);
        int random = rand.nextInt(1000 - 1) + 1;
        email = "random" + random + "@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(email);
    }

    @And("Click [save] button")
    public void clickSaveButton() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@name='save']")).click();
    }

    @And("Verify that the client has been created and exists in the client list")
    public void verifyThatTheClientHasBeenCreatedAndExistsInTheClientList() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + email + "')]")));
        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'" + email + "')]"));
        assertEquals(el.getText(), email);
    }

    @And("Click [edit] button for this customer")
    public void click_edit_button_for_this_customer() throws InterruptedException {
        Thread.sleep(500);
        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'" + email + "')]//parent::tr//following::a"));
        el.click();
    }

    @And("Click [delete] button")
    public void click_delete_button() throws InterruptedException {
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-delete")));
        driver.findElement(By.id("customer-delete")).click();
    }

    @And("Accept alert")
    public void AcceptAlert() throws InterruptedException {
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Delete')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
    }

    @Then("Verify that the client has been deleted")
    public void verifyThatTheClientHasBeenDeleted() throws InterruptedException {
        Thread.sleep(500);
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
    public void otdohniBratok(int ms) throws InterruptedException {
        Thread.sleep(ms);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    protected void step(@NotNull Runnable runnable) throws InterruptedException {

        Thread.sleep(300);
        runnable.run();
    }

    @Then("Error message {string} is appear")
    public void errorMessageIsAppear(String expected) throws InterruptedException {
        Thread.sleep(500);
        String actual = driver.findElement(By.xpath("//span[@class='field-validation-error']")).getText();
        assertEquals(actual, expected);
    }

    @Then("Error message in top section {string} is appear")
    public void errorMessageInTopSectionIsAppear(String expected) throws InterruptedException {
        Thread.sleep(500);
        String actual = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li[1]")).getText();
        assertEquals(actual, expected);
    }

    @And("Clean email field")
    public void cleanEmailField() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.id("Email")).clear();
    }

    @And("Type {string} in [email] field")
    public void typeInEmailField(String email) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.id("Email")).sendKeys(email);
    }

    @And("Click on sales in panel")
    public void clickOnSalesInPanel() throws InterruptedException {
        Thread.sleep(500);
        ap.sales.click();
    }

    @And("Click on orders in panel")
    public void clickOnOrdersInPanel() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//li[@class='nav-item has-treeview menu-is-opening menu-open']//li[1]//a[1]")).click();
    }

    @And("Click first [view] button in table")
    public void clickFirstViewButtonInTable() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//tbody/tr[1]/td[9]/a[1]")).click();
        orderPrice = driver.findElement(By.xpath("//div[5]//div[2]//div[1]")).getText();
    }

    @And("Click [change order status] button")
    public void clickChangeOrderStatusButton() throws InterruptedException {
        Thread.sleep(500);
        ap.changeStatus.click();
    }

    @And("Set {string} status")
    public void setStatus(String status) throws InterruptedException {
        Thread.sleep(500);
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

    @And("Click [search] button")
    public void clickSearchButton() {
        ap.searchOrders.click();
    }

    @And("Click [delete order] button")
    public void clickDeleteOrderButton() throws InterruptedException {
        Thread.sleep(500);
        ap.orderDelete.click();
    }

    @And("Click [cancel order] button")
    public void clickCancelOrderButton() throws InterruptedException {
        Thread.sleep(500);
        ap.cancelOrder.click();
    }

    @And("Click [save] status button")
    public void clickSaveStatusButton() throws InterruptedException {
        Thread.sleep(500);
        ap.saveOrderStatus.click();
    }

    @And("Accept total confirmation")
    public void acceptTotalConfirmation() throws InterruptedException {
        Thread.sleep(500);
        ap.acceptTotalConfirmation.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]//div[2]//div[1]")));
    }

    @And("Accept order confirmation")
    public void acceptOrderConfirmation() throws InterruptedException {
        Thread.sleep(500);
        ap.acceptOrderConfirmation.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='font-weight-bold']")));
    }

    @And("Accept cancel confirmation")
    public void acceptCancelConfirmation() throws InterruptedException {
        Thread.sleep(500);
        ap.acceptCancelConfirmation.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='font-weight-bold']")));
    }

    @Then("Verify order status is {string}")
    public void verifyOrderStatusIs(String expected) throws InterruptedException {
        Thread.sleep(500);
        String actual = driver.findElement(By.xpath("//div[@class='font-weight-bold']")).getText();
        assertEquals(actual, expected);
    }

    @And("Click [edit Order Total] button")
    public void clickEditOrderTotalButton() throws InterruptedException {
        Thread.sleep(1000);
        ap.editOrderTotals.click();
    }

    @And("Set [order total] field to {string}")
    public void setOrderTotalFieldTo(String total) throws InterruptedException {
        Thread.sleep(1000);
        String locator = orderPrice.substring(1);
        locator = locator.substring(0, locator.length() - 3);
        locator = locator.replace(",", "");

        WebElement el = driver.findElement(By.xpath("//div[8]//div[2]//span[1]//span[1]//input[1]"));
        WebElement el2 = driver.findElement(By.xpath("//div[8]//div[2]//span[1]//span[1]//input[2]"));

//        if (el.isDisplayed() && el.isEnabled()) {
//            System.out.println("find");
//        }
        el.click();

        step( () -> {
            el2.clear();
            el.click();
        });

        Thread.sleep(500);
        el2.sendKeys(total);
    }

    @And("Click [save order total] button")
    public void clickSaveOrderTotalButton() throws InterruptedException {
        Thread.sleep(500);
        ap.saveOrderTotals.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]//div[2]//div[1]")));
    }

    @Then("Verify order total is {string}")
    public void verifyOrderTotalIs(String expected) throws InterruptedException {
        Thread.sleep(500);
        String actual = driver.findElement(By.xpath("//div[5]//div[2]//div[1]"))
                .getText()
                .replace(",", "")
                .substring(1);

        assertEquals(actual, expected+ ".00");
    }

    @And("Accept delete confirmation")
    public void acceptDeleteConfirmation() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
    }

    //    @And("Set [order statuses] {string}")
//    public void setOrderStatuses(String status) throws InterruptedException {
//        driver.findElement(By.xpath("//div[5]//div[2]//div[1]//div[1]")).click();
//        System.out.println("1");
//        Thread.sleep(500);
////        driver.findElement(By.xpath("//option[contains(text(),'" + status + "')]")).click();
//        driver.findElement(By.xpath("//div[5]//div[2]//div[1]//div[1]")).sendKeys(Keys.ARROW_DOWN);
//        driver.findElement(By.cssSelector("select[id='OrderStatusIds'] option[value='10']")).click();
//        System.out.println("2");
////        driver.findElement(By.xpath("//select[@id='OrderStatusIds']//option[@value='10'][normalize-space()='" + status + "']")).click();
//    }
}