#Include in this file the scearios to cover profile right
#TODO: include more scenarios to cover this feature

@Authorization
Feature: Test the functionality of profile authorization rights

Scenario: Admin user shall be able to access other users data 
Given I am logged as admin
When I access my profile
Then I can see a table with users and their respective data

Scenario: Non admin user shall not be able to access other users data 
Given I am lloged as tester
When I access my profile
Then I cannot see a table with users and their respective data