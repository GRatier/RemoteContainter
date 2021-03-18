package LogisticCompany.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import javax.persistence.*;
import LogisticCompany.App.ClientRepository;
import LogisticCompany.info.ClientInfo;

@Entity
public class Client{
    @GeneratedValue
    @Id
    private long id;
	private String name;
//	@Id
	private String email;
	private String password;
	@Embedded
	private Address address;
	public void setAddress(Address address) {
		this.address = address;
	}

	public Client() {
		
	}
	
	public Client(ClientInfo clientInfo) {
		this.name = clientInfo.getName();
		this.email = clientInfo.getEmail();
		this.address = clientInfo.getAddress();
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	

	public Address getAddress() {
		return address;
	}
	public boolean matchClient(String searchEmail) {
		return email.contains(searchEmail) || name.contains(searchEmail);
	}
	
	public ClientInfo asClientInfo() {
		return new ClientInfo(this.getName(), this.getEmail(), this.address);
	}
	
	public void updateClientInfo(ClientInfo clientInfo) {
		this.name = clientInfo.getName();
		this.email = clientInfo.getEmail();
		this.address = clientInfo.getAddress();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
