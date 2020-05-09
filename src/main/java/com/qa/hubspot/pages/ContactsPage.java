package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage {

	WebDriver dr;
	ElementUtil elmentUtil;
	By createContactButton = By.xpath("//button/span/span[text()= 'Create contact']");
	By createContactFormButton = By.xpath("(//span[text()= 'Create contact'])[2]");
	By eMailInput = By.name("textInput");
	By firstNameInput = By.xpath("//input[@data-field='firstname']");
	By lastNameInput = By.xpath("//input[@data-field='lastname']");
	By jobTitleInput = By.xpath("//input[@data-field='jobtitle']");

	public ContactsPage(WebDriver dr) {
		this.dr = dr;
		elmentUtil = new ElementUtil(dr);

	}

	public String getContactsPageTitle() {
		return elmentUtil.waitForTitlePresent(Constants.WAIT_TIME, Constants.CONTACTS_PAGE_TITLE);
	}

	public void createContact(String email, String firstName, String lastname, String jobtitle) {
		elmentUtil.waitForElementPresent(Constants.WAIT_TIME, createContactButton);
		elmentUtil.doClick(createContactButton);
		elmentUtil.waitForElementPresent(Constants.WAIT_TIME, eMailInput);
		elmentUtil.doSendKeys(eMailInput, email);
		elmentUtil.waitForElementPresent(Constants.WAIT_TIME, firstNameInput);
		elmentUtil.doSendKeys(firstNameInput, firstName);
		elmentUtil.waitForElementPresent(Constants.WAIT_TIME, lastNameInput);
		elmentUtil.doSendKeys(lastNameInput, lastname);
		elmentUtil.waitForElementPresent(Constants.WAIT_TIME, jobTitleInput);
		elmentUtil.doActionSendKeys(jobTitleInput, jobtitle);
		//elmentUtil.doSendKeys(jobTitleInput, jobtitle);
		elmentUtil.waitForElementPresent(Constants.WAIT_TIME, createContactFormButton);
		elmentUtil.doActionsClick(createContactFormButton);
		//elmentUtil.doClick(createContactFormButton);
	}
}
