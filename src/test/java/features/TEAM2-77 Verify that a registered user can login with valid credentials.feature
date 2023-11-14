@web
Feature: TEAM2-77 Verify that a registered user can login with valid credentials

  @web
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    When Click Login button
    And Enter email "team-sun@noreply.portnov.com"
    And Enter password "ow!<lSy~2H87"
    And Push Enter
    Then Make sure you see Log out button and text: "Welcome to our store"

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
#      | safari  |