package driverFactory;

import browserActions.BrowserActions;
import elementActions.ElementActions;
import listeners.webdriver.WebDriverListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class Driver {

    //    private static WebDriver driver;

    private ThreadLocal<WebDriver> driver;


    //    public Driver(String driverType) {
    // دة بدون مااحط ال listener WebDriver class
    //        driver = getDriver(driverType).startDriver();
// بدون listener حطيتة فى new instance
//        WebDriver undecoratedDriver = getDriver(driverType).startDriver();
    // علشان ال driver يبقى decorated شايف  WebDriverListener اللى انا عملتة
//    driver = new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
//                new WebDriverListener(undecoratedDriver)).decorate(undecoratedDriver);
//
//        assert driver != null;
//
//    }
    public Driver(String driverType) {
        WebDriver undecoratedDriver = getDriver(driverType).startDriver();
        assert undecoratedDriver != null;

        driver = new ThreadLocal<>();
        driver.set(new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
                new WebDriverListener(undecoratedDriver)).decorate(undecoratedDriver));

        assert driver != null;

    }

    private DriverAbstract getDriver(String driver) {

        switch (driver) {
            case "CHROME": {
                return new ChromeDriverFactory();
            }
            case "FIREFOX": {
                return new FireFoxDriverFactory();
            }
            case "EDGE": {
                return new EdgeDriverFactory();

            }
            default: {
                throw new IllegalStateException("Unexpected value: " + driver);
            }
        }
    }

    public WebDriver get() {
        return driver.get();
    }

    public void quit() {
        driver.get().quit();
    }

    public ElementActions element() {
        return new ElementActions(driver.get());
    }

    public BrowserActions browser() {
        return new BrowserActions(driver.get());
    }

}