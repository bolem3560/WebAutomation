package com.testautomation.StepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.util.ArrayList;
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

import static com.testautomation.Utility.Staticcontent.headercontent;

public class Headercontent_stepDefination extends ExtentReportListener {
	public String headertext;
	public ArrayList<String> links;
	private WebDriver driver;
	PropertiesFileReader obj = new PropertiesFileReader();
	cucumber.api.Scenario scenario;

	@Before
	public void before(cucumber.api.Scenario scenario) {
		this.scenario = scenario;

	}

	@Given("^initiate the chrome browser with url$")
	public void initiate_the_browser_with_chrome_with_url() throws Throwable {
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

	@When("^get the text of header$")
	public void get_the_text_of_header() throws Throwable {

		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "getting header text");
			headertext = new Datatable_HomePage(driver).getheadertext();
			logInfo.pass("getting header text");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError e) {
			testStepHandle("FAIL", driver, logInfo, e);
		} catch (Exception err) {
			testStepHandle("FAIL", driver, logInfo, err);
		}
	}

	@When("^validate the content of the header$")
	public void validate_the_content_of_the_header() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "getting header text");
			Assert.assertEquals(headertext, headercontent, "Header text are not matching");
			logInfo.pass("header text verification");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError e) {
			testStepHandle("FAIL", driver, logInfo, e);
		} catch (Exception err) {
			testStepHandle("FAIL", driver, logInfo, err);
		}
	}

	@When("^get urls from Table one$")
	public void get_urls_from_Table_one() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "table1_links validation");
			links = new Datatable_HomePage(driver).tableoneLinksValidations();
			logInfo.pass("table1_links validation" + links.toString());
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError e) {
			testStepHandle("FAIL", driver, logInfo, e);
		} catch (Exception err) {
			testStepHandle("FAIL", driver, logInfo, err);
		}
	}

	@When("^get urls from Table two$")
	public void get_urls_from_Table_two() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "table2_Links Validation");
			links = new Datatable_HomePage(driver).tableoneLinksValidations();
			logInfo.pass("table1_links validation" + links.toString());
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError e) {
			testStepHandle("FAIL", driver, logInfo, e);
		} catch (Exception err) {
			testStepHandle("FAIL", driver, logInfo, err);
		}
	}

	@When("^selenium link validation in webtable page$")
	public void selenium_link_validation_in_webtable_page() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "selenium link validation in webtable page");
			new Datatable_HomePage(driver).seleniumlink();
			logInfo.pass("selenium link validation in webtable page");
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