@web
Feature: TEAM2-35 Store Manager can change order total price

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
    And Click first [view] button in table
    And wait 500
    And Click [edit Order Total] button
    And wait 1000

    And Set [order total] field to "778899"
    And wait 500
    And Click [save order total] button
    And wait 500
    And Accept total confirmation
    And wait 500
    Then Verify order total is "778899"

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
#      | safari  |