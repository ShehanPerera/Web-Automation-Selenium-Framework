package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utillities.ActionCommands;
import utillities.SharedData;

public class ResultPage extends ActionCommands {

    WebDriver driver;
    private By customerReviews4 = By.cssSelector(".a-star-medium-4");
    private By customerReviews3 = By.cssSelector(".a-star-medium-3");
    private By languageEnglish = By.cssSelector("#p_n_feature_nine_browse-bin\\/3291437011 > span > a > div > label > i");
    private By secondItemName = By.cssSelector(".widgetId\\=search-results_2 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1) > a:nth-child(1) > span:nth-child(1)");

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickReviews(String reviewType) {
        if (reviewType.equals("4 Stars & Up")) {
            click(driver, customerReviews4);
        } else if (reviewType.equals("3 Stars & Up")) {
            click(driver, customerReviews3);
        }
    }

    public void clickLanguage(String language) {
        if (language.equals("English")) {
            click(driver, languageEnglish);
        }
    }

    public void getItemName(String order) {
        if (order.toLowerCase().equals("second")) {
            SharedData.getInstance().setItemName(getText(driver, secondItemName));
        }

    }

    public void clickItem(String order) {
        if (order.toLowerCase().equals("second")) {
            click(driver, secondItemName);
        }
    }

}
