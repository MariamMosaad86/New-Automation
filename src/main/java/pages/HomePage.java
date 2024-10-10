package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage {

    private Driver driver;


    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");
    By testCaseLink = By.xpath("(//a[@href=\"/test_cases\"])[1]");
    By productsLink = By.xpath("//a[@href=\"/products\"]");
    By hoverOnFirstProductLink = By.xpath("(//div[@class=\"overlay-content\"])[1]");
    By clickOnFirstProductAddToCartButton = By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]");
    By viewCart = By.xpath("(//a[@href=\"/view_cart\"])[2]");
    By subscriptionTitle = By.xpath("//div[@class=\"single-widget\"]/h2");
    By emailField = By.id("susbscribe_email");
    By submitEmailButton = By.id("subscribe");
    By SuccessMessage = By.id("success-subscribe");
    By footer = By.id("footer");
    By cartLink = By.xpath("(//a[@href=\"/view_cart\"])[1]");

    public HomePage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    @Step("Check That LogOut Link Should Be Displayed")
    public HomePage checkThatLogOutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(logoutLink));
        return this;
    }

    @Step("Check That Delete Link Should Be Displayed")
    public HomePage checkThatDeleteLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountLink));
        return this;
    }

    @Step("check That Login Link Should Be Displayed")
    public HomePage checkThatLoginLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(loginLink));
        return this;
    }

    @Step("Check That Home Page Is Loaded Successfully")
    public HomePage checkThatHomePageIsLoadedSuccessfully() {
        Assert.assertEquals(driver.browser().getCurrentURL(), "https://automationexercise.com/");
        return this;
    }

    @Step("Check That Subscription Is Visible")
    public HomePage checkThatSubscriptionIsVisible() {
        driver.element().scrollToElement(footer);
        Assert.assertTrue(driver.element().isDisplayed(subscriptionTitle));
        return this;
    }

    @Step("Check That Success Message Displayed Successfully")
    public HomePage checkThatSuccessMessageDisplayedSuccessfully() {
        Assert.assertEquals(driver.element().getTextOf(SuccessMessage), "You have been successfully subscribed!");
        return this;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check That User Can Click On Login Link")
    public LoginSignupPage clickOnLoginLink() {
        driver.element().click(loginLink);
        return new LoginSignupPage(driver);
    }

    @Step("Check That User Can Click On LogOut Link")
    public LoginSignupPage clickOnLogOutLink() {
        driver.element().click(logoutLink);
        return new LoginSignupPage(driver);
    }

    @Step("Check That User Can Click On Delete Account Link")
    public AccountSuccessfulDeletion clickOnDeleteAccountLink() {
        driver.element().click(deleteAccountLink);
        return new AccountSuccessfulDeletion(driver);
    }

    @Step("Check That User Can Click On ContactUs Link")
    public ContactUsPage clickOnContactUsLink() {
        driver.element().click(contactUsLink);
        return new ContactUsPage(driver);
    }

    @Step("Check That User Can Click On TestCase Link")
    public TestCasePage clickOnTestCaseLink() {
        driver.element().click(testCaseLink);
        return new TestCasePage(driver);
    }

    @Step("Check That User Can Click On Products Link")
    public ProductsPage clickOnProductsLink() {
        driver.element().click(productsLink);
        return new ProductsPage(driver);
    }

    @Step("Check That User Can hover On First Product")
    public HomePage hoverOnFirstProduct() {
        driver.element().hoverOnItem(hoverOnFirstProductLink);
        return this;
    }

    @Step("Check That User Can Click On First Add To Cart Button")
    public HomePage clickOnFirstAddToCartButton() {
        driver.element().click(clickOnFirstProductAddToCartButton);
        return this;
    }

    @Step("Check That User Can Click On View Cart Button")
    public ViewCartPage clickOnViewCartButton() {
        driver.element().click(viewCart);
        return new ViewCartPage(driver);
    }

    @Step("Check That User Can fill Email Field")
    public HomePage fillEmailField(String email) {
        driver.element().fillField(emailField, email);
        return this;
    }

    @Step("Check That User Can Click On Arrow Button")
    public HomePage clickOnArrowButton() {
        driver.element().click(submitEmailButton);
        return this;
    }

    @Step("Check That User Can Click On Cart Link")
    public ViewCartPage clickOnCartLink() {
        driver.element().click(cartLink);
        return new ViewCartPage(driver);
    }
}
