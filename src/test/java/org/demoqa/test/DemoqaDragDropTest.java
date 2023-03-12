package org.demoqa.test;

import org.application.base.Base;
import org.demoqa.pages.DemoqaDragDropPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class is used to validate drag-drop functionality.
 * 
 * @author jyoti
 *
 */

public class DemoqaDragDropTest extends Base {

	DemoqaDragDropPage demoqaDragDropPage;

	/*
	 * This function is used to launch the application and instantiate the
	 * DemoqaDragDropPage page object.
	 */
	@BeforeMethod
	public void demoqaAlertTestApp() {
		launchApplication("chrome", "https://demoqa.com/droppable");
		demoqaDragDropPage = new DemoqaDragDropPage();
	}

	/*
	 * This function is used to run the test on DemoqaDragDropPage in specific
	 * order.
	 */
	@Test
	public void childParentFrameTest() {
		demoqaDragDropPage.clickAcceptTab();
		demoqaDragDropPage.dropElement();
	}

	/*
	 * This function is used to quit the browser after execution.
	 */
	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
