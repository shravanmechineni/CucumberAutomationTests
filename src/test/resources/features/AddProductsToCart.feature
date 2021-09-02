@addproductstocart
Feature: As a user, I would like to add expensive dress to the cart, So that it stays in the cart after log out and log back in later

  Scenario: verify adding product to the cart
    Given I am on automation site
    Given I logged into the automation site
    And I add most expensive dress to the cart
    And I logged out successfully
    When I logged in again
#    Then I should see that dress is still in the cart


