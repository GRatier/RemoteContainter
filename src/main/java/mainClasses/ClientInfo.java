package mainClasses;

import domains.Address;
import domains.Client;

public class ClientInfo {
	
	private String name;
	private String email;
	private String reference;
	private Address address;

	public ClientInfo(String name, String email, String reference_person) {
		this.name = name;
		this.email = email;
		this.reference = reference_person;
	}
	
	public ClientInfo(Client client) {
		this.name = client.getName();
		this.email = client.getEmail();
		this.reference = client.getRefPerson();
		this.address = client.getAddress();
	}
	
	public String getReference_person() {
		return reference;
	}

	public Address getAddress() {
		return address;
	}
	public String getZipCode() {
		return address.getPostCode();
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	public Client asClient() {
		return new Client(this);
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public String toString() {
		return getName() + ", " + getEmail();
	}
	
}
