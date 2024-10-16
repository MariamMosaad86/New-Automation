package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ViewCartPage {

    Driver driver;

    By productsTable = By.xpath("//div[@id=\"cart_info\"]");
    By firstProductName = By.xpath("//a[@href=\"/product_details/1\"]");
    By firstProductPrice = By.xpath("(//td[@class=\"cart_price\"]/p)[1]");
    By firstProductQuantity = By.xpath("(//td[@class=\"cart_quantity\"]/button)[1]");
    By firstProductTotalPrice = By.xpath("(//P[@class=\"cart_total_price\"])[1]");
    By secondProductName = By.xpath("//a[@href=\"/product_details/2\"]");
    By secondProductPrice = By.xpath("(//td[@class=\"cart_price\"]/p)[2]");
    By secondProductQuantity = By.xpath("(//td[@class=\"cart_quantity\"]/button)[2]");
    By secondProductTotalPrice = By.xpath("(//P[@class=\"cart_total_price\"])[2]");
    By subscriptionTitle = By.xpath("//div[@class=\"single-widget\"]/h2");
    By footer = By.id("footer");
    By emailField = By.id("susbscribe_email");
    By submitEmailButton = By.id("subscribe");
    By SuccessMessage = By.id("success-subscribe");


    public ViewCartPage(Driver driver) {
        this.driver = driver;
    }

    /**********************************  Assertions  ****************************************/

    @Step("Check That View Cart Page Is Loaded Successfully")
    public ViewCartPage checkThatViewCartPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/view_cart"));
        Assert.assertTrue(driver.element().isDisplayed(productsTable));
        return this;
    }

    @Step("Check That First And Second Products Are Added To The Cart Successfully")
    public ViewCartPage checkThatFirstAndSecondProductsAreAddedToTheCartSuccessfully() {
        Assert.assertTrue(driver.element().isDisplayed(firstProductName));
        Assert.assertTrue(driver.element().isDisplayed(secondProductName));
        Assert.assertEquals(driver.element().getTextOf(firstProductName), "Blue Top");
        Assert.assertEquals(driver.element().getTextOf(secondProductName), "Men Tshirt");
        Assert.assertTrue(driver.element().isDisplayed(firstProductPrice));
        Assert.assertTrue(driver.element().isDisplayed(firstProductQuantity));
        Assert.assertTrue(driver.element().isDisplayed(firstProductTotalPrice));
        Assert.assertTrue(driver.element().isDisplayed(secondProductPrice));
        Assert.assertTrue(driver.element().isDisplayed(secondProductQuantity));
        Assert.assertTrue(driver.element().isDisplayed(secondProductTotalPrice));
        return this;
    }


    @Step("Check Subscription Is Visible In Cart Page")
    public ViewCartPage checkSubscriptionIsVisibleInCartPage() {
        driver.element().scrollToElement(footer);
        Assert.assertTrue(driver.element().isDisplayed(subscriptionTitle));
        Assert.assertEquals(driver.element().getTextOf(subscriptionTitle), "SUBSCRIPTION");
        return this;
    }


    @Step("Check That Success Message Is Successfully Displayed")
    public ViewCartPage checkThatSuccessMessageIsSuccessfullyDisplayed() {
        Assert.assertEquals(driver.element().getTextOf(SuccessMessage), "You have been successfully subscribed!");
        return this;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check That User Can Fill Email Field")
    public ViewCartPage fillEmailField(String email) {
        driver.element().fillField(emailField, email);
        return this;
    }

    @Step("Check That User Can Click On Email Arrow Button")
    public ViewCartPage clickOnEmailArrowButton() {
        driver.element().click(submitEmailButton);
        return this;
    }
}