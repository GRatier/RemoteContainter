package domains;

import javax.persistence.*;

@Embeddable
public class JourneyStatusEntry {
	private String location;
	
	public JourneyStatusEntry(String originPort,String destinationPort, String location) {
		this.location = location;
	}
	
	public JourneyStatusEntry() {

	}
	
	public String getLocation(){
		return location;
	}
	
}
