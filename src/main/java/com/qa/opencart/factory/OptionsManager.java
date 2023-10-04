package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private ChromeOptions cOptions;
	private FirefoxOptions fOptions;
	private EdgeOptions eOptions;

	private Properties prop;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		cOptions = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			cOptions.addArguments("--headless=new");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			cOptions.addArguments("--incognito");
		}
		return cOptions;
	}

	public FirefoxOptions getFirefoxOptions() {
		fOptions = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			fOptions.addArguments("--headless=new");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			fOptions.addArguments("--incognito");
		}
		return fOptions;
	}

	public EdgeOptions getEdgeOptions() {
		eOptions = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			eOptions.addArguments("--headless=new");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			eOptions.addArguments("--incognito");
		}
		return eOptions;
	}

}
