package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.Base;



public class Hooks extends Base {
	static ExtentSparkReporter spark;
	static ExtentReports extReports;
	static ExtentTest extTest;

	@BeforeAll
	public static void beforeAll() {
		spark = new ExtentSparkReporter("ExtentReport.html");
		extReports = new ExtentReports();
		extReports.attachReporter(spark);
		
		
	}
	
	@AfterAll
	public static void afterAll() {
		extReports.flush();
	
	}
	
	@Before
	public void setUp(Scenario scenario) {
		launchBrowser();
		extTest = extReports.createTest(scenario.getName());
		
	}
	
	@After
	public void tearDown() {
		Base.sleep();
		driver.quit();
		
	}
	
	

}