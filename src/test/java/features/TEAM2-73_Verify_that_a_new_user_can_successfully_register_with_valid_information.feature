@web
Feature: TEAM2-73 Verify that a new user can successfully register with valid information

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

    And Enter valid email in [email] field
    And Enter valid password in [password] field
    And Enter valid password in [confirm password] field
    And Click [Register] button for register form

    And wait 200
    Then Verify you see message "Your registration has been successfully completed. You have just been sent an email containing activation instructions."

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      #| safari  |