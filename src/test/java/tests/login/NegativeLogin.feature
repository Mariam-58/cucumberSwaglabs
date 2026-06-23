Feature: negative login

  Scenario Outline: Login with invalid credentials
    Given site is opened
    When enter "<user>" and "<pass>"
    And click on login button
    Then error message is appeared
    Examples:
      |user|pass|
      |invalidusername|invalidpassword|