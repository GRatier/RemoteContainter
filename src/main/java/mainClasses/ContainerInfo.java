package mainClasses;


import domains.Journey;

import java.io.File;
import java.time.format.DateTimeFormatter;

import domains.Client;

public class ContainerInfo {
	
	
	private int containerId;
	private String history;
	DateTimeFormatter Time = DateTimeFormatter.ofPattern("HH:mm:ss");

	public int getContainerId() {
		return containerId;
	}

	public void setContainerId(int containerId) {
		this.containerId = containerId;
	}

	public void setHistory(Client client, Journey journey) {
		File file = new File(containerId + " History");
		if (file.exists()) {
			history = history + "Journey Id; " + journey.getId() + System.lineSeparator() +
			"Client: " + client.getName() + System.lineSeparator() +
			"Cargo: " + journey.getCargo() + System.lineSeparator() +
			"Origin: " + journey.getStartDestination() + System.lineSeparator() +
			"Destination: " + journey.getEndDestination() + System.lineSeparator() +
			"Time, Internal temperature, Atmospheric pressure, Air humodity" + System.lineSeparator() + 
			Time + ", " + journey.getInternalTemp() + ", " + journey.getAtmPressure() + ", " + journey.getAirHumidity();
			
		}
		else {
			history = "History of container " + containerId + System.lineSeparator() +
			"Journey Id; " + journey.getId() + System.lineSeparator() +
			"Client: " + client.getName() + System.lineSeparator() +
			"Cargo: " + journey.getCargo() + System.lineSeparator() +
			"Origin: " + journey.getStartDestination() + System.lineSeparator() +
			"Destination: " + journey.getEndDestination() + System.lineSeparator() +
			"Time, Internal temperature, Atmospheric pressure, Air humodity" + System.lineSeparator() + 
			Time + ", " + journey.getInternalTemp() + ", " + journey.getAtmPressure() + ", " + journey.getAirHumidity();
		}
	}
	
	public void updateHistory(Journey journey) {
		history = history + System.lineSeparator() + Time + ", " + journey.getInternalTemp() + ", " + journey.getAtmPressure() + ", " + journey.getAirHumidity();
		
	}
	
	public String getHistory() {
		return history;
	}
	
	
	// the code bellow should be updated 
	public static boolean contains(ContainerInfo containerId) {
		if (ContainerInfo.contains(containerId)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
}

