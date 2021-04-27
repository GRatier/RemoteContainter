
Feature: Removing another clients acces to your data
  Lets a client remove another clients permission to view it's data

  Scenario: Acces removed
    Given A client is logged in
    And The client have a container with journey id "987654"
    And There is another client with the id "123456"
    When The client removes the permission of "123456" to view a journey "987654"
    Then The system gives message "Acces removed"
    And Client "123456" and cant view journey "987654"

  Scenario: Journey not found
    Given A client is logged in
    And There is another client with the id "123456"
    When The client removes the permission of "123456" to view a journey "wrong id"
    Then The system gives message "Acces not removed, journey not found"
    
   Scenario: Client not found
    Given A client is logged in
    And There is another journey with the id "987654"
    When The client removes the permission of "wrong id" to view a journey "987654"
    Then The system gives message "Acces not removed, client not found"
    