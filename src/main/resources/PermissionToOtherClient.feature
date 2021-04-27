
Feature: Give permision to other client

	The system should allow a client to give another client permission to view
	their container data.

  Scenario: Giving permission
    Given A client is logged in
    And The client have a container with journey id "987654"
    And There is another client with the id "123456"
    When The client give "123456" permission to view a journey "987654"
    Then The system gives message "Permission given"
    And Client "123456" and view all data on journey "987654"
    
	Scenario: Already have permission
    Given A client is logged in
    And The client have a container with journey id "987654"
    And There is another client with the id "123456"
    When The client give "123456" permission to view a journey "987654"
    Then The system gives message "Permission have already been given"

  Scenario: Giving journey id
    Given A client is logged in
    And There is another client with the id "123456"
    When The client give "123456" permission to view a journey "wrong id"
    Then The system gives message "Permission not given, journey not found"
    And The client doesnt give permission
    
   Scenario: Wrong client id
    Given A client is logged in
    And The client have a container with journey id "987654"
    When The client give "wrong id" permission to view a journey "987654"
    Then The system gives message "Permission not given, client not found"
    And The client doesnt give permission