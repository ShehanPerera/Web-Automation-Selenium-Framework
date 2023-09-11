package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utillities.ActionCommands;

public class LandingPage extends ActionCommands {

    WebDriver driver;
    private By searchDropdownBox = By.id("searchDropdownBox");
    private By optionBooks = By.cssSelector("#searchDropdownBox > option:nth-child(6)");
    private By searchTextBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String URL) {
        openurl(driver, URL);
    }

    public void clickSearchDropdown() {
        mouseClickAndHold(driver, searchDropdownBox);
    }

    public void selectBooks() {
        click(driver, optionBooks);
    }

    public void typeKeyword(String keyword) {
        type(driver, searchTextBox, keyword);
    }

    public void clickSearchButton() {
        click(driver, searchButton);
    }

    public void assertAll(){
        softAssertion();
    }

}
