package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPageTest {
	public class HomePageTest {
		BasePage basePage;
		Properties prop;
		WebDriver dr;
		LoginPage loginPage;
		HomePage homePage;
		ContactsPage contactsPage;

		@BeforeMethod
		public void setUp() {
			basePage = new BasePage();
			prop = basePage.intializeProp();
			String browser = prop.getProperty("browser");
			dr = basePage.initializeDriver(browser);
			dr.get(prop.getProperty("url"));
			loginPage = new LoginPage(dr);
			homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
			contactsPage = homePage.navigateToContactsPage();

		}

		@Test (priority = 1)
		public void verifyContactsPageTitletest() {
			System.out.println("Contacts Page Title is " + contactsPage.getContactsPageTitle());
			Assert.assertEquals(contactsPage.getContactsPageTitle(), Constants.CONTACTS_PAGE_TITLE);
		}
		@DataProvider
		public Object[][] getContactData() {
			return ExcelUtil.getData(Constants.CONTACTS_SHEET_NAME);
		}

		@Test(priority = 2, dataProvider = "getContactData")
		public void createContactTest(String eMail, String firstName, String lastName, String jobTitle) {
			contactsPage.createContact(eMail,firstName,lastName,jobTitle);
		}


		@AfterMethod
		public void tearDown() {
			dr.quit();
		}



	}
}
