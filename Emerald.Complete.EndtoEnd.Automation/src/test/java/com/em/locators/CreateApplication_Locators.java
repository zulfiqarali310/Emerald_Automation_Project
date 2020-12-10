package com.em.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.em.common.HelperMethods;

public class CreateApplication_Locators {

	WebDriver driver;
	HelperMethods HelpMethod = new HelperMethods();

	public CreateApplication_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// New Application Alerts Locators.
	@FindBy(how = How.XPATH, using = "//div[@class='fab-wheel-saveOnly']")
	WebElement SaveApplication_Button;
	@FindBy(how = How.XPATH, using = "//div[@class='Toastify__toast-body']/div/div/div")
	WebElement CreateApplication_Alert;
	@FindBy(how = How.XPATH, using = "//*[@id='toastAppErrors']")
	WebElement AlertClosedWindow;

	// Add company Section Locators
	@FindBy(how = How.XPATH, using = "//*[@id='2']/div/div/h4/span")
	WebElement CreateApplication_CompanyText;
	@FindBy(how = How.ID, using = "companyName")
	WebElement CompanyField;
	@FindBy(how = How.XPATH, using = "//i[@class='infoIconArea fa fa-search']")
	WebElement ClickTo_SearchCompany;
	@FindBy(how = How.XPATH, using = "//div[@class='modal-header']/h4")
	WebElement VerifyEntered_CompanyText;
	@FindBy(how = How.XPATH, using = "//button[@type='button']/i")
	WebElement VerifyTo_ClickCrossButton;
	@FindBy(how = How.XPATH, using = "//tbody[@class='innerTable']/tr[1]")
	WebElement ClickOn_EnteredCompany;
	@FindBy(how = How.XPATH, using = "//tbody[@class='innerTable']/tr[1]/td[2]/span[2]")
	WebElement ClickOn_FirstOfficer;
	@FindBy(how = How.XPATH, using = "//tbody[@class='innerTable']/tr[2]/td[2]/span[2]")
	WebElement ClickOn_SecondOfficer;
	@FindBy(how = How.XPATH, using = "//tbody[@class='innerTable']/tr[3]/td[2]/span[2]")
	WebElement ClickOn_ThirdOfficer;
	@FindBy(how = How.XPATH, using = "//tbody[@class='innerTable']/tr[4]/td[2]/span[2]")
	WebElement ClickOn_FourthOfficer;
	@FindBy(how = How.XPATH, using = "//ul[@class='canSubtBtn']/li/span")
	WebElement ClickOn_SubmitButton;

	// Main Guarantor Locatorss.
	@FindBy(how = How.ID, using = "mainGuarantorTitle")
	WebElement SelectMainGuarntor_Title;
	// Forename
	@FindBy(how = How.XPATH, using = "//i[@class='infoIconArea fa icon-firstname']")
	WebElement Check_ForeName_Icon;
	@FindBy(how = How.ID, using = "mainGuarantorforename")
	WebElement Forename;
	// Middle name
	@FindBy(how = How.XPATH, using = "//i[@class='infoIconArea fa icon-middle']")
	WebElement Check_MiddleName_Icon;
	@FindBy(how = How.ID, using = "mainGuarantormiddleName")
	WebElement Middlename;

	// Surname
	@FindBy(how = How.XPATH, using = "//i[@class='infoIconArea fa icon-lastname']")
	WebElement Check_SurName_Icon;
	@FindBy(how = How.ID, using = "mainGuarantorsurname")
	WebElement Surname;
	
	//DOB Calendar
	@FindBy(how = How.XPATH, using = "//i[@class='infoIconArea fa icon-datecalandar']")
	WebElement Check_Calendar_Icon;
	@FindBy(how = How.ID, using = "mainGuarantordob")
	WebElement Dob;
	@FindBy(how = How.XPATH, using = "//td[@class='day active']")
	WebElement select_activeDate;
	

	public void clickOnSaveApplicationButton() {
		HelperMethods.waitForElementToBeClickable(SaveApplication_Button);
		SaveApplication_Button.click();
	}

	public void clickOnErrorMessageAlert() {
		HelperMethods.waitForElementToBeClickable(AlertClosedWindow);
		AlertClosedWindow.click();
	}

	public String GetRequiredfields_errormessages() {
		HelpMethod.waitForElementToBeVisible(CreateApplication_Alert);
		return CreateApplication_Alert.getText();

	}

	public String GetCompanyText() {
		HelpMethod.waitForElementToBeVisible(CreateApplication_CompanyText);
		return CreateApplication_CompanyText.getText();

	}

	public void typeCompanyName(String CompName) {
		HelpMethod.waitForElementToBeVisible(CompanyField);
		CompanyField.sendKeys(CompName);
	}

	public void clickOnSearchButton() {
		HelperMethods.waitForElementToBeClickable(ClickTo_SearchCompany);
		ClickTo_SearchCompany.click();
	}

	public String EnteredCompanyText() {
		HelpMethod.waitForElementToBeVisible(VerifyEntered_CompanyText);
		return VerifyEntered_CompanyText.getText();

	}

