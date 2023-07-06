package com.qa.cartopen.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.cartopen.utils.Constant;

//Note:-
// ------
//Remember u didn't write anything related to driverApi  in testclasses
//Always remember Assertion should be retun in testlayer

public class LoginPageTest extends BaseTest {

	// This is my first TestCase so write as ====> @Test
	/*
	 * @Test public void loginPageTitleTest() {
	 * 
	 * // I don't want to write driver.getTitle() once again here I will call all
	 * the // properties from Loginpage ,...y ??? // // Becase According to Page
	 * Object Model Should not write your driver api's in // testlayer U just call
	 * from page class to access the proerties
	 * 
	 * // Q: where Should I create Object for login Page class?????? // Shall I
	 * create Here ? // (A):-If I'm create here then another test class also //
	 * [vvimp Point] "I have keep Creating Of Object of Login Page class when ever
	 * // required" Not a good process Unnecessary memory wastage ....
	 * 
	 * // Better I will go to Base test,BaseTest is my Super class of all the Test
	 * // classes // Then I will maintain the Login page reference here ....
	 * 
	 * // System.out.println("Actual title is " + getTitle); String actTitle =
	 * loginpage.getLoginPageTitle(); System.out.println("Page title is" +
	 * actTitle); } Assert.assertEquals(actTitle, Constant.LOGIN_PAGE_TITLE);
	 */

	@Test(priority = 1)
	public void loginPageUrlTest() {
		Assert.assertTrue(loginPage.getLoginPageUrl());
	}

	// Assserttrue I have given DIRECTLY here
	@Test(priority = 2)
	public void ForgotPwdLinkExist() {
		Assert.assertTrue(loginPage.isForgotPasswordExist());

	}

	@Test(priority = 3)
	public void RegLInkExist() {

		Assert.assertTrue(loginPage.isRegisterLinkExist());

	}

	@Test(priority = 4)
	public void loginTest() {

		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

	}

	// This testcase we did n't Assert yet ,On what Basis we have to asser it ...
	// ?????
	// That also we have to check ...
	@Test(priority = 5)
	public void getloginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("Actual Title is.." + actTitle);// I'm getting a title how can I verify
		Assert.assertEquals(actTitle, Constant.LOGIN_PAGE_TITLE);
	}
}