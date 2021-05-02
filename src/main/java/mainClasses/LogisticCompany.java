package mainClasses;

import domains.LogisticCom;

//

public class LogisticCompany {
	
	
	public void updateAirHumidity(LogisticCom airHumidity,ContainerInfo containerId) {
		
		// if container Id exist then update else no
		//LogisticCom airHum = getAirHumidity(airHumidity);
		
		if(ContainerInfo.contains(containerId)) {
			return;
		}
		
		else {
			System.out.println("No Container found!");
		}
	}
		
		
		public void updateAtmPressure(LogisticCom atmPresssure,ContainerInfo containerId) {
			
			if(ContainerInfo.contains(containerId)) {
				return;
			}
			
			else {
				System.out.println("No Container found!");
			}
		}
			
		public void updateInternalTemp(LogisticCom internalTemp,ContainerInfo containerId) {
				
				if(ContainerInfo.contains(containerId)) {
					return;
				}
				
				else {
					System.out.println("No Container found!");
				}
		}		
		
}
	
