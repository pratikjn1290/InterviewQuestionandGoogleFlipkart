package com.qa.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.flipkart.base.BaseTest;
import com.qa.flipkart.utils.Constants;

public class GoogleResultTest extends BaseTest {

	@BeforeClass
	public void searchResultSetup() throws InterruptedException
	{
		googleResultPage = googleSearch.searchCriteria("FlipKart");
	}
	
	@Test(priority = 1)
	public void googleResultCountTest() {
		Assert.assertTrue(googleResultPage.gogleSeachrcount() > 0);
	}
	
	
	@Test(priority = 2)
	public void googleResultLinkTest() throws InterruptedException {
		googleResultPage.navigateToFlipKart(Constants.SEARCH_URL);
	}

	
}
