@ChangeProfilePic
Feature: Change profile Module API Automation

  Scenario: Verify change profile pic to the application through api
    Given User add headers and bearer authorizaton for accessing change profile pic endpoints
    When User add multipart form data for change profile pic
    When User send "POST" request for change profile pic
    Then User should verify the status code is 200
    And User should verify the change profile pic response message matches "Profile updated Successfully"