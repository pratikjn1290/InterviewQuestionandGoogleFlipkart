package com.qa.flipkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.flipkart.base.BasePage;

public class GoogleSearch extends BasePage {

	private WebDriver driver;

	private By searchField = By.xpath("//input[@name = 'q']");
	private By searchResultList = By
			.xpath("//div[@class = 'aajZCb']/ul[@class = 'erkvQe']/li//div[@class = 'sbl1']/span");

	/*
	 * This method accepts search criteria and returns next landing page
	 */

	public GoogleSearch(WebDriver driver) {
		this.driver = driver;
	}

	public String getGoogleTitle() {
		return driver.getTitle();
	}

	public GoogleResultPage searchCriteria(String search) throws InterruptedException {
		driver.findElement(searchField).sendKeys(search.toLowerCase());
		List<WebElement> searchResult = driver.findElements(searchResultList);
		for (int i = 0; i <= searchResult.size(); i++) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfAllElements(searchResult));
			wait.ignoring(StaleElementReferenceException.class);
			String value = searchResult.get(i).getText();
			System.out.println("Search result: " + value);
			if (value.equalsIgnoreCase(search)) {
				searchResult.get(i).click();
				Thread.sleep(3000L);
				break;
			}
		}

		return new GoogleResultPage(driver);
	}

}
