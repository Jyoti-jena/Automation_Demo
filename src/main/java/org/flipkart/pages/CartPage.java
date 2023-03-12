package org.flipkart.pages;

import org.application.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class is used to get the complete information of the product with the
 * price details in screen.
 * 
 * 
 * @author jyoti
 *
 */
public class CartPage extends Base {

	@FindBy(xpath = "//a[@class='_2Kn22P gBNbID']")
	WebElement productNameCart;

	@FindBy(xpath = "//span[@class='_2-ut7f _1WpvJ7']")
	WebElement priceCart;

	String brandName = null;
	String productName = null;
	String priceValue = null;

	/*
	 * This function is used to initialize web elements.
	 */
	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * This function is used to get the product details and returns the product name
	 * and price in pipe delimited format.
	 * 
	 * @return productName|priceValue
	 */
	public String cartDetails() {
		productName = productNameCart.getText();
		System.out.println(productName);
		priceValue = priceCart.getText();
		System.out.println(priceValue);
		return productName + "|" + priceValue;

	}
}
