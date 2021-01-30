package com.testautomation.Utility;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtility {
	/**
	 * code for browsers launch using selenium
	 * 
	 * @param driver
	 * @param browserName
	 * @param url
	 * @return
	 * @throws InterruptedException
	 */
	public static WebDriver OpenBrowser(WebDriver driver, String browserName, String url) throws InterruptedException {

		if (SystemUtils.IS_OS_MAC) {

			if (browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//drivers//chromedriver");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(url);
				return driver;
			}
		}
		return null;
	}

}
