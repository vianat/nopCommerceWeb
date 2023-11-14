@web
Feature: TEAM2-3 Add and Delete a New Customer
  As a administrator I want to:
    add a new customer,
    and delete the customer from system.

  @web
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    And wait 100
    When Click Login button
    And Enter email "team-sun@noreply.portnov.com"
    And Enter password "ow!<lSy~2H87"
    And Push Enter
    Then Make sure you see Log out button and text: "Welcome to our store"
    And I navigate to "https://env-sun.portnov.com/Admin"
    And wait 100
    And Expand customers panel
    And Click on customers in panel
    And wait 100
    And Click Add new button
    And wait 100
    And Type email in [email] field
    And Click [save] button
    And Verify that the client has been created and exists in the client list
    And Click [edit] button for this customer
    And wait 500
    And Click [delete] button
    And Accept alert
    And wait 100
    Then Verify that the client has been deleted

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      #| safari  |