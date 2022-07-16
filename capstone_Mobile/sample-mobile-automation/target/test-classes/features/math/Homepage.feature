Feature: HomePage
  As an user
  I want to see all classes
  So that I can booking a class


  @SeeAll @HomePage
  Scenario Outline: See all class
    Given I am on splash screen
    And I click get started button
    And I click login button on register
    And I input the data for login "user@mail.com" "Doremi123"
    And I click login button on login
    When I click see all class "<category>"
    Then All classes will show "<category>"
    Examples:
    |category|
    |Online  |
    |Offline |

  @ViewDetail @HomePage
  Scenario Outline: View detail class
    Given I am on splash screen
    And I click get started button
    And I click login button on register
    And I input the data for login "user@mail.com" "Doremi123"
    And I click login button on login
    When I click see all class "<category>"
    And I choose a class "<classes>" "<category>"
    Then I validate result after view detail "<classes>"
    Examples:
    |category|classes       |
    |Online  |Weight Lifting|
    |Online  |Body Building |
    |Online  |Yoga          |
    |Online  |Weight Loss   |
    |Online  |Zumba         |
    |Online  |Cardio        |
    |Offline |Cardio        |
    |Offline |Zumba         |
    |Offline |Yoga          |
    |Offline |Weight Loss   |
    |Offline |Weight Lifting|
    |Offline |Body Building |


  @BookingClass @HomePage
  Scenario Outline: Booking Class
    Given I am on splash screen
    And I click get started button
    And I click login button on register
    And I input the data for login "user@mail.com" "Doremi123"
    And I click login button on login
    And I click see all class "<category>"
    And I choose a class "<classes>" "<category>"
    And I validate result after view detail "<classes>"
    And I click see all available class "<category>" "<classes>"
    When I click book now button
    And I click payment instruction button "user@mail.com"
    Then I validate the result after booking class
    Examples:
    |category|classes       |
    |Online  |Weight Lifting|
    |Offline |Cardio        |

  @Tips @HomePage
    Scenario Outline: Tips For You
      Given I am on splash screen
      And I click get started button
      And I click login button on register
      And I input the data for login "user@mail.com" "Doremi123"
      And I click login button on login
      When I click the tips "<tips>"
      Then I validate the result after click tips
      Examples:
      |tips|
      |1   |
      |2   |

    @Payment @HomePage
    Scenario: Make a Payment
      Given I am on splash screen
      And I click get started button
      And I click login button on register
      And I input the data for login "user@mail.com" "Doremi123"
      And I click login button on login
      When I click schedule menu
      And I click pay now button
      Then I validate the result after pay the booking


