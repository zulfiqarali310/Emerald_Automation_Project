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
	
	
	public void clickOnSaveApplicationButton() {
		HelperMethods.waitForElementToBeClickable(SaveApplication_Button);
		SaveApplication_Button.click();
	}
	
	public String GetRequiredfields_errormessages() {
		HelpMethod.waitForElementToBeVisible(CreateApplication_Alert);
		return CreateApplication_Alert.getText();

	}

}
