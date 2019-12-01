# Future Improvements

## 1- Support to Multiple Browsers
Currently the project only supports Chrome web browsers.
The purpose is to make it available for testing in different plataforms using the existent Selenium web drivers.
```
# Extend Testing for Browsers:
Internet Explorer
Safari
Edge
Firefox
Opera
```
## 2- Update Cucumber/Gherkin Solution
Update the project to use the latest version of cucumber-gherkin libaries as well as fix the integration of feature files with their respective step implementation.
Currently the tests can be executed macthing feature scenarios with their implementation but the feature file is not able to recognize its steps are already implemented.

## 3- Increase coverage

### 3.1 Implement Authorization Tests
- Increase the scenarios on Authorization.feature and implement their tests.
- Improve Profile class in order to be able to validate users authorization feature.

### 3.2 Implement Validation on Details Page
- Implement page class for Details page under user profile in order to be able to test it properly.
- Add scenarios to cover if sign up data entered matches the data on user details page

## 4- Jenkins Integration
Make this project available to be triggered and handled by an automation server
