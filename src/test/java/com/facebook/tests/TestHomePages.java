/**
 * File Name: TestHomePages.java<br>
 * Jiadi, Wu<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: 2018Äê4ÔÂ4ÈÕ
 */
package com.facebook.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

import com.examples.cofig.*;
import com.examples.pages.*;

/**
 * TestHomePages //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Jiadi, Wu
 * @version 1.0.0
 * @since 1.0
 */
public class TestHomePages {

	GlobalDataStore gds = new GlobalDataStore();

	String GecKoDriver;

	String ChromeDriver;

	WebDriver driver = null;

	String HomePage;

	FaceBookHomePage FBPage;

	@AfterClass
	public void afterClass() {
		// close Fire fox
		this.driver.close();
	}

	/**
	 * @param args
	 */
	@Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("Firefox") String BrowserName) {// optional will
																// go to chrome
																// first and
																// then other
																// browser
		// String BrowserName = "fireFox";
		System.out.println(" The Browser Name " + BrowserName);
		this.gds.initParameters();
		this.GecKoDriver = GlobalDataStore.GeckoDriver_WIN;
		this.ChromeDriver = GlobalDataStore.ChromeDriver_WIN;
		this.HomePage = GlobalDataStore.HomePage;
		System.out.println("The HomePage " + this.HomePage);
		System.out.println(" The GeckoDriver " + this.GecKoDriver);
		if (BrowserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", this.GecKoDriver);
			this.driver = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", this.ChromeDriver);
			this.driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions(); // information box in
														 // the browser
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			this.driver = new ChromeDriver(options);
		}
		// else if (BrowserName.equalsIgnoreCase("safari")){driver=new
		// SafariDriver();driver.manage().timeouts().implicityWait(4,TimeUnit.seconds);}
	}

	@Test
	public void testFaceBookTitleOnPageLoad() {
		// String baseUrl = "http://facebook.com";
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";
		this.FBPage = new FaceBookHomePage(this.driver);
		this.FBPage.launchHomePage(this.HomePage);
		actualTitle = this.FBPage.getLoginTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	@Parameters({ "sUsername", "sPassword" })
	public void testUserLogin(String sUsername, String sPassword) {
		System.out.println(" The userName " + sUsername);
		System.out.println("The Password " + sPassword);
		this.FBPage = new FaceBookHomePage(this.driver);
		this.FBPage.launchHomePage(this.HomePage);
		this.driver.findElement(By.id("email")).sendKeys(sUsername);
		this.driver.findElement(By.id("pass")).sendKeys(sPassword);
		this.driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(sPassword);
		this.driver.findElement(By.name("email")).sendKeys(sUsername);
		this.driver.findElement(By.cssSelector("#email")).sendKeys(sUsername);
		this.driver.findElement(By.id("loginbutton")).click();
	}

	@Test
	@Parameters({ "sFirstName", "sLastName" })
	public void testUserRegistration(String sFirstName, String sLastName) {
		System.out.println(" The first Name " + sFirstName);
		System.out.println("The Password " + sLastName);
		this.FBPage = new FaceBookHomePage(this.driver);
		this.FBPage.launchHomePage(this.HomePage);
		this.FBPage = new FaceBookHomePage(this.driver);
		this.FBPage.launchHomePage(this.HomePage);
		this.driver.findElement(By.name("firstname")).sendKeys(sFirstName);
		this.driver.findElement(By.xpath("//input[@id='u_0_c']]")).sendKeys(sLastName);
		Select sell = new Select(this.driver.findElement(By.xpath("//select[@id='month']")));
		sell.selectByVisibleText("Mar");
		sell.selectByValue("7");
		sell.selectByIndex(6);
		// Select(driver.findElement(By.xpath(".//*[@id='day']")));
		// sel2.selectByValue("6");
		// Select sel3 = new
		// Select(driver.findElement(By.xpath(".//*[@id='year']")));
		// sel3.selectByIndex(4);
		this.driver.findElement(By.name("reg_email__"));
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		WebElement element =
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),' 'Female']")));
		element.click();
		WebElement signUp = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Create Account']")));
		signUp.click();
		// clicking the radio button rather than the text for Male
		// this.driver.findElement(By.xpath("//input[@type = 'radio' and @name =
		// 'sex' and @value = '2']")).click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(
		// driver.findElement(By.xpath(".//*[@id='reg_pages_msg']/a")).click();
		// driver.navigate().back();
	}

	@Test
	public void VerifyClickLink() {
		this.FBPage = new FaceBookHomePage(this.driver);
		this.FBPage.launchHomePage(this.HomePage);
		// this.driver.findElement(By.xpath("//a[@href='https://www.facebook.com/recover/initiate?lwv=110']")).click();
		this.driver.findElement(By.linkText("Forgot account?")).click();
		String actualTitle = this.FBPage.getLoginTitle();
		Assert.assertEquals(actualTitle, "Forgot Password | Can't Log In | Facebook");
	}

	@Test
	public void VerifyClickLinkText() {
		this.FBPage = new FaceBookHomePage(this.driver);
		this.FBPage.launchHomePage(this.HomePage);
		WebElement element = this.driver.findElement(By.xpath("//h2[contains(text(),'Sign Up')]"));
		String expectedText = "Sign Up";
		Assert.assertEquals(element.getText(), expectedText);
	}

	@Test
	public void verifyClickLinkText1() {
		this.FBPage = new FaceBookHomePage(this.driver);
		this.FBPage.launchHomePage(this.HomePage);
		WebElement element = this.driver.findElement(By.xpath("//h2[contains(text(),'Connect with friends')]"));
		String expectedText = "Connect with friends";
		boolean result = element.getText().contains(expectedText);
		System.out.println(result);
	}

	@Test
	public void verifyTextforCreateNewAccount() {
		this.FBPage = new FaceBookHomePage(this.driver);
		this.FBPage.launchHomePage(this.HomePage);
		WebElement element = this.driver.findElement(By.xpath("//h2[contains(text(),'Sign Up')]"));
		System.out.println("The text " + element.getText());
	}
}
