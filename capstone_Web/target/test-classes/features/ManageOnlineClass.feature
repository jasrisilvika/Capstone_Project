Feature: Manage Online Class
  As an Admin
  I want to manage data online classes
  So that I can do some CRUD in manage online class menu

  Scenario Outline: View detail online classes
    Given I am on manage online class menu
    When I click button on online class <row> "<crud_button>"
    Then I validate the popup view online class will show
    Examples:
    |row|crud_button|
    |1  |view       |
    |2  |view       |

  Scenario Outline: Using cancel button on view online classes
    Given I am on manage online class menu
    And I click button on online class <row> "<crud_button>"
    When I click cancel button on view online class
    Then I validate the result after using cancel button on view online classes
    Examples:
      |row|crud_button|
      |1  |view       |
      |2  |view       |

  Scenario Outline: Add data online class
    Given I am on manage online class menu
    And I click button add on online class "<crud_button>"
    When I input the data for add new online class "<name_class>" "<trainer>" "<date>" <time> "<location>" <price> "<desc>" "<result>" "<crud_button>"
    And I click save button on online class "<crud_button>"
    Then I validate the result after create new online class "<result>"
    Examples:
    |crud_button|name_class|trainer|date|time|location|price|desc|result|
    |add        |Zumba     |Levina |12/01/2022|1900|Room 2|65000|this is a zumba class|success|


  Scenario Outline: Edit data online class
    Given I am on manage online class menu
    And I click button on online class <row> "<crud_button>"
    When I input the data for edit online class "<name_class>" "<trainer>" "<date>" <time> "<location>" <price> "<desc>" "<result>" "<crud_button>"
    And I click save button on online class "<crud_button>"
    Then I validate the result after edit online class "<result>" <row> "<name_class>"
    Examples:
    |row|crud_button|name_class|trainer|date|time|location|price|desc|result|
    |1  |edit       |Pilates   |Adam   |12/01/2022|1600|Room 5|63000|this is a pilates class|success|

  Scenario Outline: Delete data online class
    Given I am on manage online class menu
    When I click button on online class <row> "<crud_button>"
    And I validate the confirm delete online class show
    And I click confirm delete on online class
    Then I validate the online class successfully deleted <row>
    Examples:
    |row|crud_button|
    |1  |delete     |

  Scenario Outline: Using cancel button on edit delete pop up
    Given I am on manage online class menu
    And I click button on online class <row> "<crud_button>"
    And I validate the popup online class show "<crud_button>"
    When I click cancel button online class "<crud_button>"
    Then I validate the result after cancel online button
    Examples:
    |row|crud_button|
    |1  |edit       |
    |2  |delete     |

  Scenario Outline: Using cancel button on add online class
    Given I am on manage online class menu
    And I click button add on online class "<crud_button>"
    When I click cancel button online class "<crud_button>"
    Then I validate the result after cancel online button
    Examples:
      |crud_button|
      |add        |