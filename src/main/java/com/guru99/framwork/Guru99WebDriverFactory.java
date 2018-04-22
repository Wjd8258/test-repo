/**
 * File Name: Guru99WebDriverFactory.java<br>
 * Jiadi, Wu<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: 2018Äê4ÔÂ14ÈÕ
 */
package com.guru99.framwork;

import java.net.*;

/**
 * Guru99WebDriverFactory //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Jiadi, Wu
 * @version 1.0.0
 * @since 1.0
 */
public class Guru99WebDriverFactory {

	/**
	 * @param browserName
	 * @return
	 */
	public static Guru99WebDriverImpl getWebDriverInstance(String BrowserName) throws MalformedURLException {
		Guru99WebDriverImpl webDriver = new Guru99WebDriverImpl();
		webDriver.init(BrowserName);
		// webDriver.intSauceLabs(BrowserName);
		// webDriver.init(BrowserName);
		return webDriver;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
