Feature: Manage Membership
  As an Admin
  I want to manage data membership
  So that I can view delete accept and decline membership

  Scenario Outline: View detail membership
    Given I am on manage membership menu
    When I click button on membership menu <row> "<vd_button>"
    Then I validate the popup membership show "<vd_button>"
    Examples:
    |row|vd_button|
    |  1|view     |
    |2  |view     |

  Scenario Outline: Using cancel button on pop up view and delete membership
    Given I am on manage membership menu
    And I click button on membership menu <row> "<vd_button>"
    Then I click cancel button on membership "<vd_button>"
    Examples:
    |row|vd_button|
    |1  |delete|
    |2  |view  |

  Scenario Outline: Delete data membership
    Given I am on manage membership menu
    When I click button on membership menu <row> "<vd_button>"
    And I validate the popup membership show "<button>"
    Then I click confirm delete on membership
    And I validate data membership was deleted <row>
    Examples:
    |row|vd_button|
    |1  |delete|