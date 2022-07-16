Feature: Login
  As an user
  I want to login
  So that I can make booking for a gym class

#  @Login
#  Scenario Outline: Login Scenario
#    Given I am on splash screen
#    And I click get started button
#    And I click login button on register
#    When I input the data for login "<email>" "<password>"
#    And I click login button on login
#    Then I validate the result after login "<result>"
#    Examples:
#    |email|password|result|
#    |jasrivika1307@gmail.com|Test123|success|
#    |jasrivika            |Test123|Please enter a valid email address|
#    |jasrivika99@gmail.com|Test123|failed|
#    |jasrivika1307@gmail.com|Abc123 |failed|
#    |jasrivika99@gmail.com|Abc123 |failed|
#    |                     |Test123|Please enter your email address|
#    |jasrivika1307@gmail.com|       |Please enter your password|
#    |                     |       |two|
#
#  @Login
#  Scenario Outline: Login with Remember Me
#    Given I am on splash screen
#    And I click get started button
#    And I click login button on register
#    When I input the data for login "<email>" "<password>"
#    And I click remember me button
#    And I click login button on login
#    Then I validate the result after login "<result>"
#    Examples:
#    |email|password|result|
#    |jasrivika1307@gmail.com|Test123|success|

#  @Logout
#  Scenario Outline: Logout
#    Given I am on splash screen
#    And I click get started button
#    And I click login button on register
#    When I input the data for login "<email>" "<password>"
#    And I click login button on login
#    And I click profile button
#    And I click logout button
#    And I click yes or no "<yesOrNo>"
#    And I validate the result after yes or no "<yesOrNo>"
#    Examples:
#    |email|password|yesOrNo|
#    |jasrivika1307@gmail.com|Test123|Yes|
#    |jasrivika1307@gmail.com|Test123|Cancel|