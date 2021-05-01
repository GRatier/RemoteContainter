package mainClasses;

import java.util.stream.Stream;

import domains.Client;

public interface ClientRepository {
	
	boolean contains(Client client);
	
	void addClient(Client cc);

	Stream<Client> getAllClientsStream();

	void removeClient(Client client);

	void clearClientDatabase();

	Client getClient(String email);

	void updateClient(Client client);
}
