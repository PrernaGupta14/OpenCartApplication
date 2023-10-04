package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By headerBy = By.tagName("h2");
	private By searchBy= By.name("search");
	private By serarchIconBy= By.xpath("//button[@class='btn btn-default btn-lg']");

	public AccountPage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}

	public String accountPageTitle() {
		return elementUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
	}

	public String accountPageUrl() {
		return elementUtil.waitForURLContains("account/account", AppConstants.MEDIUM_TIME_OUT);
	}

	public List<String> accountHeader() {
		List<WebElement> header = elementUtil.getElements(headerBy);
		List<String> textList = new ArrayList<String>();

		for (WebElement e : header) {
			String headerText = e.getText();
			textList.add(headerText);
		}
		System.out.println("List of headers: " + textList);
		return textList;
	}

	public int hearderCount() {
		return elementUtil.waitForElementsVisible(headerBy, AppConstants.MEDIUM_TIME_OUT).size();
	}

	public SearchResultPage doSearch(String searchkey) {
		WebElement searchElement= elementUtil.getElement(searchBy);
		searchElement.clear();
		searchElement.sendKeys(searchkey);
		elementUtil.doClick(serarchIconBy);
		return new SearchResultPage(driver);  //TDD approach
		
	}
}
