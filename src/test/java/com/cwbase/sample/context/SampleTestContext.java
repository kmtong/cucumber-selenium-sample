package com.cwbase.sample.context;

import org.openqa.selenium.WebDriver;

/**
 * Testing State Sample Implementation, shared among step definitions
 * 
 * @author kmtong
 *
 */
public class SampleTestContext {

	WebDriver webDriver;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void cleanup() {
		if (webDriver != null) {
			webDriver.quit();
			webDriver = null;
		}
	}

}
