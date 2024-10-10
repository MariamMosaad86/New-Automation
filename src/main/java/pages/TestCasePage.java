package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasePage {
    public Driver driver;

    By testCaseTitle = By.xpath("//h2[@class=\"title text-center\"]/b");

    public TestCasePage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    @Step("Check That Test Case Page Is Loaded Successfully")
    public void checkThatTestCasePageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/test_cases"));
        Assert.assertTrue(driver.element().isDisplayed(testCaseTitle));
        Assert.assertEquals(driver.element().getTextOf(testCaseTitle), "TEST CASES");
    }
}