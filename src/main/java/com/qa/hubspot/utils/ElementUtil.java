package com.qa.hubspot.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;
	Actions act;

	public ElementUtil(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);

		} catch (Exception e) {
			System.out.println("some exception occured, while creating webelment");
			System.out.println(e.getMessage());
		}
		return element;

	}

	public void doActionSendKeys(By locator, String value) {
		try {
			Actions act = new Actions(driver);
			act.sendKeys(getElement(locator), value);
			act.build().perform();
			//element.sendKeys(value);

		} catch (Exception e) {
			System.out.println("some exception occured, while sending values");
			System.out.println(e.getMessage());
		}

	}

	public void doSendKeys(By locator, String value) {
		try {
			WebElement element = getElement(locator);
			element.sendKeys(value);

		} catch (Exception e) {
			System.out.println("some exception occured, while sending values");
			System.out.println(e.getMessage());
		}

	}

	public void doClick(By locator) {
		try {

			WebElement element = getElement(locator);
			element.click();
		} catch (Exception e) {
			System.out.println("some exception occured, while clicking webelment");
			System.out.println(e.getMessage());
		}
	}

	public void doActionsClick(By locator) {
		try {

			Actions act = new Actions(driver);
			act.click(getElement(locator));
			act.build().perform();
		} catch (Exception e) {
			System.out.println("some exception occured, while clicking webelment");
			System.out.println(e.getMessage());
		}
	}

	public void waitForElementPresent(int time, By locator) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, time);
			wt.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("some exception occured, while waiting webelment");
			System.out.println(e.getMessage());
		}
	}

	public String waitForTitlePresent(int time, String title) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, time);
			wt.until(ExpectedConditions.titleContains(title));
			return title;
		} catch (Exception e) {
			System.out.println("some exception occured, while waiting for title");
			System.out.println(e.getMessage());
			return null;
		}

	}

	public boolean isElementDisplayed(By locator) {
		try {
			getElement(locator).isDisplayed();
			return true;
		} catch (Exception e) {
			System.out.println("some exception occured, while finding the webelment");
			System.out.println(e.getMessage());
			return false;
		}

	}


	public String getElementText(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception occured, while finding the title");
			System.out.println(e.getMessage());
			return null;
		}
	}

}
