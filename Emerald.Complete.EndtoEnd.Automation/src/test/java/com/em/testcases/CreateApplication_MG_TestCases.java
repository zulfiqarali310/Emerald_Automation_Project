package com.em.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.em.common.BrowsersFactory;
import com.em.common.HelperMethods;
import com.em.locators.CreateApplication_Locators;

public class CreateApplication_MG_TestCases extends BrowsersFactory {

	CreateApplication_Locators CreateApplicationPage;
	HelperMethods HelpMethod = new HelperMethods();

	@Test(priority = 13)
	@Parameters({ "CreateApplication_URL", "CreateApplication_Expectedtitle" })
	public void Test_CreateApplication_MG_Page_are_Displayed_13(String CreateApplication_URL,
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
	public void Test_CreateApplication_MG_To_ClickOn_Save_Button_14(String Requiredfields_errorMessagess) {

		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.clickOnSaveApplicationButton();
		HelperMethods.waitForPageLoaded();
		String Get_Message = CreateApplicationPage.GetRequiredfields_errormessages();
		System.out.println("Required Error Message withoutApplication " + Get_Message);
		CreateApplicationPage.clickOnErrorMessageAlert();
		// Assert.assertEquals(GetAll_errorMessage, Requiredfields_errorMessagess);

	}

	@Test(priority = 15)
	@Parameters({ "CommText" })
	public void Test_CreateApplication_MG_Company_sectionText_areAvailble_15(String CommText) {
		CreateApplicationPage = new CreateApplication_Locators(driver);
		String Get_Message = CreateApplicationPage.GetCompanyText();
		Assert.assertEquals(Get_Message, CommText);

	}

	@Test(priority = 16)
	@Parameters({ "CommName" })
	public void Test_CreateApplication_MG_CompanyName_are_Entered_16(String CommName) {
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.typeCompanyName(CommName);
		CreateApplicationPage.clickOnSearchButton();

	}

	@Test(priority = 17)
	@Parameters({ "CommName" })
	public void Test_CreateApplication_MG_To_SearchCompany_Text_and_CrossButton_17(String CommName) {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		String Get_Message = CreateApplicationPage.EnteredCompanyText();
		Assert.assertEquals(Get_Message, "Search for " + CommName);
		System.out.println(Get_Message);
		CreateApplicationPage.clickOnPoPCrossButton();
		CreateApplicationPage.clickOnSearchButton();

	}

	@Test(priority = 18)
	@Parameters({ "CommName" })
	public void Test_CreateApplication_MG_to_SelectEnteredCompany_18(String CommName) {
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.SelectEntered_Company();
	}

	@Test(priority = 19)
	@Parameters({ "CommName" })
	public void Test_CreateApplication_MG_CompanyText_and_Cross_Button_19(String CommName) {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		String Get_Message = CreateApplicationPage.EnteredCompanyText();
		Assert.assertEquals(Get_Message, "Search for " + CommName);
		CreateApplicationPage.clickOnPoPCrossButton();
		CreateApplicationPage.clickOnSearchButton();
		CreateApplicationPage.SelectEntered_Company();

	}

	@Test(priority = 20)
	public void Test_Createapplication_MG_to_Select_all_Directors_and_Submit_Button_20() {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.SelectAllDirectots();
		CreateApplicationPage.ClickOnSubmit_Button();

	}

	@Test(priority = 21)
	public void Test_CreateApplication_MG_Title_areSelected_21() {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.SelectMainGuartor_Title();

	}

	@Test(priority = 22)
	public void Test_CreateApplication_MG_Forename_Icon_are_Present_22() {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.CheckForename_icon();

	}

	@Test(priority = 23)
	@Parameters({ "Invalid_ForeName", "tooltipforenamemsg1", "tooltipforenamemsg2", "tooltipforenamemsg3",
			"Invalid_ForeName1" })
	public void Test_CreateApplication_MG_Forename_validationTooltip_Msgs_23(String Invalid_ForeName,
			String tooltipforenamemsg1, String tooltipforenamemsg2, String tooltipforenamemsg3,
			String Invalid_ForeName1) {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.clearForename();
		CreateApplicationPage.TypeForename(Invalid_ForeName);
		String TooltipMessage1 = CreateApplicationPage.getForenameTooltip();
		Assert.assertEquals(TooltipMessage1, tooltipforenamemsg1);
		CreateApplicationPage.clickOnSaveApplicationButton();
		CreateApplicationPage.clickOnErrorMessageAlert();
		String TooltipMessage2 = CreateApplicationPage.getForenameTooltip();
		Assert.assertEquals(TooltipMessage2, tooltipforenamemsg2);
		CreateApplicationPage.clearForename();
		CreateApplicationPage.TypeForename(Invalid_ForeName1);
		CreateApplicationPage.clickOnSaveApplicationButton();
		CreateApplicationPage.clickOnErrorMessageAlert();
		String TooltipMessage3 = CreateApplicationPage.getForenameTooltip();
		Assert.assertEquals(TooltipMessage3, tooltipforenamemsg3);

	}

	@Test(priority = 24)
	@Parameters({ "Valid_ForeName" })
	public void Test_CreateApplication_MG_Forename_are_Entered_24(String Valid_ForeName) {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.clearForename();
		CreateApplicationPage.TypeForename(Valid_ForeName);
	}

	@Test(priority = 25)
	public void Test_CreateApplication_MG_Middlename_Icon_are_Present_25() {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.CheckMiddlename_icon();

	}

	@Test(priority = 26)
	@Parameters({ "Invalid_MiddleName", "tooltipmiddlenamemsg1", "tooltipmiddlenamemsg2", "tooltipmiddlenamemsg3",
			"Invalid_MiddleName1" })
	public void Test_CreateApplication_MG_Middlename_validationTooltip_Msgs_26(String Invalid_MiddleName,
			String tooltipmiddlenamemsg1, String tooltipmiddlenamemsg2, String tooltipmiddlenamemsg3,
			String Invalid_MiddleName1) {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.clearMiddlename();
		CreateApplicationPage.TypeMiddlename(Invalid_MiddleName);
		String TooltipMessage1 = CreateApplicationPage.getMiddlenameTooltip();
		Assert.assertEquals(TooltipMessage1, tooltipmiddlenamemsg1);
		CreateApplicationPage.clickOnSaveApplicationButton();
		CreateApplicationPage.clickOnErrorMessageAlert();
		String TooltipMessage2 = CreateApplicationPage.getMiddlenameTooltip();
		Assert.assertEquals(TooltipMessage2, tooltipmiddlenamemsg2);
		CreateApplicationPage.clearMiddlename();
		CreateApplicationPage.TypeMiddlename(Invalid_MiddleName1);
		CreateApplicationPage.clickOnSaveApplicationButton();
		CreateApplicationPage.clickOnErrorMessageAlert();
		String TooltipMessage3 = CreateApplicationPage.getMiddlenameTooltip();
		Assert.assertEquals(TooltipMessage3, tooltipmiddlenamemsg3);

	}

	@Test(priority = 27)
	@Parameters({ "Valid_MiddleName" })
	public void Test_CreateApplication_MG_Forename_are_Entered_27(String Valid_MiddleName) {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.clearMiddlename();
		CreateApplicationPage.TypeMiddlename(Valid_MiddleName);
	}

	@Test(priority = 28)
	public void Test_CreateApplication_MG_Surname_Icon_are_Present_28() {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.CheckSurname_icon();

	}

	@Test(priority = 29)
	@Parameters({ "Invalid_SurName", "tooltipsurnamemsg1", "tooltipsurnamemsg2", "tooltipsurnamemsg3",
			"Invalid_SurName1" })
	public void Test_CreateApplication_MG_Surname_validationTooltip_Msgs_29(String Invalid_SurName,
			String tooltipsurnamemsg1, String tooltipsurnamemsg2, String tooltipsurnamemsg3, String Invalid_SurName1) {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.clearSurname();
		CreateApplicationPage.TypeSurname(Invalid_SurName);
		String TooltipMessage1 = CreateApplicationPage.getSurnameTooltip();
		Assert.assertEquals(TooltipMessage1, tooltipsurnamemsg1);
		CreateApplicationPage.clickOnSaveApplicationButton();
		CreateApplicationPage.clickOnErrorMessageAlert();
		String TooltipMessage2 = CreateApplicationPage.getSurnameTooltip();
		Assert.assertEquals(TooltipMessage2, tooltipsurnamemsg2);
		CreateApplicationPage.clearSurname();
		CreateApplicationPage.TypeSurname(Invalid_SurName1);
		CreateApplicationPage.clickOnSaveApplicationButton();
		CreateApplicationPage.clickOnErrorMessageAlert();
		String TooltipMessage3 = CreateApplicationPage.getSurnameTooltip();
		Assert.assertEquals(TooltipMessage3, tooltipsurnamemsg3);

	}

	@Test(priority = 30)
	@Parameters({ "Valid_SurName" })
	public void Test_CreateApplication_MG_Surname_are_Entered_30(String Valid_SurName) {
		HelperMethods.waitForPageLoaded();
		CreateApplicationPage = new CreateApplication_Locators(driver);
		CreateApplicationPage.clearSurname();
		CreateApplicationPage.TypeSurname(Valid_SurName);
	}

}
