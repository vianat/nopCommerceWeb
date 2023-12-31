@web
Feature: TEAM2-67 Verify Email Field Validation at Admin side
              This test examines the email used
              as a guardrail for registering new customer.

  @web
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    When Click Login button
    And Enter email "team-sun@noreply.portnov.com"
    And Enter password "ow!<lSy~2H87"
    And Push Enter
    Then Make sure you see Log out button and text: "Welcome to our store"
    And I navigate to "https://env-sun.portnov.com/Admin"

    And Expand customers panel
    And Click on customers in panel
    And Click Add new button

    And Type ".rararar@gmail.com" in [email] field
    And Push Enter
    Then Error message in top section "Valid Email is required for customer to be in 'Registered' role" is appear

    And Clean email field
    And Click [save] button
    Then Error message "'Email' must not be empty." is appear

    And Clean email field
    And Type "portnov" in [email] field
    And Push Enter
    Then Error message "Please enter a valid email address." is appear

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      | safari  |