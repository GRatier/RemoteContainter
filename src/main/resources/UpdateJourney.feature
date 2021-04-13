Feature: Logistic company updates journey information

	Scenario: Update journey
		Given there is an existing journey and container
		And that the logistic company is logged in
		When the logistic company updates the journey location to "Oslo"
		Then the journey current position is updated with current location "Oslo"