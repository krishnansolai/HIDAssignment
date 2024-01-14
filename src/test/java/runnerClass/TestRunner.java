package runnerClass;
import io.cucumber.testng.CucumberOptions;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

    

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = "@Scenario3", 
features = {"src/test/resources/Feature/TestCase.feature"}, 
glue = {"stepDefinitions"},
plugin = {})
    
public class TestRunner  extends AbstractTestNGCucumberTests{
	
	@BeforeSuite
	@AfterSuite
	
	public void endBrowser(){
//		try {
//			
//			Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe /T");
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	

}
