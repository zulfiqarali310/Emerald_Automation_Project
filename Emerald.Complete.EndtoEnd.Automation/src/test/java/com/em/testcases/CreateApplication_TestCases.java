package com.em.testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.em.common.BrowsersFactory;
import com.em.common.HelperMethods;
import com.em.locators.CreateApplication_Locators;

public class CreateApplication_TestCases extends BrowsersFactory {

	CreateApplication_Locators CreateApplicationPage;
	HelperMethods HelpMethod = new HelperMethods();

	@Test(priority = 13)
	@Parameters({ "CreateApplication_URL", "CreateApplication_Expectedtitle" })
	public void TestCreate_ApplicationPage_are_Displayed(String CreateApplication_URL, String CreateApplication_Expectedtitle) {
		driver.get(CreateApplication_URL);
		try {
			HelperMethods.waitForPageLoaded();
			String VisitedUrl = driver.getCurrentUrl();
			String LoginPagetitle = driver.getTitle();
			Assert.assertEquals(CreateApplication_URL, VisitedUrl);
			Assert.assertEquals(LoginPagetitle, CreateApplication_Expectedtitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 14)
	public void ClickOn_Save_or_CreateApplication_Button() {
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.clickOnSaveApplicationButton();
		String GetAll_errorMessage = CreateApplicationPage.GetRequiredfields_errormessages();
		System.out.println(GetAll_errorMessage);
	}

}
