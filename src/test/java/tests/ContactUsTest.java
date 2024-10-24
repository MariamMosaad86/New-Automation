package tests;

import driverFactory.Driver;
import org.testng.annotations.*;
import pages.HomePage;
import utilities.ScreenShotManager;

import java.time.Duration;

public class ContactUsTest {
    //    public Driver driver;
    public ThreadLocal<Driver> driver;

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void SetUp(@Optional("CHROME") String browserName) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
//        driver = new Driver(browserName);
        driver.get().get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

//        driver.element().hoverOnItem(By.xpath("(//div[@class=\"overlay-content\"])[1]"))
//                .click(By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]"));
    }

    @Test(priority = 1)
    public void contactUsTest() {
        new HomePage(driver.get())
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnContactUsLink()
                .checkThatContactUsPageIsLoadedSuccessfully()
                .fillInContactUsFrom("Mariam", "TestTest122@gmail.com", "Test", "Welcome")
                .clickOnSubmitButton()
                .checkThatFormShouldBeSubmittedSuccessfully()
                .clickOnHomeButton()
                .checkThatHomePageIsLoadedSuccessfully();
        ScreenShotManager.CaptureScreenShot(driver.get().get(), "ContactUs");


    }


    @AfterClass
    public void tearDown() {
        driver.get().browser().deleteAllCookies();
        driver.get().quit();
    }
}
