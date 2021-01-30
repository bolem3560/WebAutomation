package com.testautomation.PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.listeners.ExtentReportListener;
import static com.testautomation.Utility.Staticcontent.elementalselenium_browsertitle;
import static com.testautomation.Utility.Staticcontent.elementalselenium_header;

/**
 * Page objects repository and common functions
 * 
 * @author kbolem
 *
 */
public class Datatable_HomePage extends ExtentReportListener {
	PropertiesFileReader obj = new PropertiesFileReader();
	WebDriver driver;

	@FindBy(xpath = "//*[@id='content']/div/p[1]")
	public WebElement headercontent;

	@FindBy(xpath = "//div[@class='example']/table[1]")
	public WebElement tableone;

	@FindBy(xpath = "//table[2][@class='tablesorter']")
	public WebElement tabletwo;

	@FindBy(xpath = "//*[@id='page-footer']/div/div/a")
	public WebElement elementalSeleniumlink;

	@FindBy(xpath = "/html/body/header/div/div/h1")
	public WebElement seleniumpageheader;

	public Datatable_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getheadertext() {
		String actualtext = headercontent.getText();
		String str = tabletwo.getText();
		System.out.println(str);
		return actualtext;
	}

	public String pageTitle() {
		String actualtext = driver.getTitle();
		return actualtext;
	}

	public int tableone() {
		List<WebElement> records = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr"));
		int rowssize = records.size();
		return rowssize;

	}

	public int tabletwo() {
		List<WebElement> records = driver.findElements(By.xpath("//*[@id='table2']/tbody/tr"));
		int rowssize = records.size();
		return rowssize;
	}

	public ArrayList<String> tableoneLinksValidations() throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		String url = null;
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='table2']/tbody/tr"));
		int rowssize = rows.size();

		for (int i = 1; i <= rowssize; i++) {
			url = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + i + "]/td[5]")).getText();
			list.add(url);

		}
		return list;
	}

	public ArrayList<String> tabletwoLinksValidations() {
		ArrayList<String> list = new ArrayList<String>();
		String url = null;
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='table2']/tbody/tr"));
		int rowssize = rows.size();

		for (int i = 1; i <= rowssize; i++) {
			url = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + i + "]/td[5]")).getText();
			list.add(url);

		}
		return list;
	}

	public void seleniumlink() throws InterruptedException {
		elementalSeleniumlink.click();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().equals(elementalselenium_browsertitle)) {
				String actualtext = seleniumpageheader.getText();
				Assert.assertEquals(actualtext, elementalselenium_header);
				break;
			}

		}
		driver.switchTo().defaultContent();
	}

	public void waitforPageElement(long timeOutInSeconds) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(headercontent));
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}
	}

	public void closebrowser() {
		if (driver != null) {
			driver.quit();
		}

	}

}
