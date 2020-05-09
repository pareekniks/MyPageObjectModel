package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {

	WebDriver dr;
	By header = By.xpath("//span/h1");
	By accountName = By.xpath("//span[@class='account-name ']");
	By contactMenu = By.id("nav-primary-contacts-branch");
	By contactLink = By.id("nav-secondary-contacts");
	ElementUtil elementUtil;

	public HomePage(WebDriver dr) {
		this.dr = dr;
		elementUtil = new ElementUtil(dr);
		elementUtil.waitForElementPresent(Constants.WAIT_TIME, accountName);
	}

	public String getHomePageTitle() {
		return elementUtil.waitForTitlePresent(Constants.WAIT_TIME, Constants.HOME_PAGE_TITLE);
	}

	public boolean isHeaderPresent() {
		elementUtil.waitForElementPresent(Constants.WAIT_TIME, header);
		return elementUtil.isElementDisplayed(header);
	}

	public String getHomePageHeaderValue() {
		return elementUtil.getElementText(header);
	}

	public boolean isAccountNamePresent() {
		return elementUtil.isElementDisplayed(accountName);
	}

	public String getAccountNameValue() {
		return elementUtil.getElementText(accountName);

	}

	public ContactsPage navigateToContactsPage() {
		elementUtil.waitForElementPresent(Constants.WAIT_TIME, contactMenu);
		elementUtil.doClick(contactMenu);
		elementUtil.waitForElementPresent(Constants.WAIT_TIME, contactLink);
		elementUtil.doClick(contactLink);
		return new ContactsPage(dr);
	}

}
