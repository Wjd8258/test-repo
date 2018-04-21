/**
 * File Name: FaceBookHomePage.java<br>
 * Jiadi, Wu<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: 2018Äê4ÔÂ4ÈÕ
 */
package com.examples.pages;

import org.openqa.selenium.*;

/**
 * FaceBookHomePage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Jiadi, Wu
 * @version 1.0.0
 * @since 1.0
 */
public class FaceBookHomePage {

	WebDriver driver;

	public FaceBookHomePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return
	 */
	public String getLoginTitle() {
		// TODO Auto-generated method stub
		return this.driver.getTitle();
	}

	public void launchHomePage(String HomePage) {
		this.driver.get(HomePage);
		this.driver.manage().window().maximize();
	}
}
