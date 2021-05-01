package app;

import java.util.List;

import domains.JourneyStatusEntry;
import mainClasses.JourneyInfo;


public class JourneyPrinter {
	
	private JourneyInfo journey;
//	private CalenderDate calenderDate = new CalenderDate();
//	private String localTime;
	private String location;
	public JourneyPrinter(JourneyInfo journey) {
		this.journey = journey;
	}
	
	public String printDetail() {
		StringBuffer b = new StringBuffer();
		JourneyStatusEntry journeyStatus;
		
		if (journey.getCurrentJourneyStatus()== null) {
			location = "not registered";
//			journeyStatus = new JourneyStatusEntry(journey.getOriginPort(),journey.getDestinationPort(),"not registered");
//			localTime = "";
		}else { 
			location = journey.getCurrentJourneyStatus().getLocation();
//			localTime = calenderDate.getCurrentDate() + " at ";
		}
		
		String tab = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		
		b.append("<html>"+String.format("<b>The journey has cargo:</b>     %s<br>", journey.getCargo()));
		b.append(String.format("<b>The journey starts at:</b>    %s<br>", journey.getOriginPort()));
		b.append(String.format("<b>The current location:</b>    %s<br>", location));
		b.append(String.format("<b>The journey ends at:</b>   %s<br>" , journey.getDestinationPort()));
		
		return b.toString();
	}
	
	public String print() {
		return "Journey from " + journey.getOriginPort() + " to " +journey.getDestinationPort();
	}

}
