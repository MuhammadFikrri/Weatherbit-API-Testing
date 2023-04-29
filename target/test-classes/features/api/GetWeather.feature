@GetWeathers
Feature: Get Current Weather

  @Test
  Scenario: Verify Current Weather API with Valid Longitude and Latitude
    Given User already have valid API key
    When User sent GET request
    Then Should return status code 200
    And It should parse the response body
    And Get the value of the state_code
    And Response body state code should be "NY"