@booking_hotel_api
Feature: Validate api functionality of booking hotel
  This feature is to verify complete flow of hotel booking functionality of api

  Scenario: User will be able to book the hotel
    Given User hits booking request api with test data
    Then User verifies that response status code is 200
    And User verifies that response json data as expected results