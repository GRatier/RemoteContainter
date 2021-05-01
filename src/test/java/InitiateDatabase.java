
import domains.LogisticCom;
import io.cucumber.java.Before;
import pers.SQLRepository;

public class InitiateDatabase {
	LogisticCom logisticCompanyApp;
	
	public InitiateDatabase(LogisticCom logisticCompanyApp) {
		this.logisticCompanyApp = logisticCompanyApp;
	}
	
	@Before
	public void connectDatabase() {
		SQLRepository repo = new SQLRepository();
		logisticCompanyApp.setRepositories(repo,repo);
		logisticCompanyApp.clearDatabase();
		
	}
}
