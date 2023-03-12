package org.demoqa.pages;

import org.application.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains drag and drop related functions
 * 
 * @author jyoti
 *
 */
public class DemoqaDragDropPage extends Base {

	@FindBy(id = "droppableExample-tab-accept")
	WebElement clickAcceptTab;

	@FindBy(id = "notAcceptable")
	WebElement notAcceptableElement;

	@FindBy(xpath = "//div[@id='acceptDropContainer']//div[@id='droppable']")
	WebElement dropElementDiv;

	/*
	 * This function is used to initialize web elements.
	 */
	public DemoqaDragDropPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * This function clicks the accept tab.
	 */
	public void clickAcceptTab() {
		action.moveToElement(clickAcceptTab).click().perform();
	}

	/*
	 * This function is used to drag and the drop the selected element inside target
	 * div.
	 */
	public void dropElement() {
		action.clickAndHold(notAcceptableElement).moveToElement(dropElementDiv).release().build().perform();
	}

}
