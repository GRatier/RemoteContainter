package Steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
import domains.Address;
import domains.Client;
import domains.LogisticCom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainClasses.ClientInfo;
import mainClasses.JourneyInfo;
import mainClasses.OperationNotAllowedException;

public class ClientSteps {
	
	private LogisticCom logisticCompanyApp;
	private ClientInfo clientInfo;
	
	private String errorMessage;
	private Address address;
	public ClientHelper clientHelper;
	private JourneyHelper journeyHelper;
	private Client client;
	
	public ClientSteps(LogisticCom logisticCompanyApp, ClientHelper helper, JourneyHelper journeyHelper) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.clientHelper = helper;
		this.journeyHelper = journeyHelper;
	}
	
	@Given("there is a client with name {string}, email {string}, reference person {string}")

	 public void there_is_a_client_with_name_email_reference_person_password(String name, String email, String ref_person) {
		clientInfo = new ClientInfo(name, email, ref_person);
		
	    assertEquals(clientInfo.getName(),name);
	    assertEquals(clientInfo.getEmail(),email);
	    assertEquals(clientInfo.getReference_person(),ref_person);
	}
	
	@Given("there is a client registered in the system")
	public void there_is_a_client_registered_in_the_system() throws OperationNotAllowedException {
		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");

		clientInfo = clientHelper.getClient();
		try {
			clientHelper.registerExampleClient();
		} catch (Exception e) {
			this.errorMessage = e.getMessage();
		}
		logisticCompanyApp.logisticCompanyLogout();
	}
	
	@Given("the client address is {string}, {string}, {string}")
	public void the_client_address_is(String street, String postcode, String city) throws OperationNotAllowedException {
		this.address = new Address(street,postcode,city);
		this.clientInfo.setAddress(address);
		
		assertEquals(clientInfo.getAddress().getStreet(),street);
		assertEquals(clientInfo.getAddress().getPostCode(),postcode);
		assertEquals(clientInfo.getAddress().getCity(),city);	
		
		

	}

	
	@Given("the client has registered journeys")
	public void the_client_has_registered_journeys() throws OperationNotAllowedException {
		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		
		clientInfo = clientHelper.getClient();
		
		journeyHelper.registerMultipleJourneys();
		List<JourneyInfo> journeysList = journeyHelper.getMultipleJourneys();
		
		for (int i=0; i < 3; i++) {
			logisticCompanyApp.registerJourneyToClient(clientInfo, journeysList.get(i));
		}
		
		logisticCompanyApp.logisticCompanyLogout();
		
		List <ClientInfo>  list = logisticCompanyApp.searchClient(clientInfo.getEmail());
		
		assertEquals(list.get(0).getAddress().getCity(),clientInfo.getAddress().getCity());
		assertEquals(list.get(0).getAddress().getStreet(),clientInfo.getAddress().getStreet());
		assertEquals(list.get(0).getAddress().getPostCode(),clientInfo.getAddress().getPostCode());
		
	}

	@When("the logistic company registers the client")
	public void the_logistic_company_registers_the_client() {
		
		try {
			this.logisticCompanyApp.registerClient(clientInfo, "clientclient");
		} catch (Exception e) {
			this.errorMessage = e.getMessage();
		}
	}
	
	@When("the logistic company registers the client again")
	public void the_logistic_company_registers_the_client_again() {
		the_logistic_company_registers_the_client();
	}
	
	@When("the logistic company updates the client reference person to {string}")
	public void the_logistic_company_updates_the_client_reference_person_to(String newReferencePerson) {
	    clientInfo = clientHelper.getClient();
	    client = logisticCompanyApp.findClient(clientInfo);
	    clientInfo.setRefPerson(newReferencePerson);
	    
	    try {
			logisticCompanyApp.updateClientInfo(client, clientInfo);
		} catch (OperationNotAllowedException e) {
			errorMessage = e.getMessage();
		}
	}
	
	@Then("the client information should be updated")
	public void the_client_information_should_be_updated() {
		client = logisticCompanyApp.findClient(clientInfo);
		assertEquals(client.getRefPerson(),clientInfo.getReference_person());
	}
	
	@Then("the client is registered in the system")
	public void the_client_is_registered_in_the_system() {
	    Optional<ClientInfo> usr = logisticCompanyApp.getClientsStream().findFirst();
	    assertTrue(usr.isPresent());
	    ClientInfo c = usr.get();
	    
	    assertEquals(clientInfo.getName(), c.getName());
	    assertEquals(clientInfo.getEmail(), c.getEmail());
	    assertEquals(clientInfo.getReference_person(), c.getReference_person());
	}
	
	@Then("the system gives the error message {string}")
	public void the_system_gives_the_error_message(String message) {
	    assertEquals(message,errorMessage);
	}

	
}