package org.application.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the common objects and common functions to be used by
 * child classes for the test run of the application .
 * 
 * @author jyoti
 *
 */

public class Base {
	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;
	public static Alert alert;

	/*
	 * This function will take care of launching browser and the url, based on the
	 * input params passed to the function.
	 * 
	 * input parameters :
	 * 
	 * @browserName
	 * 
	 * @appURL
	 */
	@SuppressWarnings("deprecation")
	public static void launchApplication(String browserName, String appURL) {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {

		} else {
			System.out.println("we do not suuport this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		action = new Actions(driver);
	}

	/*
	 * This function will take care of switch the browser cursor to point to the new
	 * tab or window.
	 * 
	 */
	public static void browserWindow() {
		String originalTab = driver.getWindowHandle();
		for (String tab : driver.getWindowHandles()) {
			if (!tab.equals(originalTab)) {
				driver.switchTo().window(tab);
				break;
			}
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/*
	 * This function is used specify the time the driver should wait while searching
	 * for an element if it is not immediately present.
	 * 
	 */
	@SuppressWarnings("deprecation")
	public static void implicitTimeout() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/*
	 * This function is used to switch the browser cursor to point to the alert
	 * pop-up.
	 * 
	 */
	public static void initAlert() {
		alert = driver.switchTo().alert();
	}

	/*
	 * This function is used if selenium webdriver fails to click on any element due
	 * to some issue.
	 * 
	 */
	public static void javascriptExecutor(WebElement webElement) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", webElement);
	}

	/*
	 * This function is used to close all the browser.
	 * 
	 */
	public static void quitBrowser() {
		driver.quit();
	}
}
