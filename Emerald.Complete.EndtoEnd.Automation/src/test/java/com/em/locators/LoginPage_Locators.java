package com.em.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.em.common.HelperMethods;

public class LoginPage_Locators {

	WebDriver driver;
	HelperMethods HelpMethod = new HelperMethods();

	public LoginPage_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	WebElement usernameLocator;
	@FindBy(how = How.ID, using = "password")
	WebElement passwordLocator;
	@FindBy(how = How.CLASS_NAME, using = "loginBtn")
	WebElement LoginLocatorButton;
	@FindBy(how = How.XPATH, using = "//img[@data-toggle='tooltip']")
	WebElement ToolTipTextUserfield;
	@FindBy(how = How.XPATH, using = "//span[@data-toggle='tooltip']")
	WebElement ToolTipTextPaswdfield;
	@FindBy(how = How.XPATH, using = "//div[@class='loginContents']/h1")
	WebElement LoginLogo;
	@FindBy(how = How.XPATH, using = "//label[@for='username']")
	WebElement UsernameText;
	@FindBy(how = How.XPATH, using = "//label[@for='exampleInputPassword1']")
	WebElement PasswordText;
	@FindBy(how = How.XPATH, using = "//div[@class='react-switch']")
	WebElement ShowHidePassword;
	@FindBy(how = How.XPATH, using = "//div[@class='ToastDiv']/h5")
	WebElement InvalidtoasterError;

	public String getloginLogoText() {
		HelpMethod.waitForElementToBeVisible(LoginLogo);
		return LoginLogo.getText();

	}

	public String userNametext() {
		HelpMethod.waitForElementToBeVisible(UsernameText);
		return UsernameText.getText();
	}

	public String passwordText() {
		HelpMethod.waitForElementToBeVisible(PasswordText);
		return PasswordText.getText();
	}

	public void typeUserName(String unam) {
		HelpMethod.waitForElementToBeVisible(usernameLocator);
		usernameLocator.sendKeys(unam);
	}

	public void typePassword(String pwd) {
		HelpMethod.waitForElementToBeVisible(passwordLocator);
		passwordLocator.sendKeys(pwd);

	}

	public String getEnteredPawdText() {
		HelpMethod.waitForElementToBeVisible(passwordLocator);
		return passwordLocator.getAttribute("value");
	}

	public void clearUserName() {
		HelperMethods.presenceOfElement(usernameLocator);
		usernameLocator.clear();
	}

	public void clearpassword() {
		HelperMethods.presenceOfElement(passwordLocator);
		passwordLocator.clear();
	}

	public void clickOnloginButton() {
		HelperMethods.waitForElementToBeClickable(LoginLocatorButton);
		LoginLocatorButton.click();
	}

	public String getLoginButtonText() {
		HelpMethod.waitForElementToBeVisible(LoginLocatorButton);
		return LoginLocatorButton.getText();
	}

	public String getUsernameTooltip() {
		HelperMethods.presenceOfElement(ToolTipTextUserfield);
		Actions action = new Actions(driver);
		try {
			Thread.sleep(3000);
			action.moveToElement(ToolTipTextUserfield).build().perform();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ToolTipTextUserfield.getAttribute("title");

	}

	public String getpasswordtooltip() {

		HelperMethods.presenceOfElement(ToolTipTextPaswdfield);
		Actions action = new Actions(driver);
		try {
			Thread.sleep(3000);
			action.moveToElement(ToolTipTextPaswdfield).build().perform();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return ToolTipTextPaswdfield.getAttribute("title");
	}

	public void ShowHidePasswordButton() {
		HelperMethods.waitForElementToBeClickable(ShowHidePassword);
		ShowHidePassword.click();
	}
	
	public String getToasterErrormessage() {
		HelperMethods.presenceOfElement(InvalidtoasterError);
		return InvalidtoasterError.getText();
	}

}
