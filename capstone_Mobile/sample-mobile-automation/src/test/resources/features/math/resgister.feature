Feature: Register
  As an user
  I want to create my account
  So that I can login to AA GYM

#  @Register @Positive
#  Scenario Outline: Register Scenario
#    Given I am on splash screen
#    And I click get started button
#    When I input the data for register "<username>" "<email>" "<phone_number>" "<password>" "<confirm_password>"
#    And I click sign up button
#    Then I validate result after register "<result>"
#    Examples:
#      |username|email                  |phone_number  |password|confirm_password|result|
#      |new     |new                    |081288441122  |Test123 |Test123         |success|
#
#  @RegisterNegative @Register
#  Scenario Outline: Register Scenario
#    Given I am on splash screen
#    And I click get started button
#    When I input the data for register "<username>" "<email>" "<phone_number>" "<password>" "<confirm_password>"
#    And I click sign up button
#    Then I validate result after register "<result>"
#    Examples:
#    |username|email                  |phone_number  |password|confirm_password|result|
#    |        |new                    |081288441122  |Test123 |Test123         |Please enter a username|
#    |vika1212|                       |081288441122  |Test123 |Test123         |Please enter your email address|
#    |new     |new                    |              |Test123 |Test123         |Please enter your phone number|
#    |new     |new                    |081288441122  |        |Test123         |Please enter your password|
#    |new     |new                    |081288441122  |Test123 |                |Please enter your password|
#    |new     |jasrivika              |081288441122  |Test123 |Test123         |Please enter a valid email address|
#    |vika1212|new                    |08128844      |Test123 |Test123         |Please enter a valid phone number |
#    |vika1212|new                    |08128844475896|Test123 |Test123         |Please enter a valid phone number |
#    |vika1212|new                    |081288441122  |Test123 |Doremi123       |Please enter a same password      |
#    |vika1212|new                    |081288441122  |Tes11   |Tes11           |The minimal length of password is 6|
#    |vika1212|new                    |081288441122  |tes123  |tes123          |Please enter at least one capital letter in your password|
#    |vika123 |new                    |081288441122  |TestPass|TestPass        |Please enter at least one number in your password         |
#    |vika1425|jasrivika1307@gmail.com|081254789635  |Test123 |Test123         |Email address is already used by other user         |
#    |aveeka  |new                    |081254789635  |Test123 |Test123         |Username already used by other user|
#
#  @Register @Positive
#  Scenario Outline: Register with remember me
#    Given I am on splash screen
#    And I click get started button
#    When I input the data for register "<username>" "<email>" "<phone_number>" "<password>" "<confirm_password>"
#    And I click remember me button
#    And I click sign up button
#    Then I validate result after register "<result>"
#    Examples:
#    |username|email|phone_number|password|confirm_password|result |
#    |new     |new  |081288441122|Test123 |Test123         |success|
#
#  @ExitRegister @Register
#  Scenario Outline: Exit register page with inputted data
#    Given I am on splash screen
#    And I click get started button
#    When I input the data for register "<username>" "<email>" "<phone_number>" "<password>" "<confirm_password>"
#    And I click login button on register
#    Then I click yes or no "<yesOrNo>"
#    And I validate the result after yes or no "<yesOrNo>"
#      Examples:
#      |username|email|phone_number|password|confirm_password|yesOrNo|
#      |vika1212|new  |08128844    |Test123 |Test123         |Yes    |
#      |vika1212|new  |08128844    |Test123 |Test123         |No     |