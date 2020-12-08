package com.em.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.em.common.HelperMethods;

public class CreateApplication_Locators {

	WebDriver driver;
	HelperMethods HelpMethod = new HelperMethods();

	public CreateApplication_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//div[@class='fab-wheel-saveOnly']")
	WebElement SaveApplication_Button;
	@FindBy(how = How.XPATH, using = "//div[@class='Toastify__toast-body']/div/div/div")
	WebElement CreateApplication_Alert;
	@FindBy(how = How.XPATH, using = "//*[@id='toastAppErrors']")
	WebElement AlertClosedWindow;

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

}
