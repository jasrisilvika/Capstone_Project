Feature: Profile Page

#  @ProfilePage
#    Scenario Outline: Functional of menu in profile page
#      Given I am on splash screen
#      And I click get started button
#      And I click login button on register
#      And I input the data for login "<email>" "<password>"
#      And I click login button on login
#      When I click profile button
#      And I click submenu on profile page "<btn>"
#      Then I validate the result after click submenu "<btn>" "<email>"
#      Examples:
#      |btn                |email                  |password|
#      |Personal Details   |jasrivika1307@gmail.com|Test123 |
#      |Payment Instruction|jasrivika1307@gmail.com|Test123 |
#      |Terms & Conditions |jasrivika1307@gmail.com|Test123 |
#      |FAQ                |jasrivika1307@gmail.com|Test123 |
#      |Send us Feedbacks  |jasrivika1307@gmail.com|Test123 |

#  @UpdatePassword @Positive
#  Scenario Outline: Update Password
#    Given I am on splash screen
#    And I click get started button
#    And I click login button on register
#    And I input the data for login "test@yahoo.com" "Doremi123"
#    And I click login button on login
#    When I click profile button
#    And I click submenu on profile page "Update Password"
#    Then I input data for update password "<current>" "<newPass>" "<confirm>" "Doremi123" "<result>"
#    And I validate the result after click submenu update password "<result>"
#    Examples:
#      |current         |newPass     |confirm         |result|
#      |true            |new         |new             |success|

#  @UpdatePassword @Negative
#    Scenario Outline: Update Password
#      Given I am on splash screen
#      And I click get started button
#      And I click login button on register
#      And I input the data for login "vika@yahoo.com" "Test123"
#      And I click login button on login
#      When I click profile button
#      And I click submenu on profile page "Update Password"
#      Then I input data for update password "<current>" "<newPass>" "<confirm>" "Test123" "<result>"
#      And I validate the result after click submenu update password "<result>"
#      Examples:
#      |current         |newPass     |confirm         |result|
#      |                |new         |new             |crntNull|
#      |true            |            |Doremi123       |Please enter your password|
#      |true            |Doremi123   |                |Please enter your password|
#      |true            |Do12        |Do12            |The minimal length of password is 6|
#      |true            |Doremi123   |Doremi546       |Please enter a same password       |
#      |false           |new         |new             |Please enter your current password |
#      |true            |doremi123   |doremi123       |Please enter at least one capital letter in your password|
#      |true            |Doremifasol |Doremifasol     |Please enter at least one number in your password        |



