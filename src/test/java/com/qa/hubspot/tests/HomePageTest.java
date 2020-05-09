package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {
	BasePage basePage;
	Properties prop;
	WebDriver dr;
	LoginPage loginPage;
	HomePage homePage;
	SoftAssert st;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.intializeProp();
		String browser = prop.getProperty("browser");
		dr = basePage.initializeDriver(browser);
		dr.get(prop.getProperty("url"));
		loginPage = new LoginPage(dr);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		System.out.println("Home Page Title is" + homePage.getHomePageTitle());
		Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE, "Home page Title is missing");
	}

	@Test(priority = 2)
	public void verifyHomepageHeaderTest() {
		Assert.assertTrue(homePage.isHeaderPresent(), "Home page Header is not present");
		System.out.println("Home Page Header is" + homePage.getHomePageHeaderValue());
		Assert.assertEquals(homePage.getHomePageHeaderValue(), Constants.HOME_PAGE_HEADER,
				"Home Page header not matched");
	}

	@Test(priority = 3)
	public void verifyLoggedInUserTest() {
		Assert.assertTrue(homePage.isAccountNamePresent(), "Account name not present");
		System.out.println("The account name is" + homePage.getAccountNameValue());
		Assert.assertEquals(homePage.getAccountNameValue(), prop.getProperty("accountname"));
	}

	@AfterMethod
	public void tearDown() {
		dr.quit();
	}

}
