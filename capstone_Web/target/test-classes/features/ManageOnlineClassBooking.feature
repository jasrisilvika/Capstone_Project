Feature: Manage Offline Class Booking
  As an Admin
  I want to manage data offline class booking
  So that I can view and edit offline class booking

  Scenario Outline: View detail offline class booking
    Given I am on manage online class booking menu
    When I click button on offline booking <row> "<button>"
    Then I validate the popup offline booking show "<button>"
    Examples:
      |row|button|
      |  1|view  |
      |2  |view  |

  Scenario Outline: Using cancel button on pop up view and delete offline class booking
    Given I am on manage online class booking menu
    And I click button on offline booking <row> "<button>"
    Then I click cancel button on offline booking "<button>"
    Examples:
      |row|button|
      |1  |delete|
      |2  |view  |

  Scenario Outline: Delete data offline class booking
    Given I am on manage online class booking menu
    When I click button on offline booking <row> "<button>"
    And I validate the popup offline booking show "<button>"
    Then I click confirm delete on offline booking
    And I validate data was deleted <row>
    Examples:
      |row|button|
      |1  |delete|
