package org.demoqa.test;

import org.application.base.Base;
import org.demoqa.pages.FrameHandlingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class is used to validate iframe functionality.
 * 
 * @author jyoti
 *
 */
public class DemoqaFrameTest extends Base {

	FrameHandlingPage frameHandlingPage;
	String frameText = null;

	/*
	 * This function is used to launch the application and instantiate the
	 * FrameHandlingPage page object.
	 */
	@BeforeMethod
	public void flipkartApplication() {

		launchApplication("chrome", "https://demoqa.com/nestedframes");
		frameHandlingPage = new FrameHandlingPage();

	}

	/*
	 * This function is used to run the test on FrameHandlingPage in specific
	 * order.
	 */
	@Test
	public void childParentFrameTest() {
		frameHandlingPage.parentFrameDetail();
		frameText = frameHandlingPage.childFrameDetail();
		System.out.println("Frame Text is :" + frameText);
	}

	/*
	 * This function is used to quit the browser after execution.
	 */
	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
