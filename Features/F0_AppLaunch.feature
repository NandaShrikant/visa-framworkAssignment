Feature: Launch Application
Description: This feature will test application startup

@StartUp
Scenario: app start up
When a user launches the application
Then the homepage is displayed
And the main menu is available
