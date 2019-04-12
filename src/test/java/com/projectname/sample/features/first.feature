Feature: Login feature validation

Scenario: valid login functionality validation

Given Launch application
When enter username and password
When click on login button
Then home page should be displayed
