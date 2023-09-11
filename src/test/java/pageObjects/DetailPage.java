package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utillities.ActionCommands;
import utillities.SharedData;

public class DetailPage extends ActionCommands {

    WebDriver driver;
    private By detailName = By.id("productTitle");
    private By detailQuantityIcon = By.id("a-autoid-0-announce");
    private By quantity2 = By.id("quantity_1");
    private By addToCartButton = By.id("add-to-cart-button");
    private By goToCartButton = By.cssSelector("#sw-gtc > span:nth-child(1) > a:nth-child(1)");

    public DetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getUnitPrice() {
        WebElement price = findDynamicElement(driver);
        String updatePrice = price.getText().replace("\n", ".");
        SharedData.getInstance().setItemPrice(updatePrice);
    }

    public void verifyName() {
        String actual = getText(driver, detailName);
        String expected = SharedData.getInstance().getItemName();
        assetString(expected, actual);
    }

    public void selectQuantity(int quantity) {
        SharedData.getInstance().setQuantity(quantity);
        click(driver, detailQuantityIcon);
        if (quantity == 2) {
            click(driver, quantity2);
        }

    }

    public WebElement findDynamicElement(WebDriver driver) {
        try {
            return driver.findElement(By.id("price"));
        } catch (NoSuchElementException e) {

            return driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[1]/div[4]/div[5]/div/div[1]/div/div/div/form/div/div/div/div/div[3]/div/div[2]/div[1]/div[1]/span[2]"));
        }
    }

    public void clickOnAddToCart() {
        click(driver, addToCartButton);
    }

    public void clickOnGoToCart() {
        click(driver, goToCartButton);
    }
}
