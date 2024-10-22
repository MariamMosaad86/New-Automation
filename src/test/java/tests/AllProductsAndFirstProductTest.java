package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;


public class AllProductsAndFirstProductTest {

    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.browser().navigateToURL("https://automationexercise.com/");
        driver.browser().maximizeWindows();

    }

    @Test
    public void checkThatUserCanNavigateToFirstProductPageSuccessfully() {
        new HomePage(driver)
                .clickOnProductsLink()
                .checkThatProductsPageIsLoadedSuccessfully()
                .clickOnFirstProduct()
                .checkThatUserNavigateToFirstProductPageSuccessfully();
    }


    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }

}
