package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver dr;
	Properties prop;
	/**
	 * This method returns browser
	 * @param browserName
	 * @return Driver
	 */

	public WebDriver initializeDriver(String browserName) {

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			dr = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			dr = new FirefoxDriver();
		}

		else {
			System.out.println(browserName + "Browser value wrong, pass the correct browser name");
		}
		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
		return dr;
	}
	/**
	 * This method return prop and read properties from config file
	 * @return Properties
	 */

	public Properties intializeProp() {

		prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream("C:\\Users\\nikhilpareek\\eclipse-workspace\\POMSeries\\src\\main\\java\\"+
					"com\\qa\\hubspot\\config\\config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Properties could not be loaded " + e.getMessage());
		}
		return prop;

	}
}
