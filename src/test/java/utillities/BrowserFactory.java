package utillities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {


    public static WebDriver startApplication(WebDriver driver, String browserName, boolean headed) {
        if (browserName.equalsIgnoreCase("chrome")) {
            String projectLocation = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", projectLocation + "/drivers/chromedriver");
            ChromeOptions options = new ChromeOptions();
            if (!headed) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            String projectLocation = System.getProperty("user.dir");
            System.setProperty("webdriver.firefox.driver", projectLocation + "/drivers/geckodriver");
            FirefoxOptions options = new FirefoxOptions();
            if (!headed) {
                options.setHeadless(true);
            }
            driver = new FirefoxDriver(options);

        } else {
            System.out.println("Not support for " + browserName);
        }
        return driver;

    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }

}
