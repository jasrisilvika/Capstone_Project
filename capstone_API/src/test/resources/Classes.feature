Feature: Class
  As an admin
  I want to get all classes
  So that I can see all classes

  Scenario Outline: GET - As an Admin I have to be able to get all classes
    Given I set an endpoint for GET all classes
    When I request GET all classes
    Then I validate the status code is <status_code>
    And I validate the result after GET all classes
    And I get an id for other request "<req>"
    Examples:
    |status_code| req  |
    |200        |delete|
    |200        |update|

  Scenario Outline: GET- As an Admin I have to be able to get a class by id
    Given I set an endpoint for GET class by id
    When I request GET class by id "<result>"
    Then I validate the status code is <status_code>
    And I validate the result after GET class by id "<result>"
    Examples:
    |status_code|result|
    |400        |failed|
    |200        |success|

  @CreateClass @Positive
  Scenario Outline: POST - Create a class by category
    Given I set an endpoint for POST create class "<category>"
    When I request POST create class "<category>" "<name>" <instructor> "<desc>" <price> "<location>" "<result>"
    Then I validate the status code is <status_code>
    And I validate the result after POST create class "<result>" "<name>" <instructor> "<desc>" <price> "<location>" "<category>"
    Examples:
    |category|status_code|name   |instructor|desc                             |price|location |result |
    |online  |201        |pilates|4         |this is a pilates class at AA gym|50000|From Home|success|
    |offline |201        |boxing |4         |this is a boxing class at AA gym |90000|Room 2   |success|

  @CreateClass @Negative
  Scenario Outline: POST - Create a class by category negative
    Given I set an endpoint for POST create class "<category>"
    When I request POST create class "<category>" "<name>" <instructor> "<desc>" <price> "<location>" "<result>"
    Then I validate the status code is <status_code>
    And I validate the result after POST create class "<result>" "<name>" <instructor> "<desc>" <price> "<location>" "<category>"
    Examples:
    |category|status_code|name   |instructor|desc                             |price|location |result|
    |online  |500        |pilates|50        |this is a pilates class at AA gym|50000|From Home|err   |
    |offline |500        |boxing |50        |this is a boxing class at AA gym |90000|Room 2   |err   |
    |online  |500        |pilates|4         |this is a pilates class at AA gym|50000|From Home|nullStartAt|
    |offline |500        |boxing |4         |this is a boxing class at AA gym |90000|Room 2   |nullStartAt|
    |online  |400        |null   |4         |this is a pilates class at AA gym|50000|From Home|failed     |
    |online  |500        |zumba  |4         |this is a zumba class at AA gym  |0    |From Home|err        |
    |offline |500        |null   |4         |this is a pilates class at AA gym|80000|Room 2   |err        |
    |online  |500        |zumba  |4         |this is a zumba class at AA gym  |0    |From Home|err        |


  Scenario Outline: POST - Create a class by category with null id instructor
    Given I set an endpoint for POST create class "<category>"
    When I request POST create class "<category>" "<name>" "<desc>" <price> "<location>"
    Then I validate the status code is <status_code>
    And I validate the result after POST create class "<result>"
    Examples:
    |category|status_code|name|desc|price|location|result|
    |online  |500        |pilates|this is a pilates class at AA gym|50000|From Home|nullIdInst|
    |offline |500        |boxing |this is a boxing class at AA gym|90000|Room 2|nullIdInst|

  Scenario Outline: DELETE - delete a class by id
    Given I set an endpoint for DELETE a class
    When I request DELETE a class "<result>"
    Then I validate the status code is <status_code>
    And I validate the result after DELETE a class "<result>"
    Examples:
   |status_code|result|
   |200        |success|
   |204        |failed |

  Scenario Outline: PUT - update class
    Given I set an endpoint for PUT update class "<result>"
    When I request PUT update class "<name>" <instructor> <price> "<type>" "<startAt>" "<result>"
    Then I validate the status code is <status_code>
    And I validate the result after update class "<result>"
    Examples:
    |status_code|result |name          |instructor|price |type  |startAt|
    |201        |success|Weight Lifting|4         |200000|online|new    |
    |500        |invalid|Weight Lifting|4         |200000|online|new    |
    |400        |failed |null          |4         |200000|online|new    |
    |400        |failed |Weight Lifting|4         |0     |online|new    |
    |500        |invalid|Weight Lifting|4         |200000|noType|new    |
    |400        |failed |Weight Lifting|4         |200000|online|null   |