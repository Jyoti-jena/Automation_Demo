package org.flipkart.pages;

import org.application.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class is used for flipkart home screen related operation.
 * 
 * @author jyoti
 *
 */
public class FlipkartHomePage extends Base {

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement closePopup;

	@FindBy(xpath = "//img[@alt='Fashion']")
	WebElement fashionMenu;

	/*
	 * This function is used to initialize web elements.
	 */
	public FlipkartHomePage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * This function is use for closing the log-in pop-up.
	 */
	public void popupClose() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		closePopup.click();
	}

	/*
	 * This function is use for navigating to fashion menu.
	 */
	public void goToFashionMenu() {
		fashionMenu.click();
	}

}
