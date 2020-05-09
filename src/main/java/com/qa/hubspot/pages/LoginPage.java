package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class LoginPage extends BasePage {
	WebDriver dr;
	By eMailId = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");
	By signUpLink = By.partialLinkText("Sign up");
	ElementUtil elementUtil;

	public LoginPage(WebDriver dr) {
		this.dr = dr;
		elementUtil = new ElementUtil(dr);
		elementUtil.waitForTitlePresent(Constants.WAIT_TIME, Constants.LOGIN_PAGE_TITLE);
	}

	public String getPageTile() {

		String title = elementUtil.waitForTitlePresent(Constants.WAIT_TIME, Constants.LOGIN_PAGE_TITLE);
		return title;
	}

	public boolean verifySignUpLink() {
		return elementUtil.isElementDisplayed(signUpLink);
	}

	public HomePage doLogin(String username, String pwd) {
		elementUtil.doSendKeys(eMailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		//	elementUtil.waitForTitlePresent(Constants.WAIT_TIME, Constants.HOME_PAGE_TITLE);
		return new HomePage(dr);

	}

}
