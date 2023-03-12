package org.demoqa.pages;

import org.application.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains Iframe related functions
 * 
 * @author jyoti
 *
 */

public class FrameHandlingPage extends Base {

	@FindBy(id = "frame1")
	WebElement parentFrame;

	@FindBy(tagName = "body")
	WebElement childFrame;

	String childFrameText = null;

	/*
	 * This function is used to initialize web elements.
	 */
	public FrameHandlingPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * This function is used switch from parent to child frame.
	 */
	public void parentFrameDetail() {
		driver.switchTo().frame(parentFrame);
		driver.switchTo().frame(0);
	}

	/*
	 * This function is used to get the text from the child frame.
	 */
	public String childFrameDetail() {
		childFrameText = childFrame.getText();
		return childFrameText;
	}
}
