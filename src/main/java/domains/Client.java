package domains;

import mainClasses.ClientInfo;

public class Client{

	private String name;
	private String email;
	private String password;
	private String refPerson;
	private Address address;
	public void setAddress(Address address) {
		this.address = address;
	}

	public Client() {
		
	}
	
	public Client(ClientInfo clientInfo) {
		this.name = clientInfo.getName();
		this.email = clientInfo.getEmail();
		this.refPerson = clientInfo.getReference_person();
		this.address = clientInfo.getAddress();
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	public String getRefPerson() {
		return refPerson;
	}

	public Address getAddress() {
		return address;
	}
	public boolean matchClient(String searchEmail) {
		return email.contains(searchEmail) || name.contains(searchEmail) || refPerson.contains(searchEmail);
	}
	
	public ClientInfo asClientInfo() {
		return new ClientInfo(this.getName(), this.getEmail(), this.getRefPerson());
	}
	
	public void updateClientInfo(ClientInfo clientInfo) {
		this.name = clientInfo.getName();
		this.email = clientInfo.getEmail();
		this.refPerson = clientInfo.getReference_person();
		this.address = clientInfo.getAddress();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
