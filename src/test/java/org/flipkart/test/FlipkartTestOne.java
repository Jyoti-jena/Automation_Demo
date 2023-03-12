package org.flipkart.test;

import org.flipkart.pages.ProductSpecificPage;
import org.application.base.Base;
import org.flipkart.pages.BabyAndKidsPage;
import org.flipkart.pages.CartPage;
import org.flipkart.pages.FlipkartHomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class is used to test Flipkart operations starting from home to
 * check-out screen.
 * 
 * @author jyoti
 *
 */
public class FlipkartTestOne extends Base {

	String productWindowDetail = null;
	String productCartDetail = null;
	FlipkartHomePage home;
	BabyAndKidsPage babyAndKids;
	ProductSpecificPage productSpPage;
	CartPage cart;

	/*
	 * This function is used to launch the application and instantiate the
	 * FlipkartHomePage,BabyAndKidsPage and ProductSpecificPage page object.
	 */
	@BeforeMethod
	public void flipkartApplication() {

		launchApplication("chrome", "https://www.flipkart.com/");
		home = new FlipkartHomePage();
		babyAndKids = new BabyAndKidsPage();
		productSpPage = new ProductSpecificPage();
		cart = new CartPage();

	}

	/*
	 * This function is used to run the test on flipkart application starting from
	 * home to cart in specfic order and validate the price and name of selected
	 * product in product screen with price and product name from checkout screen.
	 */
	@Test
	public void runAutomation() throws InterruptedException {
		home.popupClose();
		home.goToFashionMenu();
		babyAndKids.babyAndKidsSection();
		babyAndKids.babyDressAndSKirtsSection();
		babyAndKids.priceLowToHighFilter();
		babyAndKids.selectedSpecificProduct();
		browserWindow();

		productSpPage.productSizeSelect();
		productWindowDetail = productSpPage.addTocartScreen();
		System.out.println("+++++++++" + productWindowDetail);
		System.out.println(productWindowDetail);
		productSpPage.cartIconClick();
		productCartDetail = cart.cartDetails();
		System.out.println("+++++++++" + productCartDetail);
		String[] actual = productWindowDetail.split("\\|");
		String[] expected = productCartDetail.split("\\|");

		/*
		 * As mentioned in the document to verify only, I have commented the assert code
		 * for your reference .
		 *
		 * Assert.assertEquals(actual[0], expected[0]); Assert.assertEquals(actual[1],
		 * expected[1]);
		 */

		if (actual[0].trim().equals(expected[0].trim())) {
			System.out.println("Product name is matching");
		} else {
			System.out.println("Product name is not matching");
		}
		if (actual[1].trim().equals(expected[1].trim())) {
			System.out.println("Price is matching");
		} else {
			System.out.println("Price is not matching");
		}

	}

	/*
	 * This function is used to quit the browser after execution.
	 */
	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
