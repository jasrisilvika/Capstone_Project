Feature: Login
  As an Admin
  I want to login
  So that I can manage all menu

  Scenario Outline: Login into website admin
    Given I am on login page
    When I input the data for login "<username>" "<password>"
    And I click login button
#    Then I validate the result after login "<result>"
    Examples:
    |username|password|
    |abcde   |abcde   |
