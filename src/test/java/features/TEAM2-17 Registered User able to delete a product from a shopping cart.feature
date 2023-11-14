@web
Feature: TEAM2-17 Registered User able to delete a product from a shopping cart

  @web
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    When Click Login button
    And Enter email "team-sun@noreply.portnov.com"
    And Enter password "ow!<lSy~2H87"
    And Push Enter
    And wait 200
    Given I navigate to "https://env-sun.portnov.com/cart"
    And remove all items from cart
    Given I navigate to "https://env-sun.portnov.com/"
    And wait 200
    And Click on the Computers category
    And wait 100
    And Click on the Notebooks category
    And wait 100
    And Click on the product
    And wait 100
    And Add product to cart
    And wait 200
    And Click shopping cart
    And wait 200
    Then Verify the product is added
    And remove all items from cart
    Then Check if the message "Your Shopping Cart is empty!" appeared

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      #| safari  |