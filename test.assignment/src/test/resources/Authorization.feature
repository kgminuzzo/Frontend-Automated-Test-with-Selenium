@Authorization
Feature: Test the functionality of profile authorization rights

Scenario: Admin user shall be able to access other users data 
Given I am logged as admin
When I access my profile
Then I can see a table with users and their respective data

Scenario: Non admin user shall not be able to access other users data 
Given I am loged as tester
When I access my profile
Then I cannot see a table with users and their respective data
