Feature: Booking
  As an Admin
  I have to be able to create a booking
  So that I can accept the booking

#  Background: GET classId
  Scenario Outline: GET - As an Admin I have to be able to get all classes
    Given I set an endpoint for GET all classes
    When I request GET all classes
    Then I validate the status code is <status_code>
    And I validate the result after GET all classes
    And I get an id for other request post booking
    Examples:
    |status_code|
    |200        |

  Scenario Outline: POST - As an Admin I have to be able to create a booking
    Given I set an endpoint for POST create booking
    When I request POST create booking "<result>"
    Then I validate the status code is <status_code>
    And I validate the result after POST create booking "<result>"
    And I get a booking id for other request "<result>"
    Examples:
    |result|status_code|
    |integration|201       |
    |invalidCLassId|500    |
    |nullClassId   |500    |
    |invalidUserId |500    |
    |nullUserId    |500    |


  Scenario Outline: GET - As an Admin I have to be able to get all booking
    Given I set an endpoint for GET booking "<book>"
    When I request GET booking "<book>"
    Then I validate the status code is <status_code>
    And I validate the result after GET booking "<book>"
    Examples:
    |book|status_code|
    |all |200        |
    |before|200      |
    |after |200      |


  Scenario Outline: GET - As an Admin I have to be able to get booking by id
    Given I set an endpoint for GET booking by id
    When I request GET booking by id "<result>"
    Then I validate the status code is <status_code>
    And I validate the result after get booking by id "<result>"
    Examples:
    |status_code|result |
    |200        |success|
    |400        |failed |

Scenario Outline: PUT - As an Admin I have to be able to accept user's booking
  Given I set an endpoint for PUT accept class
  When I request PUT accept class "<result>"
  Then I validate the status code is <status_code>
  And I validate the "<result>" after PUT accept class
  Examples:
  |status_code|result|
  |200        |success|
  |500        |failed |

Scenario Outline: GET - As an Admin I have to able to get booking by user's id
  Given I set an endpoint for GET booking by user id
  When I request GET booking by user id "<result>"
  Then I validate the status code is <status_code>
  And I validate the result after GET booking by user id "<result>"
  Examples:
  |status_code|result|
  |200        |success|
  |200        |failed |