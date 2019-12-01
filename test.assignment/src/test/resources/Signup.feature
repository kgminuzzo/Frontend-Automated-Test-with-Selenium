@Signup
Feature: Test the sign up functionality on Waesworks webpage

  #Positive scenario: create user
  Scenario: User shall be able to sign up if required data is correctly informed
    Given user is on the signup page
    When user enters the data
      | username | password | name | email          | date of birth  |
      | user1    |     1234 | John | john@email.com | 1-January-1987 |
    And user clicks submit button
    Then user should see a welcome message Welcome to your new profile page

  #Negative scenario: user already exists
  Scenario: User shall not be able to sign up if username already exists
    Given user is on the signup page
    When user enters the data
      | username | password | name  | email           | date of birth |
      | admin    |     1234 | admin | admin@email.com | 26-May-2002   |
    And user clicks submit button
    Then user should see a warning message This hero is already registered. Try another one!

  #Negative scenario: email is already in use
  Scenario: User shall not be able to sign up if email is already registered
    Given user is on the signup page
    When user enters the data
      | username | password | name  | email                 | date of birth    |
      | user2    |     1234 | admin | a.admin@wearewaes.com | 28-December-1920 |
    And user clicks submit button
    Then user should see a warning message This hero is already registered. Try another one!

  #Negative scenario: try to register without informing required fields
  Scenario Outline: User shall inform all required fields to create a profile
    Given user is on the signup page
    When user enters the data <username>,<password>,<name>,<email> and <date_of_birth>
    And user clicks submit button
    Then user should see a hint informing that the field <field> should be populated

    Examples: 
      | username | password | name | email          | date_of_birth  | field    |
      |          |     1234 | John | john@email.com | 1-January-1987 | username |
      | usern    |          | John | john@email.com | 1-January-1987 | password |
      | usern    |     1234 |      | john@email.com | 1-January-1987 | name     |
      | usern    |     1234 | John |                | 1-January-1987 | email    |

  #Negative scenario: date of birth validation
  Scenario Outline: User shall inform a valid date to sign up
    Given user is on the signup page
    When user enters the data mary,pass123,Mary Smith,mary@email.com and <date_of_birth>
    And user clicks submit button
    Then user should not see a welcome message Welcome to your new profile page

    Examples: 
      | date_of_birth    |
      | 30-February-1990 |
      | 31-June-2000     |
      | 31-December-2019 |

  #Negative scenario: invalid email format
  Scenario Outline: User shall inform a valid email to sign up
    Given user is on the signup page
    When user enters the data ggm1,pass123,Gladis,<email> and 6-March-1964
    And user clicks submit button
    Then user should not see a welcome message Welcome to your new profile page

    Examples: 
      | email          |
      | ggm1@email     |
      | ggm1.email.com |
      | @ggm1email.com |
      | ggm1@email.    |
