/**
 * File Name: FirefoxTest.java<br>
 * Jiadi, Wu<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: 2018Äê4ÔÂ4ÈÕ
 */
package com.facebook.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

import com.examples.cofig.*;

/**
 * FirefoxTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Jiadi, Wu
 * @version 1.0.0
 * @since 1.0
 */
public class FirefoxTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		basicTest();
	}

	/**
	 *
	 */
	private static void basicTest() {
		// TODO Auto-generated method stub
		GlobalDataStore gds = new GlobalDataStore();
		gds.initParameters();
		String GecKoDriver = GlobalDataStore.GeckoDriver_WIN;
		String HomePage = GlobalDataStore.HomePage;
		System.setProperty("the home page", HomePage);
		System.setProperty("webdriver.gecko.driver", GecKoDriver);
		// System.setProperty("webdriver.gecko.driver",
		// "drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://facebook.com";
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";
		// launch fire fox and direct it to the base url
		driver.get(baseUrl);
		// get the actual value of the title
		actualTitle = driver.getTitle();
		actualTitle = actualTitle.trim();
		System.out.println("The actual Title" + actualTitle);
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Faild");
		}
		// close Fire Fox
		driver.close();
	}
}
