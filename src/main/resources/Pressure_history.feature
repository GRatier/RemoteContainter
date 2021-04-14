@tag
Feature: View pressure history of container

  @tag1
  Scenario: Find pressure history based on container number 
    Given a client
    And a container with container number 123
    And a has travelled status true
    And journey history is visible
    When client clicks on pressure history of container number 123
    Then all past pressure levels of container are displayed

  Scenario: No container with that number
    Given a client
    When client searches for journey history of container number 666
    Then system displays message that no container with number 666 exists

  Scenario: Container has not been on any journeys
    Given a client
    And a container with container number 123
    And a has travelled status false
    When client searches for journey history of container number 123
    Then system displays message that container with number 123 has not been on any journey
