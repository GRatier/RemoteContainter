package mainClasses;

import domains.Client;
import domains.LogisticCom;

public class ContainerInfo {
	
	
	private int containerId;
	private String history;

	public int getContainerId() {
		return containerId;
	}

	public void setContainerId(int containerId) {
		this.containerId = containerId;
	}

	public void setHistory(int containerId, Client client, String origin, String destination, String content) {
		LogisticCom con = new LogisticCom();
		
		history = "History of container " + containerId + System.lineSeparator() +
		"Client: " + client + System.lineSeparator() +
		"Content: " + content + System.lineSeparator() +
		"Origin: " + origin + System.lineSeparator() +
		"Destination: " + destination + System.lineSeparator() +
		"Time, Internal temperature, Atmospheric pressure, Air humodity" + System.lineSeparator() + 
		1/*con.getTime*/ + ", " + con.getInternalTemp() + ", " + con.getAtmPressure() + ", " + con.getAirHumidity();
		
	}
	
	public void updateHistory() {
		LogisticCom con = new LogisticCom();
		history = history + System.lineSeparator() + 1/*con.getTime*/ + con.getInternalTemp() + ", " + con.getAtmPressure() + ", " + con.getAirHumidity();
		
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

