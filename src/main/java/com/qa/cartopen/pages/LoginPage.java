package com.qa.cartopen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.cartopen.utils.Constant;
import com.qa.cartopen.utils.Element_Util;

public class LoginPage {
	// Q: I have return for each class private webDriver driver reaons is ?
	// It is just for refernce only here that to private in nature
	// I tell u y ?
	// Because I don't want to use this Particular driver Out of this Particular
	// class
	// This is the Private driver of Particular class ... to perform any Action On
	// the page With the help Of webDriver

	// Note:-
	// When ever u creating any page class first thing u should the following
	// (1).Declare private driver
	// (2).Create page class constructor() and give driver when u creating the
	// object of this class
	// (3).Private By Locator's

	// (1).Private webDriver
	// This is the local driver of the class
	private WebDriver driver; // here driver is pointing null Only ....
								// When we creating an object for this class at that time It will point to
								// Chrome Browser

	private Element_Util eleUtil;

	/*
	 * Logic:- ------- What logic we are using here we are in_it() driver once At
	 * Driver_factory webriver driver=new ChromeDriver(); (or) driver=new
	 * RemoteWebDriver(); We call it into Our Base test so that we can use the same
	 * driver ref when we accessing properties of pages[Login Page,Search Page, ...]
	 * into Test Layer ...
	 * 
	 * we Can give multiple references for the Same Object, we have seen this
	 * concept in java If u rememeber ofcourse we can give when we discuss in Java
	 * Concepts
	 * 
	 */
	// (2).Private Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new Element_Util(driver);
	}

	// (3).By Locator's
	private By emailId = By.xpath("//input[@id='input-email']");
	private By password = By.xpath("//input[@name='password']");
	private By loginBtn = By.xpath("//input[@class='btn btn-primary' and @type='submit']");
	private By registerLink = By.xpath("(//a[text()='Register'])[2]");
	private By forgotPwdLink = By.xpath("//a[@class='list-group-item'][normalize-space()='Forgotten Password']");

	// (4).Page Actions:
	// ---------------
	public void doLogin(String userName, String pwd) {
		eleUtil.doSendkeys(emailId, userName);
		eleUtil.doSendkeys(password, pwd);
		eleUtil.doClick(loginBtn);
	}

	public String getLoginPageTitle() {
		return eleUtil.doGetTitle(Constant.LOGIN_PAGE_TITLE, Constant.DEFAULT_TIME_OUT);
	}

	public boolean getLoginPageUrl() {
		return eleUtil.waitForURLToBe(Constant.LOGIN_PAGE_URL_FRACTION, Constant.DEFAULT_TIME_OUT);
	}

	public boolean isRegisterLinkExist() {
		return eleUtil.doIsDisplayed(registerLink);
	}

	public boolean isForgotPasswordExist() {
		return eleUtil.doIsDisplayed(forgotPwdLink);
	}

}
