@tag
Feature: View journey history of container

  @tag1
  Scenario: Find journey history based on container number 
    Given a client
    And a container with container number 123
    And a has travelled status true
    When client searches for journey history of container number 123
    Then all past journeys container has been on appear

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