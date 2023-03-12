package org.flipkart.pages;

import org.application.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class is used for specific product related information and functions to
 * process the same to the cart.
 * 
 * @author jyoti
 *
 */
public class ProductSpecificPage extends Base {

	@FindBy(xpath = "//li[@id='swatch-0-size']")
	WebElement productSizeSelect;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement addToCart;

	@FindBy(xpath = "//span[@class='G6XhRU']")
	WebElement brand;

	@FindBy(xpath = "//span[@class='B_NuCI']")
	WebElement product;

	@FindBy(xpath = "//div[@class='_30jeq3 _16Jk6d']")
	WebElement price;

	@FindBy(xpath = "//a[@class='_3SkBxJ']")
	WebElement cart;

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
	public ProductSpecificPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * This function is used to select the size for the product.
	 */
	public void productSizeSelect() throws InterruptedException {
		Thread.sleep(2000);
		productSizeSelect.click();
	}

	/*
	 * This function is used to add the product to the cart and returns the brand name ,product
	 * name and price in pipe delimited format.
	 * 
	 * @return brandName+productName|priceValue
	 */
	public String addTocartScreen() {
		addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();
		brandName = brand.getText();
		System.out.println(brandName);
		productName = product.getText();
		System.out.println(productName);
		priceValue = price.getText();
		System.out.println(priceValue);
		return brandName + productName + "|" + priceValue;
	}

	/*
	 * This function is used to click on cart icon .
	 */
	public void cartIconClick() {
		cart = wait.until(ExpectedConditions.elementToBeClickable(cart));
		cart.click();
	}
}
