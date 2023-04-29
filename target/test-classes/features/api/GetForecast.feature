@GetForecasts
Feature: Get Hourly Forecast

  @Test
  Scenario: Verify Hourly Forecast API with Valid Postal Code and Hours
    Given User already have valid API key
    When User sent GET hourly forecast request
    Then Should return status code 200
    And It should parse the response body of forecast request
    And Get the value of the timestamp_utc, weather for all the data entries