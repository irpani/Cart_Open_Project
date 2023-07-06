package com.qa.cartopen.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.cartopen.factory.Driverfactory;
import com.qa.cartopen.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	Driverfactory df;
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;

	@BeforeTest
	public void setup() {
		df = new Driverfactory();
		prop = df.init_prop();
		WebDriverManager.firefoxdriver().setup();
		// driver = df.init_driver("firefox");// here now u can pass prop reference
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
