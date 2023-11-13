@web
Feature: Add to cart functionality

  @web
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    When Click Login button
    And Enter email "team-sun@noreply.portnov.com"
    And Enter password "ow!<lSy~2H87"
    And Push Enter
    And Scroll down to element and click
    And Click add to cart button
    And Click shopping cart
    Then Verify the product is added

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      #| safari  |