package domains;

import javax.persistence.*;

@Embeddable
public class JourneyStatusEntry {
	private String location;
	private double airHumidity;
	private double atmPressure;
	private double internalTemp;
	
	public JourneyStatusEntry(String originPort,String destinationPort, String location, double airHumidity, double atmPressure, double internalTemp) {
		this.location = location;
		this.airHumidity = airHumidity;
		this.atmPressure = atmPressure;
		this.internalTemp = internalTemp;
	}
	
	public JourneyStatusEntry() {

	}
	
	public String getLocation(){
		return location;
	}
	public double getAirHumidity(){
		return airHumidity;
	}
	public double getAtmPressure(){
		return atmPressure;
	}
	public double getInternalTemp(){
		return internalTemp;
	}
}
