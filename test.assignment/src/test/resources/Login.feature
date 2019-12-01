@Login
Feature: Test the login functionality on Waesworks webpage

#This scenario is validating whether positive and negative scenarios
#Testing valid credentials, wrong credentials and empty mandatory fields
  Scenario Outline: User shall be able to login if password corresponds to the username
    Given user is on the login page
    When user enters username <username>
    And user enters password <password>
    And user clicks login button
    Then user should see a message <message>

    Examples: 
      | username | password | message                                                |
      | admin    | hero     | Logged in                                              |
      | dev      | wizard   | Logged in                                              |
      | tester   | maniac   | Logged in                                              |
      | admin    | wrong    | Wrong credentials                                      |
      | dev      |          | To get the full hero experience, you’ll need to log in |
      |          | maniac   | To get the full hero experience, you’ll need to log in |
