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
	
	@When("the logistic company updates the journey location to {string}")
	public void the_logistic_company_updates_the_journey_location_to(String newLocation) {
		journeyInfo = journeyHelper.getJourney();
		journey = logisticCompanyApp.findJourney(journeyInfo);
		journeyStatus = new JourneyStatusEntry(journeyInfo.getOriginPort(), journeyInfo.getDestinationPort(),newLocation);
		
		try {
			logisticCompanyApp.updateJourneyInfo(journey, journeyStatus);
		} catch (OperationNotAllowedException e) {
			e.getMessage();
		}      
	}
	
	@Then("the journey current position is updated with current location {string}")
	public void the_journey_current_position_is_updated_with_current_location(String string) {
		journey = logisticCompanyApp.findJourney(journeyInfo);
		assertEquals(journey.getJourneyStatus().getLocation(),journeyStatus.getLocation());
	}
	
}
