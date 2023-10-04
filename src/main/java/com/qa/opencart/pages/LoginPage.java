package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// private By locators
	private By emaiBy = By.id("input-email");
	private By pasBy = By.id("input-password");
	private By linkBy = By.linkText("Forgotten Password");
	private By butBy = By.xpath("//input[@value='Login']");
	private By registerBy = By.linkText("Register");

	// public page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	@Step("")
	public String getLoginTitle() {
		String title = elementUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.MEDIUM_TIME_OUT);
//		String title = driver.getTitle();
//		System.out.println(title);
		return title;
	}

	public String getLoginUrl() {
		String url = elementUtil.waitForURLContains("account/login", AppConstants.LONG_TIME_OUT);
//		String url = driver.getCurrentUrl();
//		System.out.println(url);
		return url;
	}

	public boolean forgetLinkDisplayed() {
		boolean val = elementUtil.checkElementIsDisplayed(linkBy);
//		boolean linkString = driver.findElement(linkBy).isDisplayed();
//		System.out.println(linkString);
		return val;
	}

	public AccountPage doLogin(String username, String passowrd) {
		WebElement usernamElement = driver.findElement(emaiBy);
		usernamElement.sendKeys(username);
		WebElement passElement = driver.findElement(pasBy);
		passElement.sendKeys(passowrd);
		driver.findElement(butBy).click();
		// return driver.getTitle();

//-------------returning Account page object to test the next page
		return new AccountPage(driver);

	}

	public RegisterPage navigateToRegisterPage() {
		elementUtil.waitForElementVisible(registerBy, AppConstants.MEDIUM_TIME_OUT).click();
		return new RegisterPage(driver);
	}

}
