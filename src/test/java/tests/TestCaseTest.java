package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;


public class TestCaseTest {

    public Driver driver;


    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.browser().navigateToURL("https://automationexercise.com/");
        driver.browser().maximizeWindows();
    }

    @Test
    public void testCasePage() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnTestCaseLink()
                .checkThatTestCasePageIsLoadedSuccessfully();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }

}
