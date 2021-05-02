package Steps;

import static org.junit.Assert.assertEquals;
import domains.Journey;
import domains.JourneyStatusEntry;
import domains.LogisticCom;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainClasses.JourneyInfo;
import mainClasses.OperationNotAllowedException;
import pers.InMemoryRepository;


public class JourneySteps {
	
    private InMemoryRepository repository = new InMemoryRepository();
    private LogisticCom logisticCompanyApp = new LogisticCom(repository,repository);
    public ClientHelper clientHelper;
    private JourneyStatusEntry journeyStatus;
	public JourneyInfo journeyInfo;
	public JourneyHelper journeyHelper;
	private Journey journey;
	
	
	public JourneySteps(LogisticCom logisticCompanyApp,ClientHelper clientHelper, JourneyHelper journeyHelper) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.clientHelper = clientHelper;
		this.journeyHelper =journeyHelper;
	}
	
	@When("the logistic company updates the journey status to location {string}, air humidity {double}, atm pressure {double}, internal temp {double}")
	public void the_logistic_company_updates_the_journey_status_to(String newLocation, double newairHumidity, double newatmPressure, double newinternalTemp ) {
		journeyInfo = journeyHelper.getJourney();
		journey = logisticCompanyApp.findJourney(journeyInfo);
		journeyStatus = new JourneyStatusEntry(journeyInfo.getOriginPort(), journeyInfo.getDestinationPort(),newLocation, newairHumidity, newatmPressure, newinternalTemp );
		
		try {
			logisticCompanyApp.updateJourneyInfo(journey, journeyStatus);
		} catch (OperationNotAllowedException e) {
			e.getMessage();
		}      
	}
	
	@Then("the journey current status is updated with current information {string}, air humidity {double}, atm pressure {double}, internal temp {double}")
	public void the_journey_current_status_is_updated_with_current_locationinformation(String string,double DoubleAH,double DoubleAP,double DoubleIT) {
		journey = logisticCompanyApp.findJourney(journeyInfo);
		assertEquals(journey.getJourneyStatus().getLocation(),journeyStatus.getLocation());
		
	}
	
	
		
	
}
