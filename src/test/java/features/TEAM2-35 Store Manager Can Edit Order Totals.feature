@web
Feature: TEAM2-67 TEAM2-34 Store Manager can change order status.feature

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

    And Click [edit Order Total] button
    And wait 2000

    And Set [order total] field to "778899"
    And wait 2000
    And Click [save order total] button
    And wait 2000
    And Accept total confirmation
    And wait 4000

    Then Verify order total is "778899"

    Examples:
      | browser |
#      | firefox |
      | chrome  |
#      | edge    |
      #| safari  |