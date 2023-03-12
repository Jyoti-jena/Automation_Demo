package org.demoqa.test;

import org.application.base.Base;
import org.demoqa.pages.AlertsHandlingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class is used to validate alert handling functionality.
 * 
 * @author jyoti
 *
 */

public class DemoqaAlertTest extends Base {

	AlertsHandlingPage alertsHandlingPage;

	/*
	 * This function is used to launch the application and instantiate the
	 * AlertsHandlingPage page object.
	 */
	@BeforeMethod
	public void demoqaAlertTestApp() {
		launchApplication("chrome", "https://demoqa.com/alerts");
		alertsHandlingPage = new AlertsHandlingPage();
	}

	/*
	 * This function is used to run the test on AlertsHandlingPage in specific
	 * order.
	 */

	@Test
	public void childParentFrameTest() {
		alertsHandlingPage.viewAlertDetail();
		alertsHandlingPage.viewAlertWithTimeDetails();
		alertsHandlingPage.confirmBoxDetails();
		alertsHandlingPage.promptBoxDetails();
	}

	/*
	 * This function is used to quit the browser after execution.
	 */
	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
