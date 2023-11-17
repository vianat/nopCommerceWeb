@web
Feature: TEAM2-35 Store Manager can change order total price

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
    And Click [edit Order Total] button

    And Set [order total] field to "778899"
    And Click [save order total] button
    And Accept total confirmation
    Then Verify order total is "778899"

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      | safari  |