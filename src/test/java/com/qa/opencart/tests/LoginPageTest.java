package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends BaseTest {
	
	@Epic("")
	@Story("")
	
	
	@Description
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void loginPageUrlTest() {
		String url = loginPage.getLoginUrl();
		Assert.assertEquals(url, "https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test(priority = 3)
	public void forgetLinkDisplayTest() {
		boolean value = loginPage.forgetLinkDisplayed();
		Assert.assertTrue(value);
	}

	@Test(priority = 4)
	public void doLoginTest() {
//		accountPage = loginPage.doLogin("raashigupta1402@gmail.com", "Alpha1234");
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountPage.accountPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
	}
}
