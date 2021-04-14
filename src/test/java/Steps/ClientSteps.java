package Steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import domains.Address;
import domains.Client;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainClasses.ClientInfo;

public class ClientSteps {
	
	private ClientInfo clientInfo;
	
	private String errorMessage;
	private Address address;
	private Client client;
	
	@Given("there is a client with name {string}, email {string}, reference person {string}")
	 public void there_is_a_client_with_name_email_reference_person_password(String name, String email, String ref_person) {
		clientInfo = new ClientInfo(name, email, ref_person);
		
	    assertEquals(clientInfo.getName(),name);
	    assertEquals(clientInfo.getEmail(),email);
	    assertEquals(clientInfo.getReference_person(),ref_person);
	}
	
	@Given("there is a client registered in the system")
	public void there_is_a_client_registered_in_the_system() {

	}
	
	@Given("the client address is {string}, {string}, {string}")
	public void the_client_address_is(String street, String postcode, String city) {
		this.address = new Address(street,postcode,city);
		this.clientInfo.setAddress(address);
		
		assertEquals(clientInfo.getAddress().getStreet(),street);
		assertEquals(clientInfo.getAddress().getPostCode(),postcode);
		assertEquals(clientInfo.getAddress().getCity(),city);	
	}

	
	@Given("the client has registered journeys")
	public void the_client_has_registered_journeys() {
		
	}
	
	@When("the client looks for all his\\/her containers")
	public void the_client_looks_for_all_his_her_containers() {

	}
	
	@Then("all containers registered for the client journeys is given")
	public void all_containers_registered_for_the_client_journeys_is_given() {

	}

	@When("the logistic company registers the client")
	public void the_logistic_company_registers_the_client() {
		
	}
	
	@When("the logistic company registers the client again")
	public void the_logistic_company_registers_the_client_again() {
		the_logistic_company_registers_the_client();
	}
	
	@When("the logistic company updates the client reference person to {string}")
	public void the_logistic_company_updates_the_client_reference_person_to(String newReferencePerson) {

	}
	
	@Then("the client information should be updated")
	public void the_client_information_should_be_updated() {

	}
	
	@Then("the client is registered in the system")
	public void the_client_is_registered_in_the_system() {

	}
	
	@Then("the system gives the error message {string}")
	public void the_system_gives_the_error_message(String message) {
	    assertEquals(message,errorMessage);
	}

	
}