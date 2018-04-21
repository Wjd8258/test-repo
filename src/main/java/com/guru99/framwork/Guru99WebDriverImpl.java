/**
 * File Name: Guru99WebDriverImpl.java<br>
 * Jiadi, Wu<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: 2018Äê4ÔÂ14ÈÕ
 */
package com.guru99.framwork;

import java.net.*;
import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;

import com.examples.cofig.*;

/**
 * Guru99WebDriverImpl //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Jiadi, Wu
 */
public class Guru99WebDriverImpl implements Guru99WebDriver {

	/**
	 * @param args
	 */
	// TODO Auto-generated method stub
	WebDriver driver;

	/**
	 *
	 *
	 */
	@Override
	public void clickElement(WebElement element) {
		System.out.println("START: click Element value " + element);
		WebDriverWait wait = new WebDriverWait(this.driver, 15);
		try {
			// System.out.println("The element is " +element.getText());
			// Wait.someSec(GlobalDataStore.WAIT_TIME);
			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
			clickableElement.click();
		} catch (StaleElementReferenceException e) {
			System.out.println("Element  " + element.getText() + "Does not exist " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element  " + element.getText() + "Does not exist " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element does not exist " + e.getStackTrace());
		}
		System.out.println("END: click Element ");
	}

	/**
	 * @param homePageUserName
	 * @return
	 */
	public WebElement FindElement(By element) {
		System.out.println(" Coming in Find Element");
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// WebElement clickableElement =
		// wait.until(ExpectedConditions.elementToBeClickable(element));
		if (this.driver.findElement(element).isDisplayed()) {
			System.out.println("The element exists");
			return this.driver.findElement(element);
		} else {
			return null;
		}
	}

	/**
	 * @param homePageUserName
	 * @return
	 */
	/**
	 * @param string
	 */
	public void get(String string) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getElementText(By element) {
		try {
			if (this.driver.findElement(element).isDisplayed()) {
				System.out.println("The element exists");
				return this.driver.findElement(element).getText();
			}
		} catch (NoSuchElementException e) {
			e.getStackTrace();
		}
		return null;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void init(String Browser) {
		// Log.info("START:init Method for Getting the Proper Drivers for
		// Browser");
		System.out.println("The webDriver Init Method " + Browser);
		String UserDir = System.getProperty("user.dir");
		String OS = OSDetector();
		// Log.info("The OS Detetcted " + OS);
		if (Browser.equalsIgnoreCase("chrome") && (OS.equals("Mac"))) {
			System.setProperty("webdriver.chrome.driver", UserDir + GlobalDataStore.ChromeDriver_MAC);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			this.driver = new ChromeDriver(options);
		}
		if (Browser.equals("Chrome") && (OS.equals("Windows"))) {
			// Log.info("Windows chrome Browser ");
			System.setProperty("webdriver.chrome.driver", UserDir + GlobalDataStore.ChromeDriver_WIN);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			this.driver = new ChromeDriver(options);
		}
		if (Browser.equals("FireFox") || (Browser.equals("firefox"))) {
			System.out.println("Comming in FireFox ");
			if (OS.equals("Mac")) {
				System.out.println("In Fire fox Driver and Mac " + UserDir + GlobalDataStore.GeckoDriver_MAC);
				System.setProperty("webdriver.gecko.driver", UserDir + GlobalDataStore.GeckoDriver_MAC);
				this.driver = new FirefoxDriver();
			} else {
				System.out.println("In Fire fox Driver");
				System.setProperty("webdriver.gecko.driver", UserDir + GlobalDataStore.GeckoDriver_WIN);
				this.driver = new FirefoxDriver();
			}
		}
		if (Browser.equalsIgnoreCase("Edge")) {
			System.out.println("In Edge Driver");
			// String serverPath = "C:\\Program Files (x86)\\Microsoft Web
			// Driver\\MicrosoftWebDriver.exe";
			// System.setProperty("webdriver.edge.driver", UserDir +
			// GlobalDataStore.EDGE_DRIVER);
			this.driver = new EdgeDriver();
		}
		// Log.info("END:init Method for Getting the Proper Drivers for
		// Browser");
		System.out.println("END:The webDriver Init Method");
	}

	/**
	 * @see com.guru99.framwork.Guru99WebDriver#intSauceLabs(java.lang.String)
	 */
	@Override
	public void intSauceLabs(String Chrome) throws MalformedURLException {
		// TODO Auto-generated method stub
	}

	@Override
	public Boolean navigateTo(final String urlString) {
		Boolean mainPageFound = false;
		try {
			System.out.println("The Navigate URL " + urlString);
			String navigateUrl;
			navigateUrl = urlString;
			// PageFactory.initElements(driver, TMXWebDriverImpl.class);
			this.driver.get(navigateUrl);
			this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String CurrrentUrl = getCurrentUrl();
			// String redirectedUrl = "";
			this.driver.manage().window().maximize();
			if (CurrrentUrl != null)
				mainPageFound = true;
			// Log.info("END: The navigateTo Method ");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return mainPageFound;
	}

	// detect your operating system
	public String OSDetector() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return "Windows";
		} else if (os.contains("nux") || os.contains("nix")) {
			return "Linux";
		} else if (os.contains("mac")) {
			return "Mac";
		} else if (os.contains("sunos")) {
			return "Solaris";
		} else {
			return "Other";
		}
	}

	/**
	 *
	 */
	public void quitDriver() {
		// TODO Auto-generated method stub
		if (this.driver != null) {
			this.driver.quit();
			this.driver = null;
		}
	}

	/**
	 * @return
	 */
	private String getCurrentUrl() {
		// TODO Auto-generated method stub
		String currentUrl = this.driver.getCurrentUrl();
		return currentUrl;
	}
}
