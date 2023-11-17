@web
Feature: TEAM2-34 Store Manager can change order status

  @web
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    When Click Login button
    And Enter email "team-sun@noreply.portnov.com"
    And Enter password "ow!<lSy~2H87"
    And Push Enter
    Then Make sure you see Log out button and text: "Welcome to our store"
    And I navigate to "https://env-sun.portnov.com/Admin"

    And Click on sales in panel
    And Click on orders in panel

    And Click first [view] button in table
    And Click [cancel order] button
    And Accept cancel confirmation
    Then Verify order status is "Cancelled"

    And Click [delete order] button
    And Accept delete confirmation

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      | safari  |