package com.qa.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.flipkart.base.BaseTest;
import com.qa.flipkart.utils.Constants;

public class GoogleSearchTest extends BaseTest {

	@Test(priority = 1)
	public void googleTitleTest() {
		String title = googleSearch.getGoogleTitle();
		Assert.assertEquals(title, Constants.GOOGLE_TITLE);
	}

	@Test(priority = 2)
	public void googleSearchValueTest() throws InterruptedException {
		googleSearch.searchCriteria(Constants.SEARCH_CRITERIA);
	}

}
