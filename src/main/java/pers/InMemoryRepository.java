package pers;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import domains.Client;
import domains.Journey;
import mainClasses.ClientRepository;
import mainClasses.JourneyRepository;


public class InMemoryRepository implements ClientRepository , JourneyRepository{

	List<Client> clients = new ArrayList<>();
	List<Journey> journeys = new ArrayList<>();

	@Override
	public void addClient(Client client) {
		clients.add(client);
	}

	@Override
	public Stream<Client> getAllClientsStream() {
		return clients.stream();
	}


	@Override
	public boolean contains(Client client) {
		return clients.contains(client);
	}
	
	@Override
	public void clearClientDatabase() {
		clients.clear();
		
	}

	@Override
	public void removeClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addJourney(Journey journey) {
		journeys.add(journey);
	}

	@Override
	public Stream<Journey> getAllJourneysStream() {
		return journeys.stream();
	}

	@Override
	public void removeJourney(Journey journey) {
		journeys.remove(journey);
	}
	
	@Override
	public boolean contains(Journey journey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clearJourneyDatabase() {
		journeys.clear();
		
	}


	@Override
	public Journey getJourney(String cargo) {
		return journeys.stream().filter(j -> j.getCargo().equals(cargo)).findFirst().orElse(null);
	}

	@Override
	public Client getClient(String email) {
		return clients.stream().filter(c -> c.getEmail().equals(email)).findFirst().orElse(null);
	}

	@Override
	public void updateJourney(Journey journey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	

	
}
