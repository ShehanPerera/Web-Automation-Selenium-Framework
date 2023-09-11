package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.DetailPage;
import utillities.BaseClass;

public class DetailPageSteps {

    DetailPage detailPage = new DetailPage(BaseClass.steupBrowser());

    @And("^Get the Unit price of the item displayed in the Product Detail page$")
    public void getUnitPrice() {
        detailPage.getUnitPrice();
    }

    @And("^Verify whether the item name of the Product Detail page and the item name obtained from the Product List page is same$")
    public void verifyName() {
        detailPage.verifyName();
    }

    @And("^Set the Quantity as (.*)$")
    public void setQuantity(int quantity) {
        detailPage.selectQuantity(quantity);
    }

    @Then("^Click on Add to Cart$")
    public void clickAddToCart() {
        detailPage.clickOnAddToCart();
    }

    @Then("^Click on Go to Cart$")
    public void goToCart() {
        detailPage.clickOnGoToCart();
    }

}
