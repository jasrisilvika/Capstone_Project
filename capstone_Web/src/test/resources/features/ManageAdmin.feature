Feature: Manage Admin
  As a super admin
  I want to manage data admin
  So that I can do some CRUD in manage admin menu

  Scenario Outline: View detail admin
    Given I am on manage admin menu
    When I click view button <row>
    Then The view admin popup will show
    Examples:
    |row|
    |1  |
    |2  |
    |3  |
    |4  |


    Scenario Outline: Using cancel button on pop up
    Given I am on manage admin menu
    When I click button <row> "<button>"
    Then The popup will show "<button>"
    And I click cancel button "<button>"
    Examples:
    |row|button|
    |1  |view  |
    |2  |edit  |
    |3  |delete|
    |4  |view  |



  Scenario: Using cancel button on create new admin
    Given I am on manage admin menu
    And I click new button
    When I click cancel button
    Then The view admin popup will disappear


  Scenario Outline: Create new Admin
    Given I am on manage admin menu
    And I click new button
    When I input the data "<name>" "<username>" "<password>" "<email>" "<phone_number>" "<feature>"
    And I click save button "<feature>"
    Then I validate the result after create new admin "<result>"
    Examples:
    |name|username|password  |email        |phone_number|feature|result |
    |new |new     |Doremi123 |new          |084596871236|add    |success|

    @CreateAdminNegative
  Scenario Outline: Create new Admin - negative
    Given I am on manage admin menu
    And I click new button
    When I input the data "<name>" "<username>" "<password>" "<email>" "<phone_number>" "<feature>"
    And I click save button "<feature>"
    Then I validate the result after create new admin "<result>"
    Examples:
    |name|username|password |email|phone_number   |feature|result                        |
    |    |new     |Doremi123|new  |084596324785   |add    |Please enter your name        |
    |new |        |Doremi123|new  |084596324785   |add    |Please enter your username    |
    |new |new     |         |new  |084596324785   |add    |Password is required          |
    |new |new     |Doremi123|     |084596324785   |add    |Email is required             |
    |new |new     |Doremi123|new  |               |add    |Phone is required             |
    |new |new     |Doremi123|same |084596324785   |add    |same                          |
    |new |new     |Adm12    |new  |084596324785   |add    |falsePass                     |
    |new |new     |admin123 |new  |084596324785   |add    |falsePass                     |
    |new |new     |IniAdmin |new  |084596324785   |add    |falsePass                     |
    |new |new     |Doremi123|wrong|084596324785   |add    |The input is not valid E-mail!|
    |new |new     |Doremi123|new  |081425464      |add    |The input is not valid Phone! |
    |new |new     |Doremi123|new  |081458698542554|add    |The input is not valid Phone! |
    |new |new     |Doremi123|new  |08458965ABCDE  |add    |The input is not valid Phone! |



  Scenario Outline: Edit data Admin with all valid data
    Given I am on manage admin menu
    And I click edit button <row>
    When I input the data for edit "<name>" "<username>" "<password>" "<email>" "<phone_number>" "<feature>"
    And I click save button "<feature>"
    Then I validate the result after edit admin <row> "<name>"
    Examples:
    |name|username|password|email|phone_number|feature|row|
    |User|user01  |blabla |test@mail.com|02136545|edit|1  |

    @EditAdminNegative
  Scenario Outline: Edit data Admin with some data are not valid
    Given I am on manage admin menu
    And I click edit button <row>
    When I input the data for invalid "<name>" "<username>" "<password>" "<email>" "<phone_number>" "<feature>"
    And I click save button "<feature>"
    Then I validate the result after edit admin not valid "<result>"
    Examples:
      |name|username|password |email|phone_number   |feature|result                        |row|
#      |    |new     |Doremi123|new  |084596324785   |edit   |Please enter your name        |2  |
      |new |        |Doremi123|new  |084596324785   |edit   |Please enter a valid username |2  |
#      |new |new     |null     |new  |084596324785   |edit   |Please enter a valid password |2  |
#      |new |new     |Doremi123|     |084596324785   |edit   |Email is required             |2  |
#      |new |new     |Doremi123|new  |null           |edit   |Please enter a valid phone number|2  |
#      |new |new     |Doremi123|same |084596324785   |edit   |same                          |2  |
#      |new |new     |Adm12    |new  |084596324785   |edit   |falsePass                     |2  |
#      |new |new     |admin123 |new  |084596324785   |edit   |falsePass                     |2  |
#      |new |new     |IniAdmin |new  |084596324785   |edit   |falsePass                     |2  |
#      |new |new     |Doremi123|wrong|084596324785   |edit   |The input is not valid E-mail!|2  |
#      |new |new     |Doremi123|new  |081425464      |edit   |Wrong format!                 |2  |
#      |new |new     |Doremi123|new  |081458698542554|edit   |Wrong format!                 |2  |
#      |new |new     |Doremi123|new  |08458965ABCDE  |edit   |Wrong format!                 |2  |

  Scenario Outline: Delete data Admin
    Given I am on manage admin menu
    When I click delete button <row>
    And I validate the confirm delete show <row>
    And I click confirm delete button
    Then I validate the data was deleted successfully <row>
    Examples:
    |row|
    |1  |
    |2  |



