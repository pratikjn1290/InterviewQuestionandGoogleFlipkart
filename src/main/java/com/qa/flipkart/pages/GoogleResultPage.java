package com.qa.flipkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.flipkart.base.BasePage;

public class GoogleResultPage extends BasePage {

	private WebDriver driver;

	private By resultLinks = By.xpath("//h3[@class = 'LC20lb DKV0Md']");

	public GoogleResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public int gogleSeachrcount() {
		List<WebElement> resultLinkData = driver.findElements(resultLinks);
		return resultLinkData.size();
	}

	public FlipkartHome navigateToFlipKart(String searchURL) throws InterruptedException {
		List<WebElement> resultLink = driver.findElements(resultLinks);
		for (int i = 0; i < resultLink.size(); i++) {
			String result = resultLink.get(i).getText();
			System.out.println("Printing Result: " +result);
			if (result.equalsIgnoreCase(searchURL)) {
				resultLink.get(i).click();
				Thread.sleep(3000L);
				break;
			}
		}

		return new FlipkartHome(driver);
	}

}
