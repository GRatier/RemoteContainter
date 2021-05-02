package domains;

import javax.persistence.*;

import mainClasses.JourneyInfo;

@Entity
public class Journey {
	@Id
	@GeneratedValue
	private long id;
	private String originPort;
	private String destinationPort;
	private boolean isRegistered;
	private String cargo;
	private float internalTemp;
	private float airHumidity;
	private float atmPressure;

	@Embedded
	private JourneyStatusEntry currentJourneyStatus;

//	@ElementCollection
//	private List<String> journeyLog = new ArrayList<String>(); //Consider creating a logEntry object and having a list of it here!
//	@OneToMany
//	private ArrayList<JourneyStatus> journeyLogs = new ArrayList<>();

	public Journey() {

	}

	public Journey(JourneyInfo journeyInfo) {
		this.originPort = journeyInfo.getOriginPort();
		this.destinationPort = journeyInfo.getDestinationPort();
		journeyInfo.getLocation();
		this.cargo = journeyInfo.getCargo();
	}

	public void setJourneyStatus(JourneyStatusEntry journeyStatus) {
//		journeyLogs.add(this.currentJourneyStatus);
		this.currentJourneyStatus = journeyStatus;
//		journeyStatus.getLocation();
	}

	public void setInternalTemp(float temp) {
		this.internalTemp = temp;
	}
	
	public void setairHumidity(float airHumidity) {
		this.airHumidity = airHumidity;
	}
	
	public void setatmPressure(float atmPressure) {
		this.atmPressure = atmPressure;
	}
	
	public JourneyStatusEntry getJourneyStatus() {
		return currentJourneyStatus;
	}

	public String getStartDestination() {
		return originPort;
	}

	public String getEndDestination() {
		return destinationPort;
	}

	public String getCargo() {
		return cargo;
	}

	public long getId() {
		return id;
	}
	
	public float getInternalTemp() {
		return internalTemp;
	}
	
	public float getAirHumidity() {
		return airHumidity;
	}
	
	public float getAtmPressure() {
		return atmPressure;
	}

	public boolean matchJourney(String searchText) {
		return cargo.contains(searchText) || originPort.contains(searchText) || destinationPort.contains(searchText);

	}

	public JourneyInfo asJourneyInfo() {
		return new JourneyInfo(this.getCargo(), this.getStartDestination(), this.getEndDestination(), this.currentJourneyStatus);
	}

}
