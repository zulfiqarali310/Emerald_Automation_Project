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
	public void TestCreate_ApplicationPage_are_Displayed(String CreateApplication_URL,
			String CreateApplication_Expectedtitle) {
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
	@Parameters({ "Requiredfields_errorMessagess" })
	public void ClickOn_Save_or_CreateApplication_Button(String Requiredfields_errorMessagess) {
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.clickOnSaveApplicationButton();
		String Get_Message = CreateApplicationPage.GetRequiredfields_errormessages();
		System.out.println("Required Error Message withoutApplication " + Get_Message);
		CreateApplicationPage.clickOnErrorMessageAlert();
		// Assert.assertEquals(GetAll_errorMessage, Requiredfields_errorMessagess);

	}

	@Test(priority = 15)
	@Parameters({ "CommText" })
	public void CheckCompany_sectionText_areAvailble(String CommText) {
		CreateApplicationPage = new CreateApplication_Locators(driver);
		String Get_Message = CreateApplicationPage.GetCompanyText();
		Assert.assertEquals(Get_Message, CommText);

	}

}
