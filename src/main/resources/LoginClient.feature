Feature: Client login
	
Scenario: Client can login
	Given there is a client registered in the system
	And a client is not logged in
	And the username is "client1"
	And the password is "clientclient"
	Then a client login succeeds
	And a client is logged in
	
Scenario: Client has the wrong password
	Given a client is not logged in
	And the username is "client1"
	And the password is "wrong password"
	Then a client login fails
	And a client is not logged in
	
Scenario: Client has the wrong username/is not registered
	Given a client is not logged in
	And the username is "wrongclient"
	And the password is "clientclient"
	Then a client login fails
	And a client is not logged in
