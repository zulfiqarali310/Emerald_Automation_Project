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

}
