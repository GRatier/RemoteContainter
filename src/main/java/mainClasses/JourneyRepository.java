package mainClasses;
import java.util.stream.Stream;

import domains.Journey;


public interface JourneyRepository {
	
	boolean contains(Journey journey);
	
	void addJourney(Journey journey); 
	
	Stream<Journey> getAllJourneysStream();

	void removeJourney(Journey journey);

	void clearJourneyDatabase();
	
	Journey getJourney(String cargo);

	void updateJourney(Journey journey);
}
