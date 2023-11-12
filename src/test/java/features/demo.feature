@cross
Feature: cross functionality

  @cross
  Scenario Outline: <browser>
    Given I navigate to "https://www.portnov.com/"
    Then Make sure the page title is "Home - Portnov Computer School"

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      | safari  |