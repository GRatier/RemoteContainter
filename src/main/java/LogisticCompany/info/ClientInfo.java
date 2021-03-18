package LogisticCompany.info;

import LogisticCompany.domain.Address;
import LogisticCompany.domain.Client;


public class ClientInfo {
	private String name;
	private String email;
	private Address address;
	
	
	public ClientInfo(String name, String email, Address address) {
		this.name = name;
		this.email = email;
	}
	
	public ClientInfo(Client client) {
		this.name = client.getName();
		this.email = client.getEmail();
		this.address = client.getAddress();
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
	

	public String toString() {
		return getName() + ", " + getEmail();
	}
	
}
