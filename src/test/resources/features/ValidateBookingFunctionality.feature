@booking_hotel
Feature: Validate functionality of booking hotel
  This feature is to verify complete flow of hotel booking functionality

  Scenario: User will be able to login into booking app
    Given User launches the booking application
    When User verifies browser title for booking home page is displayed

  Scenario: User will be able to search for hotel
    Given User selects destination as "London"
    When User selects check in date as current date plus 20 days
    And User selects check out date as current date plus 21 days
    Then User clicks on Search button   

  Scenario: User will be able to complete user selections page
    Given User clicks on see availability button of the first hotel in searched list
    When User navigates to hotel details page
    Then User clicks on the reserve button

  Scenario: User will be able to reserve and complete user details page
    Given User selects amount as "1"
    When User clicks on I'll reserve button
    Then User enters first name as "Automation"
    Then User enters last name as "Test User1"
    Then User enters email id as "lathasuganya67@gmail.com"
    Then User clicks on final details

  Scenario: User will be able to complete hotel booking
    Given User enters mobile number as "7438528388"
    And User enters card number
    And User enters expiration date
    And User enters CVC
    And User clicks on complete booking