package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.CartPage;
import utillities.BaseClass;

public class CartPageSteps {

    CartPage cartPage = new CartPage(BaseClass.steupBrowser());

    @Then("^Verify whether the cart details are correct$")
    public void verifyCartDetails() {
        cartPage.verifyCartName();
        cartPage.verifyCartQuantity();
        String expectedAmount = cartPage.calculateExpectedTotal();
        cartPage.verifyCartTotal(expectedAmount);
    }

    @Then("Clear the cart$")
    public void clearCart() {
        cartPage.clickOnDelete();
    }

    @Then("Verify the total amount is equal to (.*)$")
    public void verifyClearCart(String amount) {
        cartPage.verifyCartTotal(amount);
    }


}
