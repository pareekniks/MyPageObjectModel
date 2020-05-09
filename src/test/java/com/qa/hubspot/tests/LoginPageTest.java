package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest {
	BasePage basePage;
	Properties prop;
	WebDriver dr;
	LoginPage loginPage;

	@BeforeMethod
	public void setUP() {
		basePage = new BasePage();
		prop = basePage.intializeProp();
		String browser = prop.getProperty("browser");
		dr = basePage.initializeDriver(browser);
		dr.get(prop.getProperty("url"));
		loginPage = new LoginPage(dr);

	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		Assert.assertEquals(loginPage.getPageTile(), Constants.LOGIN_PAGE_TITLE, "Page Title mismatched");
	}

	@Test(priority = 2)
	public void verifysignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "SignUp link not visible");
	}

	@Test(priority = 3)
	public void loginTest() {
		System.out.println("credential are " + prop.getProperty("username") + "------" + prop.getProperty("password"));
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		dr.quit();
	}

}
