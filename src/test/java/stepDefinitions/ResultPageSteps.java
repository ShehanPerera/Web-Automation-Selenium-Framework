package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.ResultPage;
import utillities.BaseClass;

public class ResultPageSteps {

    ResultPage resultPage = new ResultPage(BaseClass.steupBrowser());

    @Then("^Select Customer Reviews as (.*)$")
    public void selectReviews(String reviews) {
        resultPage.clickReviews(reviews);
    }

    @Then("^Select Language as (.*)$")
    public void selectLanguage(String language) {
        resultPage.clickLanguage(language);
    }

    @Then("^Get the name of the (\\w+) item from the Product List page$$")
    public void getItem(String order) {
        resultPage.getItemName(order);
    }

    @Then("^Click the name of the (\\w+) item from the Product List page$$")
    public void clickItem(String order) {
        resultPage.clickItem(order);

    }

}
