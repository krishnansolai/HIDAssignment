package stepDefinitions;

import com.org.assignments.Interviewproject.AppTest;
import com.org.assignments.Interviewproject.UtilityFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinition extends UtilityFile {

	AppTest at = new AppTest();

	@Given("launch webdriver")
	public void initialize() {
		initializeDriver();
	}

	@Then("Navigate to ReactJS site")
	public void loginTest() {
		at.launchURL();

	}

	@Then("Click on Docs tab")
	public void clickDocs() {
		at.clickDocsTab();

	}

	@Then("Expand main Concepts Tab")
	public void mainConceptsTa() {
		at.mainConcepts();

	}

	@Then("Expand Advanced Guides Tab")
	public void advancedGuidesTab() {
		at.advancedGuides();

	}

	@Then("Click on Tutorial tab")
	public void clickTutorial() {
		at.clickTutorialTab();

	}

	@Then("Verify scroll text bold and blue line")
	public void verifyTutorial() {
		at.verifyTutorial();

	}

	@Given("Make a get call")
	public void getCallAPI() {
		at.getCallAPI();
	}

	@Then("Count the categories")
	public void countCat() {
		at.countCategories();

	}

	@Then("Get names of Food and Geo locations")
	public void getNames() {
		at.getNames();

	}
}
