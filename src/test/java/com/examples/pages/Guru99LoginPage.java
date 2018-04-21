/**
 * File Name: Guru99LoginPage.java<br>
 * Jiadi, Wu<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: 2018Äê4ÔÂ14ÈÕ
 */
package com.examples.pages;

/**
 * Guru99LoginPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Jiadi, Wu
 * @version 1.0.0
 * @since 1.0
 */
public class Guru99LoginPage {

	public void clickLogin() {
		// driver.FindElement(login).click();
		driver.clickElement(driver.FindElement(login));
	}

	/**
	 * @param args
	 */
	public void LoginToGuru99(String strUserName, String strPassword) {
		// TODO Auto-generated method stub
		this.setUserName(strUserName);
		this.setPassword(strPassword);
		this.clickLogin();
	}

	/**
	 *
	 */
	private void clickLogin() {
		// TODO Auto-generated method stub
	}

	/**
	 * @param strPassword
	 */
	private void setPassword(String strPassword) {
		// TODO Auto-generated method stub
		driver.sendKeys(driver.FindElement(user99GuruName), strPassword);
	}

	// Click on login button
	/**
	 * @param strUserName
	 */
	private void setUserName(String strUserName) {
		// TODO Auto-generated method stub
		driver.sendKeys(driver.FindElement(password99Guru), strUserName);
	}
}
