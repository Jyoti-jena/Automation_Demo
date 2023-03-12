package org.demoqa.pages;

import org.application.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class handles the new window related functionality.
 * 
 * @author jyoti
 *
 */
public class NewBrowserWindowPage extends Base {

	@FindBy(id = "windowButton")
	WebElement newWindowButton;

	@FindBy(id = "sampleHeading")
	WebElement newWindow;

	/*
	 * This function is used to initialize web elements.
	 */
	public NewBrowserWindowPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * This function clicks the new window section.
	 */
	public void newWindowCLick() {
		newWindowButton.click();
	}

	/*
	 * This function is used to get the text from the newly opened window.
	 */
	public String getNewWindowText() {
		String text = newWindow.getText();
		return text;
	}
}
