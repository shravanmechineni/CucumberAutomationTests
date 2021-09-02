package com.cucumberautomation.stepdefs;

import com.cucumberautomation.pageobjects.CartPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddProductsToCartStepDefs {
    CartPageObjects addToCartPageObjects = new CartPageObjects();

    @Given("I add most expensive dress to the cart")
    public void i_add_most_expensive_dress_to_the_cart() {
        addToCartPageObjects.addExpensiveDressToTheCart();
    }

    @Then("I should see that dress is still in the cart")
    public void i_should_see_that_dress_is_still_in_the_cart() {
        addToCartPageObjects.verifyCart();
    }

}
