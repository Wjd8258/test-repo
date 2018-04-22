/**
 * File Name: Guru99WebDriver.java<br>
 * Jiadi, Wu<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: 2018Äê4ÔÂ14ÈÕ
 */
package com.guru99.framwork;

import java.net.*;

import org.openqa.selenium.*;

/**
 * Guru99WebDriver //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Jiadi, Wu
 * @version 1.0.0
 * @since 1.0
 */
public interface Guru99WebDriver {

	void clickElement(WebElement element);

	String getElementText(By element);

	void init(String Browser);

	void intSauceLabs(String Chrome) throws MalformedURLException;

	/**
	 * @param urlString
	 * @return
	 */
	Boolean navigateTo(String urlString);
}
