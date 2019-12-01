# WaesHeroes
Frontend Automated Testing

### Prerequisites

To run this project you will need Eclipse 2019-09 or any other version with Maven installed and Maven integration for Eclipse (M2Eclipse).
All other depencies will be handled by Maven.

## Technologies
Project is created with:
* Eclipse version: 2019-09 R (4.13.0)
* Maven version: 3.6.2
* Java version: 1.8
* JUnit version: 5
* maven-compiler-plugin library version: 3.8.1
* maven-surefire-plugin library version: 2.22.2
* maven-cucumber-reporting library version: 4.11.2
* cucumber-junit library version: 4.8.0
* cucumber-java library version: 4.8.0
* cucumber-core library version: 4.8.0
* junit-jupiter-api library version: 5.1.0
* selenium-java library version: 3.141.59
* selenium-chrome-driver library version: 3.141.59
* gherkin library version: 2.12.2

## Installing Dependencies

Depencies can be installed whether in IDE or by command line in case Maven is configured as a system variable

Installing through Eclipse
```
Right Click the project
Select Run As
Select Maven Install
```

Installing though command line
```
mvn clean install
```

## Running the tests

The test can be run thought Eclipse interface or from command line in case Maven is configured as a system variable

Run the tests through Eclipse
```
Right Click the project
Select Run As
Select Maven build
Enter Goal as "verify"
Click Run
```

Run the test though command line
```
mvn verify
```

### Feature tests

Currently the project supports the automted testing of two different features.
#### The first feature is the login and its tests assure:
- The user can loggin with the correct credentials 
- The user cannot loggin if any data informed is wrong or missing
#### The second feature is the sign up and its tests assure:
- The user can sign up if correct data is informed
- The user cannot sign up if any required data is missing
- The user cannot sign up if any data informed is incorrect

```
Example:
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
```
Ps: A complete list of scenarios can be found in the feature files under src/test/resources package.

## Reporting

A reporting with the results will be automatically generated once the tests are complete.
They are created using Maven Cucumber Reporting and are available at target\cucumber-html-reports folder.

## Built With

* [Eclipse](https://www.eclipse.org/) - IDE used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Selenium](https://selenium.dev/) - Framework for web application testing
* [Cucumber](https://cucumber.io/) - BDD Support


## Authors

* **Karina Gabin** 

