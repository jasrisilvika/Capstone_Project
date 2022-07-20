Feature: Manage Offline Class
  As an Admin
  I want to manage data offline classes
  So that I can do some CRUD in manage offline class menu

  Scenario Outline: View detail offline classes
    Given I am on manage offline class menu
    When I click button on offline class <row> "<crud_button>"
    Then I validate the popup view offline class will show
    Examples:
    |row|crud_button|
    |1  |view       |
    |2  |view       |

  Scenario Outline: Using cancel button on view offline classes
    Given I am on manage offline class menu
    And I click button on offline class <row> "<crud_button>"
    When I click cancel button on view offline class
    Then I validate the result after using cancel button on view offline classes
    Examples:
      |row|crud_button|
      |1  |view       |
      |2  |view       |

  Scenario Outline: Add data offline class
    Given I am on manage offline class menu
    And I click button add on offline class "<crud_button>"
    When I input the data for add new offline class "<name_class>" "<trainer>" "<date>" <time> "<location>" <price> "<desc>" "<result>" "<crud_button>"
    And I click save button on offline class "<crud_button>"
    Then I validate the result after create new offline class "<result>"
    Examples:
    |crud_button|name_class|trainer|date|time|location|price|desc|result|
    |add        |Zumba     |Levina |12/01/2022|1900|Room 2|65000|this is a zumba class|success|


Scenario Outline: Edit data offline class
  Given I am on manage offline class menu
  And I click button on offline class <row> "<crud_button>"
  When I input the data for edit offline class "<name_class>" "<trainer>" "<date>" <time> "<location>" <price> "<desc>" "<result>" "<crud_button>"
  And I click save button on offline class "<crud_button>"
  Then I validate the result after edit offline class "<result>" <row> "<name_class>"
  Examples:
  |row|crud_button|name_class|trainer|date|time|location|price|desc|result|
  |1  |edit       |Pilates   |Adam   |12/01/2022|1600|Room 5|63000|this is a pilates class|success|


Scenario Outline: Delete data offline class
  Given I am on manage offline class menu
  When I click button on offline class <row> "<crud_button>"
  And I validate the confirm delete show
  And I click confirm delete on offline class
  Then I validate the offline class successfully deleted <row>
  Examples:
  |row|crud_button|
  |1  |delete     |


  Scenario Outline: Using cancel button on edit delete pop up
    Given I am on manage offline class menu
    And I click button on offline class <row> "<crud_button>"
    And I validate the popup offline class show "<crud_button>"
    When I click cancel button offline class "<crud_button>"
    Then I validate the result after cancel offline button
    Examples:
    |row|crud_button|
    |1  |edit       |
    |2  |delete     |

  Scenario Outline: Using cancel button on add offline class
    Given I am on manage offline class menu
    And I click button add on offline class "<crud_button>"
    When I click cancel button offline class "<crud_button>"
    Then I validate the result after cancel offline button
    Examples:
    |crud_button|
    |add        |