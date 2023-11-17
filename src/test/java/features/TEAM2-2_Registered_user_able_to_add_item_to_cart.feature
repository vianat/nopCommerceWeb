@web
Feature: TEAM2-2 Registered user able to add item to cart
          Registered user able to add item to shopping cart
          from any category (computers, electronics, apparel,
          digital downloads, books, jewelry, gift cards)

  @web1
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    When Click Login button
    And Enter email "team-sun@noreply.portnov.com"
    And Enter password "ow!<lSy~2H87"
    And Push Enter
    Given I navigate to "https://env-sun.portnov.com/cart"
    And remove all items from cart
    Given I navigate to "https://env-sun.portnov.com/"
    And Click on the Computers category
    And Click on the Notebooks category
    And Click on the product
    And Add product to cart
    And Click shopping cart
    Then Verify the product is added

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      | safari  |