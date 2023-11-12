@web
Feature: web functionality

  @web
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    Then Make sure the page title is "Your store. Home page title"

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      | safari  |