package domains;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mainClasses.ClientInfo;
import mainClasses.ClientRepository;
import mainClasses.JourneyInfo;
import mainClasses.JourneyRepository;
import mainClasses.OperationNotAllowedException;


public class LogisticCom {
	
	private PropertyChangeSupport support = new PropertyChangeSupport(this);
	
	private boolean logisticCompanyloggedIn = false;
	private boolean clientLoggedIn = false;
	private ClientRepository clientRepository;
	private JourneyRepository journeyRepository;
	private Client client;
	private JourneyInfo selectedJourneyInfo;
	private double airHumidity;
	private double atmPressure;
	private double internalTemp;
	private int containerId;
	
	public LogisticCom(ClientRepository clientRepository, JourneyRepository journeyRepository ) {
		this.journeyRepository = journeyRepository;
		this.clientRepository = clientRepository;
	}
	
	public LogisticCom(int containerId, double airHumidity, double atmPressure, double internalTemp) {
	}


	public void clearDatabase() {
		clientRepository.clearClientDatabase();
		journeyRepository.clearJourneyDatabase();
	}
	
	
	public Client findClient(ClientInfo cc) {
		return clientRepository.getClient(cc.getEmail());
	}

	public Journey findJourney(JourneyInfo j) {
		return journeyRepository.getJourney(j.getCargo());
	}
	
	public List<ClientInfo> searchClient(String searchText) {
		return clientRepository.getAllClientsStream()
				.filter(c -> c.matchClient(searchText))
				.map(c -> c.asClientInfo())
				.collect(Collectors.toList());
	}

	public List<JourneyInfo> searchJourney(String searchText) {
		return journeyRepository.getAllJourneysStream()
				.filter(j -> j.matchJourney(searchText))
				.map(j -> j.asJourneyInfo())
				.collect(Collectors.toList());
	}
	
	public void registerClient(ClientInfo cc, String password) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		
		Client client = findClient(cc);
		if (client != null) {
			throw new OperationNotAllowedException("The client is already registered");
		}
		
		clientRepository.addClient(cc.asClient());
		setClientPassword(cc,password);
	}
	
	public void registerClient(String name, String email, String password, String zipCode, String city, String street, String refPerson) throws OperationNotAllowedException {
		ClientInfo clientInfo = new ClientInfo(name, email, refPerson);
		
		Address address = new Address(street,zipCode,city);
		clientInfo.setAddress(address);
		
		registerClient(clientInfo, password);
	}
	
	public void registerJourney(JourneyInfo j) {
		journeyRepository.addJourney(j.asJourney());
	}
	
	public void unregisterClient(ClientInfo cc, JourneyInfo j)throws Exception {
		Client client = findClient(cc);
		logisticCompanyLoggedIn();
		if (!isJourneyDone(j) )
		{
			throw new Exception("Can not unregister a client when a journey is on going");
		}
		clientRepository.removeClient(client);
	}
	
	public boolean isJourneyDone(JourneyInfo j) {
		if (j.getLocation().equals(j.getDestinationPort()))
		{
			return true; 
		}
		else { return false; }
	}
	
	public boolean logisticCompanyLogin(String password) throws OperationNotAllowedException {
		logisticCompanyloggedIn = password.equals("logisticCompany123");
		
		if (logisticCompanyloggedIn == false) {
			throw new OperationNotAllowedException("Incorrect password!");
		}
		
		return logisticCompanyloggedIn;
	}
	
	public boolean logisticCompanyLoggedIn() {
		return logisticCompanyloggedIn;
	}
	
	public void logisticCompanyLogout() {
		logisticCompanyloggedIn = false;
	}
	
	public boolean clientLoggedIn() {
		return clientLoggedIn;
	}
	
	public void checkLogisticCompanyLoggedIn() throws OperationNotAllowedException {
		if (!logisticCompanyLoggedIn()) {
			throw new OperationNotAllowedException("Logistic Company login required");
		}
	}
	
	public void checkClientLoggedIn() throws OperationNotAllowedException {
		if (!clientLoggedIn()) {
			throw new OperationNotAllowedException("Client login required");
		}
	}
	
	
	public void setRepositories(ClientRepository clientRepo, JourneyRepository journeyRepo) {
		this.clientRepository = clientRepo;
		this.journeyRepository = journeyRepo;	
		
	}

	public Stream<ClientInfo> getClientsStream() {
		return this.clientRepository.getAllClientsStream().map(c -> new ClientInfo(c));
	}
	
	public Stream<JourneyInfo> getJourneysStream() {
		return this.journeyRepository.getAllJourneysStream().map(j -> new JourneyInfo(j));
	}

	public boolean clientLogin(String email, String password) throws OperationNotAllowedException{
		this.client = findClient(new ClientInfo("",email,""));
		
		if (client == null) {
			throw new OperationNotAllowedException("No client registered with the given email!");
		}

		clientLoggedIn = password.equals(client.getPassword());
		
		if (clientLoggedIn == false) {
			throw new OperationNotAllowedException("Incorrect password!");
		}
		
		return clientLoggedIn;
	}

	public void clientLogout() {
		clientLoggedIn = false;
	}
	
	public void registerJourney(String cargo, String originPort, String endDestination) {
		JourneyInfo journeyInfo = new JourneyInfo(cargo, originPort, endDestination);
		
		registerJourney(journeyInfo);
		
		registerJourneyToClient(client.asClientInfo(), journeyInfo);
	}
	
	public void registerJourneyToClient(ClientInfo client, JourneyInfo journey){
		
		Journey journeyObj = findJourney(journey);
		Client clientObj = findClient(client);
		
		clientObj.addJourney(journeyObj);
		clientRepository.updateClient(clientObj);
	}
	
	public void updateJourneyInfo(Journey journey, JourneyStatusEntry journeyStatus) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		journey.setJourneyStatus(journeyStatus);
		journeyRepository.updateJourney(journey);
	}
	public void updateJourneyInfo(JourneyInfo journeyinfo, JourneyStatusEntry journeyStatus) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		Journey journey = findJourney(journeyinfo);
		journey.setJourneyStatus(journeyStatus);
		journeyRepository.updateJourney(journey);
	}
	
	public void updateClientInfo(Client client, ClientInfo clientInfo) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		client.updateClientInfo(clientInfo);
		clientRepository.updateClient(client);
	}

	public void setClientPassword(ClientInfo clientInfo, String password) {
		Client client = findClient(clientInfo);
		client.setPassword(password);
		
	}
	
	public Client getClient() {
		return client;
	}
	
	public int getContainerId() {
		return containerId;
	}

	public void setContainerId(int containerId) {
		this.containerId = containerId;
	}

	
	public double getAirHumidity() {
		return airHumidity;
	}

	public void setAirHumidity(double airHumidity) {
		this.airHumidity = airHumidity;
	}

	public double getAtmPressure() {
		return atmPressure;
	}

	public void setAtmPressure(double atmPressure) {
		this.atmPressure = atmPressure;
	}

	public double getInternalTemp() {
		return internalTemp;
	}

	public void setInternalTemp(double internalTemp) {
		this.internalTemp = internalTemp;
	}
	
	public void addObserver(PropertyChangeListener l) {
		support.addPropertyChangeListener(l);
	}

	public JourneyInfo getSelectedjourneyInfo() {
		return selectedJourneyInfo;
	}
	
	public void setSelectedObjects(JourneyInfo selectedJourneyInfo) {
		this.selectedJourneyInfo = selectedJourneyInfo;
		findJourney(selectedJourneyInfo);

		support.firePropertyChange("SelectedJourney",null,null);
	}
	
}