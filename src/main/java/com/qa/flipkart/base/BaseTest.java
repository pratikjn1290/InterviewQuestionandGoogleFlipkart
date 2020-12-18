package com.qa.flipkart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.flipkart.pages.GoogleResultPage;
import com.qa.flipkart.pages.GoogleSearch;

public class BaseTest {

	public BasePage basePage;
	public Properties prop;
	public GoogleSearch googleSearch;
	public GoogleResultPage googleResultPage;
	public WebDriver driver;

	/*
	 * This methos open the browser window and open the URL
	 * 
	 */

	@BeforeTest
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		googleSearch = new GoogleSearch(driver);
		googleResultPage = new GoogleResultPage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
