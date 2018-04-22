/**
 * File Name: Global.java<br>
 * Jiadi, Wu<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: 2018Äê4ÔÂ4ÈÕ
 */
package com.examples.cofig;

import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 * Global //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Jiadi, Wu
 * @version 1.0.0
 * @since 1.0
 */
public class GlobalDataStore {

	public static Logger logger;

	public static String LogCategory;

	public static String Guru99HomePage;

	public static String HomePage;

	public static String GeckoDriver_WIN;

	public static String ChromeDriver_WIN;

	public static String ChromeDriver_MAC;

	public static String GeckoDriver_MAC;
	// public static String GeckoDriver_MAC;

	public static String UserName;

	public static String Password;

	/**
	 * @param string
	 */
	public static void setLogCategory(String LogFile) {
		// TODO Auto-generated method stub
		LogCategory = LogFile;
		logger = Logger.getLogger(LogCategory);//
	}

	String baseDir = System.getProperty("user.dir");

	String propFile = "selenium.properties";

	FileInputStream fis = null;

	private Properties configFile = new Properties();

	public void initParameters() {
		// logger.info("START:Global Data Store initParameters Method");
		String baseDir = System.getProperty("user.dir");
		System.out.println(" The base Dir " + baseDir);
		String propFile = "selenium.properties";
		FileInputStream fis = null;
		// public static String HomePage;
		try {
			fis = new FileInputStream(baseDir + "/" + "src/test/resources/" + propFile);
			this.configFile.load(fis);
			GeckoDriver_WIN = this.configFile.getProperty("GECKO_DRIVER_WIN");
			ChromeDriver_WIN = this.configFile.getProperty("CHROME_DRIVER_WIN");
			GeckoDriver_MAC = this.configFile.getProperty("GECKO_DRIVER_MAC");
			ChromeDriver_MAC = this.configFile.getProperty("CHROME_DRIVER_MAC");
			System.out.println("The GeckoDriver in GDS " + GeckoDriver_WIN);
			HomePage = this.configFile.getProperty("BASE_URL");
			Guru99HomePage = this.configFile.getProperty("GURU99_HOMEPAGE");
			UserName = this.configFile.getProperty("USERNAME");
			Password = this.configFile.getProperty("PASSWORD");
		} catch (FileNotFoundException e) {
			System.out.println("File not Found" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exception " + e.getMessage());
		}
	}
}
