package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utillities.ActionCommands;
import utillities.SharedData;

import java.text.DecimalFormat;

public class CartPage extends ActionCommands {

    WebDriver driver;
    private By cartName = By.cssSelector(".a-truncate-cut");
    private By cartQuantity = By.cssSelector(".a-dropdown-prompt");
    private By deleteButton = By.cssSelector("span.a-size-small:nth-child(3) > span:nth-child(1) > input:nth-child(1)");
    private By cartTotal = By.cssSelector("#sc-subtotal-amount-activecart > span:nth-child(1)");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyCartName() {
        waitToVisible(driver, cartName);
        String actual = getText(driver, cartName);
        String expected = SharedData.getInstance().getItemName();
        softAssetString(actual,expected);
    }

    public void verifyCartQuantity() {
        int actualQuantity = Integer.parseInt(getText(driver, cartQuantity));
        int expectedQuantity = SharedData.getInstance().getQuantity();
        assetInt(expectedQuantity, actualQuantity);
    }

    public void verifyCartTotal(String expectedAmount) {
        String actualAmount = getText(driver, cartTotal);
        assetString(expectedAmount, actualAmount);
    }

    public void clickOnDelete() {
        waitToClickable(driver, deleteButton);
        while (checkVisibility(driver, deleteButton)) {
            click(driver, deleteButton);
        }
    }

    public String calculateExpectedTotal() {
        int quantity = SharedData.getInstance().getQuantity();
        String originalItemPrice = SharedData.getInstance().getItemPrice();
        String numericString = originalItemPrice.replaceAll("[^\\d.]", "");
        double doubleValue = Double.parseDouble(numericString);
        double expectedTotal = doubleValue * quantity;
        DecimalFormat currencyFormat = new DecimalFormat("$#.00");
        return currencyFormat.format(expectedTotal);

    }

}
