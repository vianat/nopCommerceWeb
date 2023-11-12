@web
Feature: web functionality

  @web
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    When Click Login button
    And Enter email "team-sun@noreply.portnov.com"
    And Enter password "ow!<lSy~2H87"
    And Push Enter
    Then Make sure you see Log out button

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      #| safari  |