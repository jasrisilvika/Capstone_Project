Feature: User
  As an admin
  I want to get all data users
  So that I can see all the users such a superadmin, admin, and user

  Scenario Outline: GET - As an admin I have to be able to get data users by category
    Given I set an endpoint for GET all users "<category>"
    When I request GET all users "<category>"
    Then I validate the status code is <status_code>
    And I validate the result after GET users "<category>"
    And I get an user id for update user "<category>"
    Examples:
    |category|status_code|
    |superadmin|200      |
    |admin     |200      |
    |user      |200      |

  Scenario Outline: GET - As an Admin I have to be able to get all users
    Given I set an endpoint for GET all users "<category>"
    When I request GET all users "<category>"
    Then I validate the status code is <status_code>
    And I validate the result after GET users "<category>"
    And I get an id for update password
    Examples:
    |category|status_code|
    |users   |200        |

  Scenario Outline: GET - As an Admin I have to be able to get an user by id
    Given I set an endpoint for GET user by id <id>
    When I request GET user by id <id>
    Then I validate the status code is <status_code>
    And I validate the result after GET user by id "<result>" <id>
    Examples:
    |id|status_code|result|
    |15|200        |success|
    |74|400        |failed |


  @CreatePositive
  Scenario Outline: POST - As an Admin I have to be able to create new superadmin, admin, and user
    Given I set an endpoint for POST create users "<category>"
    When I request POST create users "<category>" "<name>" "<address>" "<username>" "<email>" "<contact>" "<password>"
    Then I validate the status code is <status_code>
    And I validate the result after POST create users "<category>" "<result>" "<contact>"
    And I get an user id for other request "<category>"
    Examples:
    |category  |status_code|result|name|address|username|email|contact     |password  |
    |superadmin|201        |success|new|Jakarta|new     |new  |081211229988|Doremi@123|
    |admin     |201        |success|new|Bandung|new     |new  |081241526987|Doremi@123|
    |user      |201        |success|new|Bali   |new     |new  |101147859632|Doremi@123|

  @CreateNegative
  Scenario Outline: POST - As an Admin I have not to be able to create new superadmin, admin, and user
    Given I set an endpoint for POST create users "<category>"
    When I request POST create users "<category>" "<name>" "<address>" "<username>" "<email>" "<contact>" "<password>"
    Then I validate the status code is <status_code>
    And I validate the result after POST create users "<category>" "<result>" "<contact>"
    Examples:
    |category  |status_code|result |name|address      |username|email|contact     |password  |
    |superadmin|500        |failed |    |Jakarta Barat|new     |new  |081211229988|Doremi@123|
    |admin     |500        |failed |    |Jakarta Barat|new     |new  |081211229988|Doremi@123|
    |user      |500        |failed |    |Jakarta Barat|new     |new  |081211229988|Doremi@123|
    |superadmin|500        |failed |new |Jakarta Barat|        |new  |081211229988|Doremi@123|
    |admin     |500        |failed |new |Jakarta Barat|        |new  |081211229988|Doremi@123|
    |user      |500        |failed |new |Jakarta Barat|        |new  |081211229988|Doremi@123|
    |superadmin|500        |failed |new |Jakarta Barat|new     |     |081211229988|Doremi@123|
    |admin     |500        |failed |new |Jakarta Barat|new     |     |081211229988|Doremi@123|
    |user      |500        |failed |new |Jakarta Barat|new     |     |081211229988|Doremi@123|
    |superadmin|500        |failed |new |Jakarta Barat|new     |new  |0           |Doremi@123|
    |admin     |500        |failed |new |Jakarta Barat|new     |new  |0           |Doremi@123|
    |user      |500        |failed |new |Jakarta Barat|new     |new  |0           |Doremi@123|
    |superadmin|400        |failed2|new |Jakarta Barat|new     |new  |081211229988|          |
    |admin     |400        |failed2|new |Jakarta Barat|new     |new  |081211229988|          |
    |user      |400        |failed2|new |Jakarta Barat|new     |new  |081211229988|          |
    |superadmin|500        |failed |new |Jakarta Barat|new     |same |081211229988|Doremi@123|
    |admin     |500        |failed |new |Jakarta Barat|new     |same |081211229988|Doremi@123|
    |user      |500        |failed |new |Jakarta Barat|new     |same |081211229988|Doremi@123|
#
  @UpdatePassword
  Scenario Outline: PUT - Update password user
    Given I set an endpoint for PUT update password user
    When I request PUT update password user "<password>" "<result>"
    Then I validate the status code is <status_code>
    And I validate the result after update password user "<result>" "<password>"
    Examples:
    |password  |status_code|result |
    |newPass123|200        |success|
    |null       |400        |null   |
    |passBaru569|500        |failed |

  Scenario Outline: PUT - Update user
    Given I set an endpoint for PUT update user "<result>"
    When I request PUT update user "<name>" "<username>" "<email>" "<contact>" "<result>"
    Then I validate the status code is <status_code>
    And I validate the result after PUT update user "<result>"
    Examples:
    |status_code|result |name|username|email|contact     |
    |200        |success|new |new     |new  |087458963214|
    |500        |failed |null|new     |new  |087458963214|
    |500        |failed |new |null    |new  |087458963214|
    |400        |err    |new |new     |null |087458963214|
    |500        |failed |new |new     |same |087458963214|
    |500        |failed |new |new     |new  |null        |
    |500        |invalid|new |new     |new  |087458963214|
