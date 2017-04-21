Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter the following details for login
      | username | password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the userform page

  Scenario: Login with correct username and password for error
    Given I navigate to the login page
    And I enter the following details for login
      | username | password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the userform page for error

  Scenario Outline: Login with correct username and password using scenario outline
    Given I navigate to the login page
    And I enter the <username> and <password> for login
    And I click login button
    Then I should see the userform page

    Examples:
      | username | password      |
      | admin    | adminpassword |
      | admin    | admin         |