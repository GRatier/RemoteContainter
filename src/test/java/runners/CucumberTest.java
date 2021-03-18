package runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/")

//		features = "src/main/resources/ClientProvideAccess.feature")
//		features = "src/main/resources/Client_login.feature")

public class CucumberTest {

}