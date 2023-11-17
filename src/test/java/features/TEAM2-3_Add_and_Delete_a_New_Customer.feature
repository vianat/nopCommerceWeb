@web
Feature: TEAM2-3 Add and Delete a New Customer
          As a administrator I want to:
          add a new customer,
          and delete the customer from system.

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
    And Type email in [email] field
    And Click [save] button
    And Verify that the client has been created and exists in the client list
    And Click [edit] button for this customer
    And Click [delete] button
    And Accept alert
    Then Verify that the client has been deleted

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      | safari  |