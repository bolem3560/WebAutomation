package com.testautomation.StepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import static com.testautomation.Utility.Staticcontent.browsertitle;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomation.PageObjects.Datatable_HomePage;
import com.testautomation.Utility.BrowserUtility;
import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.listeners.ExtentReportListener;

public class Pagetitle_stepDefination extends ExtentReportListener {
	public String title;
	private WebDriver driver;
	PropertiesFileReader obj = new PropertiesFileReader();
	cucumber.api.Scenario scenario;

	@Before
	public void before(cucumber.api.Scenario scenario) {
		this.scenario = scenario;

	}

	@Given("^Initialize the chrome browser with url$")
	public void initialize_the_browser_with_chrome() throws Throwable {

		ExtentTest logInfo = null;
		try {
			test = extent.createTest(Feature.class, scenario.getName());
			test = test.createNode(Scenario.class, scenario.getName());
			logInfo = test.createNode(new GherkinKeyword("Given"), "open_Chrome_browser_with_URL");
			Properties properties = obj.getProperty();
			driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"),
					properties.getProperty("browser.baseURL"));

			logInfo.pass("Opened chrome browser and entered url");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			new Datatable_HomePage(driver).waitforPageElement(5000);
		} catch (AssertionError e) {
			testStepHandle("FAIL", driver, logInfo, e);
		} catch (Exception err) {
			testStepHandle("FAIL", driver, logInfo, err);
		}
	}

	@When("^get the title of the browser$")
	public void get_the_title_of_the_browser() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "Page Title");
			title = new Datatable_HomePage(driver).pageTitle();
			logInfo.pass("Page Title");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError e) {
			testStepHandle("FAIL", driver, logInfo, e);
		} catch (Exception err) {
			testStepHandle("FAIL", driver, logInfo, err);
		}
	}

	@When("^validate the title$")
	public void validate_the_title() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "Page Title Verification");
			Assert.assertEquals(title, browsertitle, " Pagetitle are not matching");
			logInfo.pass("Page Title text verification");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError e) {
			testStepHandle("FAIL", driver, logInfo, e);
		} catch (Exception err) {
			testStepHandle("FAIL", driver, logInfo, err);
		}
	}

	@When("^get the size of the table one$")
	public void getSizeofTableone() throws Throwable {

		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "Size of the Table_one");
			int tablesize = new Datatable_HomePage(driver).tableone();
			logInfo.pass("Sizeo of the table_one.." + tablesize);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError e) {
			testStepHandle("FAIL", driver, logInfo, e);
		} catch (Exception err) {
			testStepHandle("FAIL", driver, logInfo, err);
		}

	}

	@When("^get the size of the tabl two$")
	public void getSizeofTabletwo() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "Size of the Table_one");
			int tablesize = new Datatable_HomePage(driver).tabletwo();
			logInfo.pass("Sizeo of the table_two.." + tablesize);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError e) {
			testStepHandle("FAIL", driver, logInfo, e);
		} catch (Exception err) {
			testStepHandle("FAIL", driver, logInfo, err);
		}
	}

	@After
	public void closebrowser() {
		new Datatable_HomePage(driver).closebrowser();
	}
}