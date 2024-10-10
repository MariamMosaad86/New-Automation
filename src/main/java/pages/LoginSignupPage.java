package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginSignupPage {

    private Driver driver;
    WebDriverWait wait;

    By loginEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    By loginPassword = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

    By signUpName = By.xpath("//input[@type=\"text\"]");
    By signUpEmail = By.xpath("(//input[@type=\"email\"])[2]");
    By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    By signUpFormTitle = By.xpath("//div[@class=\"signup-form\"]/h2");


    public LoginSignupPage(Driver driver) {
//        wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        this.driver = driver;
    }


    /*********************************  Assertions  *****************************************************/

    @Step("Check That User Is Navigated To Login SignUp Page")
    public LoginSignupPage checkThatUserIsNavigatedToLoginSignUpPage() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/login"));
        Assert.assertEquals(driver.element().getTextOf(signUpFormTitle), "New User Signup!");
        return this;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check That User Can Fill In Login Email")
    public LoginSignupPage fillInLoginEmail(String email) {
        driver.element().fillField(loginEmail, email);
        return this;
    }

    @Step("Check That User Can Fill In Login Password")
    public LoginSignupPage fillInLoginPassword(String password) {
        driver.element().fillField(loginPassword, password);
        return this;
    }

    @Step("Check That User Can Click On Login Button")
    public HomePage clickOnLoginButton() {
        driver.element().click(loginButton);
        return new HomePage(driver);
    }

    @Step("Check That User Can Fill In Name SingUp")
    public LoginSignupPage fillInNameSingUp(String name) {
        driver.element().fillField(signUpName, name);
        return this;
    }

    @Step("Check That User Can Fill In Email SingUp Page")
    public LoginSignupPage fillInEmailSingUpPage(String email) {
        driver.element().fillField(signUpEmail, email);
        return this;
    }

    @Step("Check That User Can click On SignUp Button")
    public RegistrationPage clickOnSignUpButton() {
        driver.element().click(signUpButton);
        return new RegistrationPage(driver);
    }
}