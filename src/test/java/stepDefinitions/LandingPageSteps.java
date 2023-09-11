package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utillities.BaseClass;
import utillities.ConfigDataProvider;

public class LandingPageSteps {

    LandingPage landingPage = new LandingPage(BaseClass.steupBrowser());
    ConfigDataProvider configDataProvider = new ConfigDataProvider();

    @Given("^Navigate to official Amazon site$")
    public void loadUI() {

        landingPage.openPage(configDataProvider.getURL());
    }

    @When("^Select the Category as (.*)$")
    public void typeUsername(String category) {
        landingPage.clickSearchDropdown();
        if (category.equals("Books")) {
            landingPage.selectBooks();
        }
    }

    @When("^Search for the search term as (.*)$")
    public void typeSearchWord(String keyword) {

        landingPage.typeKeyword(keyword);
    }

    @And("^Click search button$")
    public void clickOnSearch() {
        landingPage.clickSearchButton();
    }

    @And("^Close browser$")
    public void closeBrowser() {
        BaseClass.tearDown();
        landingPage.assertAll();

    }

}
