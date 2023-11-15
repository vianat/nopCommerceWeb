@web
Feature: TEAM2-34 Store Manager can change order status

  @web
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    And wait 200
    When Click Login button
    And Enter email "team-sun@noreply.portnov.com"
    And Enter password "ow!<lSy~2H87"
    And Push Enter
    And wait 200
    Then Make sure you see Log out button and text: "Welcome to our store"
    And I navigate to "https://env-sun.portnov.com/Admin"
    And wait 200
    And Click on sales in panel
    And wait 200
    And Click on orders in panel
    And wait 300

    And Click first view button in table
    And wait 200
    And Click [cancel order] button
    And wait 200
    And Accept cancel confirmation
    And wait 200
    Then Verify order status is "Cancelled"

    And Click [delete order] button
    And wait 200
    And Accept delete confirmation

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      #| safari  |