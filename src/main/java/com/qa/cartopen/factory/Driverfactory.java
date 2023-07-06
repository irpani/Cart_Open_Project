package com.qa.cartopen.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

//Short Cut to Write JavaDoc
// _________  SHIFT +ALT +J _______ 
//(or)
// ==>   /**  then Clicked On Enter 

/**
 * This method is used to Initialize the WebDriver
 * 
 * @param Browser_Name
 * @return => this will return the driver
 *
 */
public class Driverfactory {

	public WebDriver driver;
	public Properties prop; // Declare class Ref here

	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		if (browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("Opera")) {
			driver = new OperaDriver();
		}

		else {
			System.out.println("User Not Enter the Righr Browser" + browserName);

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;

	}

	// Q:How we can read properties from Config.properties?

	// *********Remember One thing*************
	// To initialize the config.properties we need one class in java Create the
	// Object of
	// Properties class first
	/**
	 * 
	 * This method is used to initialize the Properties
	 * 
	 * @retun this will return properties prop reference ....
	 */

	public Properties init_prop() {

		prop = new Properties(); // As per above statement Object got created .....

		// where exactly your config.properties available ... take that path
		// here you must give the file path
		// This fileinput stream ask us to add try catch block
		try {
			FileInputStream ip = new FileInputStream("src\\test\\resources\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}

}
