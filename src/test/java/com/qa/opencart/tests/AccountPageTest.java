package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
//		accountPage = loginPage.doLogin("raashigupta1402@gmail.com", "Alpha1234");
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void accPageUrlTest() {
		String actTitleString = accountPage.accountPageTitle();
		Assert.assertEquals(actTitleString, AppConstants.ACCOUNTS_PAGE_TITLE);
	}

	@Test
	public void accPageHeaderTest() {
		List<String> strings = accountPage.accountHeader();
		Assert.assertEquals(strings, AppConstants.EXPECTED_ACC_PAGE_HEADERS_LIST);
	}

	@Test
	public void accPageHeaderCountTest() {
		int count = accountPage.hearderCount();
		Assert.assertEquals(count, AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
	}

	@DataProvider
	public Object searchData()
	{
		return new Object[][]
				{
			{"Macbook", 3},
			{"imac" , 1}
				};
	}

	@Test(dataProvider ="searchData")
	public void searchTest(String search, int searchCount) {
		searchResultPage = accountPage.doSearch(search);
		int count = searchResultPage.getSearchResultsCount();
		System.out.println(count);
		Assert.assertEquals(count, searchCount);
	}

}
