package domains;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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

	public boolean matchJourney(String searchText) {
		return cargo.contains(searchText) || originPort.contains(searchText) || destinationPort.contains(searchText);

	}

	public JourneyInfo asJourneyInfo() {
		return new JourneyInfo(this.getCargo(), this.getStartDestination(), this.getEndDestination(), this.currentJourneyStatus);
	}

}
