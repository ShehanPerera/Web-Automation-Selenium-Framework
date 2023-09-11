package utillities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ActionCommands {


    protected void openurl(WebDriver driver, String URL) {
        driver.get(URL);
    }

    protected void click(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    protected void type(WebDriver driver, By locator, String input) {
        try {
            WebElement element = driver.findElement(locator);
            element.sendKeys(input);
        } catch (NoSuchElementException e) {
            System.out.println("No such a element " + e.getMessage());
            throw e;
        }
    }

    protected String getAttribute(WebDriver driver, By locator, String attribute) {
        WebElement element = driver.findElement(locator);
        String attributeValue = element.getAttribute(attribute);
        return attributeValue;
    }

    protected String getText(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        String attributeValue = element.getText();
        return attributeValue;
    }

    protected void assetString(String expected, String actual) {
        Assert.assertEquals(actual, expected);
    }

    protected void softAssetString(String actual, String expected) {
        SharedData.getInstance().getSoftAssert().assertEquals(actual,expected);
    }

    protected void assetInt(int expected, int actual) {
        Assert.assertEquals(actual, expected);
    }

    protected void waitToVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitToClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean checkVisibility(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();

    }

    protected void mouseClickAndHold(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Actions builder = new Actions(driver);
        builder.moveToElement(element).clickAndHold().perform();
    }

    protected void softAssertion(){
        SharedData.getInstance().getSoftAssert().assertAll();
    }


}
