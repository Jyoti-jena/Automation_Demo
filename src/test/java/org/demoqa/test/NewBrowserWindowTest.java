package org.demoqa.test;

import org.application.base.Base;
import org.demoqa.pages.NewBrowserWindowPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class is used to validate drag-drop functionality.
 * 
 * @author jyoti
 *
 */
public class NewBrowserWindowTest extends Base {

	NewBrowserWindowPage newBrowserWindowPage;
	String actualText = null;
	String expectedText = null;

	/*
	 * This function is used to launch the application and instantiate the
	 * DemoqaDragDropPage page object.
	 */
	@BeforeMethod
	public void demoqaAlertTestApp() {

		launchApplication("chrome", "https://demoqa.com/browser-windows");
		newBrowserWindowPage = new NewBrowserWindowPage();

	}

	/*
	 * This function is used to run the test on NewBrowserWindowPage in specific
	 * order and validate the text of child frame to the expected result.
	 */
	@Test
	public void childParentFrameTest() {
		expectedText = "This is a sample page";
		newBrowserWindowPage.newWindowCLick();
		browserWindow();
		actualText = newBrowserWindowPage.getNewWindowText();
		if (actualText.equals(expectedText)) {
			System.out.println("message is verified");
		} else {
			System.out.println("message is not verified");
		}
	}

	/*
	 * This function is used to quit the browser after execution.
	 */
	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
