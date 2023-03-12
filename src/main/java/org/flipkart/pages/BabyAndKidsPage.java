package org.flipkart.pages;

import org.application.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class is used to navigate to fashion section and hover to Baby & Kids
 * and then clicks on Dresses & Skirts sub-menu. .
 * 
 * @author jyoti
 *
 */
public class BabyAndKidsPage extends Base {

	@FindBy(xpath = "//span[normalize-space()='Baby & Kids']")
	WebElement babyAndKids;

	@FindBy(xpath = "//a[@title='Dresses & Skirts']")
	WebElement babyDressesSKirts;

	@FindBy(xpath = "//div[normalize-space()='Price -- Low to High']")
	WebElement priceLowToHigh;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[10]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/div[1]/div[1]/img[1]")
	WebElement specificProduct;

	/*
	 * This function is used to initialize web elements.
	 */
	public BabyAndKidsPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * This function is used to hover on the Baby & Kids menu
	 */
	public void babyAndKidsSection() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action.moveToElement(babyAndKids).perform();
	}

	/*
	 * This function is used to click the Dresses & Skirts sub-menu.
	 */
	public void babyDressAndSKirtsSection() {
		babyDressesSKirts.click();
	}

	/*
	 * This function is used to hover and click the price low to high filter.
	 */
	public void priceLowToHighFilter() {
		action.moveToElement(priceLowToHigh).click().perform();
		driver.navigate().refresh();
	}

	/*
	 * This function is used to click the specific product.
	 */
	public void selectedSpecificProduct() {
		action.moveToElement(specificProduct).click().perform();
	}
}
