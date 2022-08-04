@Login
Feature: Login Module API Automation

  Scenario: Get user logtoken from login endpoint
    Given User add header
    And User add basic authentication for login
    When User send "POST" request for login endpoint
    Then User should verify the status code is 200
    And User should verify the login responsebody firstname present as "Natarajan" and get the logtoken