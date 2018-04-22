/**
 * File Name: Guru99HomePage.java<br>
 * Jiadi, Wu<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: 2018Äê4ÔÂ14ÈÕ
 */
package com.examples.pages;

import java.util.logging.*;

import org.openqa.selenium.*;

import com.guru99.framwork.*;

/**
 * Guru99HomePage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Jiadi, Wu
 * @version 1.0.0
 * @since 1.0
 */
public class Guru99HomePage {

	public static Logger logger;

	public static String LogCategory;

	private Guru99WebDriverImpl driver;

	By homePageUserName = By.xpath("//h2[@class='barone']");

	By GenerateAccessName = By.xpath("//span[@style='font-size:18px;font-weight: 700;']"); //

	By seleniumButtonName = By.xpath("//ul[@class='nav navbar-nav']/li[1]");

	By siblingButtonName = By.xpath("//ul[@class='nav navbar-nav']/li[1]/following::li"); // find
																							 // the
																							 // following
																							 // sibling
																							 // will
																							 // not
																							 // count
																							 // the
																							 // first
																							 // one

	/**
	 * @param string
	 */
	/**
	 *
	 */
	public void checkSeleniumSelectElementFromDropDown(String Text) {
		// TODO Auto-generated method stub
		String Path = "//ul[@class='nav navbar-nav']/li[1]/ul//a[contains(text()," + "'" + Text + "'" + ")]";
		By checkText = By.xpath(Path);
		WebElement element = this.driver.FindElement(checkText);
		this.driver.clickElement(element);
	}

	/**
	 * @param string
	 */
	/**
	 * @return
	 */
	public void clickSeleniumDropdownOnPage() {
		logger.info("START: Selenium_DropdownOnPage");
		WebElement element = this.driver.FindElement(this.seleniumButtonName);
		this.driver.clickElement(element);
	}

	/**
	 * @return
	 */
	public String getGenerateAccess() {
		// TODO Auto-generated method stub
		return this.driver.FindElement(this.GenerateAccessName).getText();
	}

	/**
	 * @param driver2
	 */
	public String getHomePageDashboardUserName() {
		// logger.info("START: getHomePageDashboardUserName");
		System.out.println("comming here");
		// System.out.println(" The Text
		// "+driver.FindElement(homePageUserName).getText());
		// logger.info("END: getHomePageDashboardUserName");
		return this.driver.FindElement(this.homePageUserName).getText();
		// return driver.getElementText(homePageUserName);
	}

	/**
	 * @return
	 */
	public Object getSeleniumButton() {
		// TODO Auto-generated method stub
		return this.driver.FindElement(this.seleniumButtonName).getText();
	}

	/**
	 * @param string
	 */
	public void setLogCategory(String LogFile) {
		// TODO Auto-generated method stub
		LogCategory = LogFile;
		logger = Logger.getLogger(LogCategory);//
	}

	/**
	 * @param args
	 */
	// TODO Auto-generated method stub
	public void setWebDriver(Guru99WebDriverImpl webDriver) {
		logger.info("START:Set webDriver");
		this.driver = webDriver;
		logger.info("END:Set WebDriver");
	}
}
