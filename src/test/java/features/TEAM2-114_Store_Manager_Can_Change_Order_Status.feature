@web
Feature: TEAM2-34 Store Manager can change order status.feature

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

    And Click [change order status] button
    And Set "Cancelled" status
    And Click [save] status button
    And Accept order confirmation
    Then Verify order status is "Cancelled"

    And Click [change order status] button
    And Set "Processing" status
    And Click [save] status button
    And Accept order confirmation
    Then Verify order status is "Processing"

    And Click [change order status] button
    And Set "Pending" status
    And Click [save] status button
    And Accept order confirmation
    Then Verify order status is "Pending"

    And Click [change order status] button
    And Set "Complete" status
    And Click [save] status button
    And Accept order confirmation
    Then Verify order status is "Complete"

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      | safari  |