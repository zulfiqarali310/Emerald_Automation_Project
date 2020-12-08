package com.em.testcases;

import org.openqa.selenium.By;
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

	@Test(priority = 16)
	@Parameters({ "CommName" })
	public void Test_CompanyName_are_Entered(String CommName) {
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.typeCompanyName(CommName);
		CreateApplicationPage.clickOnSearchButton();

	}

	@Test(priority = 17)
	@Parameters({ "CommName" })
	public void Test_SearchCompany_Text_and_CrossButton(String CommName) {
		CreateApplicationPage = new CreateApplication_Locators(driver);
		String Get_Message = CreateApplicationPage.EnteredCompanyText();
		Assert.assertEquals(Get_Message, "Search for " + CommName);
		System.out.println(Get_Message);
		CreateApplicationPage.clickOnPoPCrossButton();
		CreateApplicationPage.clickOnSearchButton();

	}

	@Test(priority = 18)
	@Parameters({ "CommName" })
	public void Test_to_SelectEnteredCompany(String CommName) {
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.SelectEntered_Company();
	}

	@Test(priority = 19)
	@Parameters({ "CommName" })
	public void Test_CompanyText_and_Cross_Button(String CommName) {
		CreateApplicationPage = new CreateApplication_Locators(driver);
		String Get_Message = CreateApplicationPage.EnteredCompanyText();
		Assert.assertEquals(Get_Message, "Search for " + CommName);
		CreateApplicationPage.clickOnPoPCrossButton();
		CreateApplicationPage.clickOnSearchButton();

	}

}
