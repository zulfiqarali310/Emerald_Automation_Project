package com.em.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.em.common.HelperMethods;

public class CallLogs_Windows_Locators {
	
	WebDriver driver;
	HelperMethods HelpMethod = new HelperMethods();

	public CallLogs_Windows_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
