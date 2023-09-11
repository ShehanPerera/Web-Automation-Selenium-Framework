package utillities;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver = null;

    protected static ConfigDataProvider config;

    public static WebDriver steupBrowser() {
        if (driver == null) {
            config = new ConfigDataProvider();
            driver = BrowserFactory.startApplication(driver, config.getBrowser(),config.getHeaded());
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(1000000, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void tearDown() {
        BrowserFactory.quitBrowser(driver);
        driver = null;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
