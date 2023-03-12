package org.demoqa.pages;

import java.time.Duration;

import org.application.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains alert related functions
 * 
 * @author jyoti
 *
 */
public class AlertsHandlingPage extends Base {

	@FindBy(id = "alertButton")
	WebElement viewAlert;

	@FindBy(id = "timerAlertButton")
	WebElement viewAlertWithTime;

	@FindBy(id = "confirmButton")
	WebElement confirmBoxAlert;

	@FindBy(id = "promtButton")
	WebElement promtBoxAlert;

	/*
	 * This function is used to initialize web elements.
	 */
	public AlertsHandlingPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * This function clicks the button and shows the alert.
	 */
	public void viewAlertDetail() {
		implicitTimeout();
		viewAlert.click();
		initAlert();
		alert.accept();
	}

	/*
	 * This function clicks the button and shows the alert after a specified time.
	 */
	public void viewAlertWithTimeDetails() {
		viewAlertWithTime.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		initAlert();
		alert.accept();
	}

	/*
	 * This function handles confirm box functionality.
	 */
	public void confirmBoxDetails() {
		javascriptExecutor(confirmBoxAlert);
		initAlert();
		alert.accept();
	}

	/*
	 * This function handles prompt box functionality.
	 */
	public void promptBoxDetails() {
		javascriptExecutor(promtBoxAlert);
		initAlert();
		alert.sendKeys("jyoti");
		alert.accept();
	}

}
