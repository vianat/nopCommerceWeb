@web
Feature: TEAM2-74 Verify that registration fails if the user provides invalid email address

  @web
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    And wait 200

    And Click [Register] button
    And wait 100
    Then Verify you on register page and see "Register"

    And Select female gender
    And Enter valid first name in [first name] field
    And Enter valid last name in [last name] field

    And Enter invalid email "janedoe@yahoo." in [email] field
    And Push Enter
    And wait 100
    Then Verify you see message "Wrong email" bellow email field

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      #| safari  |