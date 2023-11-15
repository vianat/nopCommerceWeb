@web
Feature: TEAM2-2 Registered user able to add item to cart
          Registered user able to add item to shopping cart
          from any category (computers, electronics, apparel,
          digital downloads, books, jewelry, gift cards)

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

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      #| safari  |