Feature: Logistic company updates journey information

	Scenario: Update journey
		Given there is an existing journey and container
		And that the logistic company is logged in
		When the logistic company updates the journey location to "Oslo"
		And the logistic company updates the air humidity to "2"
		And the logistic company updates the atm pressure to "1"
		And the logistic company updates the internal temperature to "20"
		Then the journey current position is updated with current location "Oslo"
		And the journey current air humidity is updated with current air humidity "2"	
		And the journey current atm pressure is updated with current atm pressure "1"
		And the journey current internal temperature is updated with current internal temperature "20"
		
	Scenario: Update journey
		Given there is an existing journey and container
		And that the logistic company is logged in
		When the logistic company updates the air humidity to "2"
		And the logistic company updates the atm pressure to "1"
		And the logistic company updates the internal temperature to "20"
		Then the journey current air humidity is updated with current air humidity "2"	
		And the journey current atm pressure is updated with current atm pressure "1"
		And the journey current internal temperature is updated with current internal temperature "20"
			