	public void clickOnPoPCrossButton() {
		HelperMethods.waitForElementToBeClickable(VerifyTo_ClickCrossButton);
		VerifyTo_ClickCrossButton.click();
	}

	public void SelectEntered_Company() {
		HelperMethods.waitForElementToBeClickable(ClickOn_EnteredCompany);
		ClickOn_EnteredCompany.click();
	}

	public void SelectAllDirectots() {
		HelperMethods.waitForElementToBeClickable(ClickOn_FirstOfficer);
		ClickOn_FirstOfficer.click();

		HelperMethods.waitForElementToBeClickable(ClickOn_SecondOfficer);
		ClickOn_SecondOfficer.click();

		HelperMethods.waitForElementToBeClickable(ClickOn_ThirdOfficer);
		ClickOn_ThirdOfficer.click();

		HelperMethods.waitForElementToBeClickable(ClickOn_FourthOfficer);
		ClickOn_FourthOfficer.click();

	}

	public void ClickOnSubmit_Button() {
		HelperMethods.waitForElementToBeClickable(ClickOn_SubmitButton);
		ClickOn_SubmitButton.click();
	}

	public void SelectMainGuartor_Title() {
		HelperMethods.waitForElementToBeVisible(SelectMainGuarntor_Title);
		SelectMainGuarntor_Title.isDisplayed();
		Select MainG_Drp = new Select(SelectMainGuarntor_Title);
		MainG_Drp.selectByVisibleText("Mr");

	}

	public void CheckForename_icon() {
		HelperMethods.waitForElementToBeVisible(Check_ForeName_Icon);
		boolean Icon = Check_ForeName_Icon.isDisplayed();
		boolean expected = true;
		Assert.assertEquals(Icon, expected);
	}

	public void clearForename() {
		HelperMethods.presenceOfElement(Forename);
		Forename.clear();
	}

	public void TypeForename(String name) {
		HelperMethods.waitForElementToBeVisible(Forename);
		Forename.isDisplayed();
		Forename.sendKeys(name);
	}

	public String getForenameTooltip() {
		HelperMethods.presenceOfElement(Check_ForeName_Icon);
		Actions action = new Actions(driver);
		try {
			Thread.sleep(3000);
			action.moveToElement(Check_ForeName_Icon).build().perform();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Check_ForeName_Icon.getAttribute("title");

	}

	public void CheckMiddlename_icon() {
		HelperMethods.waitForElementToBeVisible(Check_MiddleName_Icon);
		boolean Icon = Check_MiddleName_Icon.isDisplayed();
		boolean expected = true;
		Assert.assertEquals(Icon, expected);
	}

	public void clearMiddlename() {
		HelperMethods.presenceOfElement(Middlename);
		Middlename.clear();
	}

	public void TypeMiddlename(String name) {
		HelperMethods.waitForElementToBeVisible(Middlename);
		Middlename.isDisplayed();
		Middlename.sendKeys(name);
	}

	public String getMiddlenameTooltip() {
		HelperMethods.presenceOfElement(Check_MiddleName_Icon);
		Actions action = new Actions(driver);
		try {
			Thread.sleep(3000);
			action.moveToElement(Check_MiddleName_Icon).build().perform();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Check_MiddleName_Icon.getAttribute("title");

	}

	public void CheckSurname_icon() {
		HelperMethods.waitForElementToBeVisible(Check_SurName_Icon);
		boolean Icon = Check_SurName_Icon.isDisplayed();
		boolean expected = true;
		Assert.assertEquals(Icon, expected);
	}

	public void clearSurname() {
		HelperMethods.presenceOfElement(Surname);
		Surname.clear();
	}

	public void TypeSurname(String name) {
		HelperMethods.waitForElementToBeVisible(Surname);
		Surname.isDisplayed();
		Surname.sendKeys(name);
	}

	public String getSurnameTooltip() {
		HelperMethods.presenceOfElement(Check_SurName_Icon);
		Actions action = new Actions(driver);
		try {
			Thread.sleep(3000);
			action.moveToElement(Check_SurName_Icon).build().perform();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Check_SurName_Icon.getAttribute("title");

	}
	public void CheckCalendar_icon() {
		HelperMethods.waitForElementToBeVisible(Check_Calendar_Icon);
		boolean Icon = Check_Calendar_Icon.isDisplayed();
		boolean expected = true;
		Assert.assertEquals(Icon, expected);
	}

	public void clearDob() {
		HelperMethods.presenceOfElement(Dob);
		Dob.clear();
	}
	public void TypeDob(String dob) {
		HelperMethods.waitForElementToBeVisible(Dob);
		Dob.sendKeys(dob);
	}
	
	public void SelectActiveDate() {
		HelperMethods.waitForElementToBeVisible(Dob);
		Dob.click();
		HelperMethods.waitForElementToBeVisible(select_activeDate);
		select_activeDate.isDisplayed();
		select_activeDate.click();
	}
	public String getDobTooltip() {
		HelperMethods.presenceOfElement(Check_Calendar_Icon);
		Actions action = new Actions(driver);
		try {
			Thread.sleep(3000);
			action.moveToElement(Check_Calendar_Icon).build().perform();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Check_Calendar_Icon.getAttribute("title");

	}

	
}
