@web
Feature: TEAM2-67 Store Manager can change order status

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

    And Click [change order status] button
    And wait 100
    And Click [order status] button
    And Set "Pending" status
    And Click [save] status button
    And wait 200
    And Accept confirmation
    And wait 200
    Then Verify order status is "Pending"
    And wait 100

    And Click [change order status] button
    And wait 100
    And Click [order status] button
    And Set "Processing" status
    And Click [save] status button
    And wait 200
    And Accept confirmation
    And wait 200
    Then Verify order status is "Processing"
    And wait 100

    And Click [change order status] button
    And wait 100
    And Click [order status] button
    And Set "Complete" status
    And Click [save] status button
    And wait 200
    And Accept confirmation
    And wait 200
    Then Verify order status is "Complete"
    And wait 100

    And Click [change order status] button
    And wait 100
    And Click [order status] button
    And Set "Cancelled" status
    And Click [save] status button
    And wait 200
    And Accept confirmation
    And wait 200
    Then Verify order status is "Cancelled"
    And wait 100

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      #| safari  |