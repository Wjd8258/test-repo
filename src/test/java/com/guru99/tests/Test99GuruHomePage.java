/**
 * File Name: Test99GuruHomePage.java<br>
 * Jiadi, Wu<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: 2018Äê4ÔÂ14ÈÕ
 */
package com.guru99.tests;

import java.net.*;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import com.examples.cofig.*;
import com.examples.pages.*;
import com.guru99.framwork.*;

/**
 * Test99GuruHomePage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Jiadi, Wu
 * @version 1.0.0
 * @since 1.0
 */
public class Test99GuruHomePage {

	/**
	 * @param args
	 */
	final static Logger logger = Logger.getLogger("GURU99_TESTS");

	Guru99WebDriverImpl driver;

	GlobalDataStore gds = new GlobalDataStore();

	String BankHomePages;

	Guru99LoginPage objLogin;

	Boolean HomePageLaunch = false;

	By homePageUserName = By.xpath("//h2[@class='barone']");

	By seleniumButtonName = By.xpath("//li[@class='dropdown']//a[@href='#']");

	Guru99HomePage objHomePage;

	@Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("FireFox") String BrowserName) throws MalformedURLException {
		logger.info("START: In set-up Method");
		GlobalDataStore.setLogCategory("GURU99_TESTS");
		this.gds.initParameters();
		// calls the init Method in getWebDriverInstance and gets the
		// WebDriverImpl Object driver..
		this.driver = Guru99WebDriverFactory.getWebDriverInstance(BrowserName);
		String BankHomePage = GlobalDataStore.Guru99HomePage;
		this.HomePageLaunch = this.driver.navigateTo(BankHomePage);
		this.objHomePage = new Guru99HomePage();
		// this.driver.get("http://demo.guru99.com/V4/");
		// this.objHomePage = new Guru99HomePage();
		this.objHomePage.setLogCategory("GURU99_TESTS");     // setLogCategory
														     // first and then
														     // setWebDriver
		this.objHomePage.setWebDriver(this.driver);
		logger.info("END: In set-up Method");
	}

	@AfterClass
	public void tearDown() {
		// close Fire fox
		this.driver.quitDriver();  // quitDriver is a method in the
									  // implementation
	}

	@Test
	public void test_Home_Page_Dashboard_clickSeleniumDropdownList() {
		if (this.HomePageLaunch == true) {
			this.objHomePage.clickSeleniumDropdownOnPage();
			this.objHomePage.checkSeleniumSelectElementFromDropDown("Flash");
		}
	}

	// logger.info("END: test_Home_Page_DashBoard_UserName");
	// Assert.assertTrue(this.objHomePage.getHomePageDashboardUserName().toLowerCase().contains("managerid
	// : mgr123"));
	@Test
	public void test_Home_Page_DashBoard_StepsGenerateAccess() {
		logger.info("START: Steps_To_Generate_Access");
		this.objHomePage.setLogCategory("GURU99_TESTS");
		if (this.HomePageLaunch == true) {
			String GenerateAccessTitle = this.objHomePage.getGenerateAccess();
			logger.info(" The Generate Access Title " + GenerateAccessTitle);
			Assert.assertTrue(GenerateAccessTitle.toLowerCase().contains("steps to generate access"));
		}
	}

	//
	// * This Test verifies the DashBoard Page...It confirms that Page is
	// launched successfully.
	// *
	// */
	@Test
	public void test_Home_Page_DashBoard_UserName() {
		logger.info("START: test_Home_Page_DashBoard_UserName");
		this.objHomePage.setLogCategory("GURU99_TESTS");
		if (this.HomePageLaunch == true) {
			String loginPageTitle = this.objHomePage.getHomePageDashboardUserName();
			logger.info(" The login Title " + loginPageTitle);
			Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		}
	}
}
/**
 *
 */
