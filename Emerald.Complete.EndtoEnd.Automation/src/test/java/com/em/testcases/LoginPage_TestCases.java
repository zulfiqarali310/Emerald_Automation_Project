package com.em.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.em.common.BrowsersFactory;
import com.em.common.ExtentReporterNG;
import com.em.common.HelperMethods;
import com.em.locators.LoginPage_Locators;

public class LoginPage_TestCases extends BrowsersFactory {
	LoginPage_Locators loginpage;
	HelperMethods HelpMethod = new HelperMethods();

	ExtentTest test;
	private static ExtentReports extent = ExtentReporterNG.getReportObject();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Test(priority = 1)
	@Parameters({ "URL", "LoginExpectedtitle" })
	public void Emerald_Lunched(String URL, String LoginExpectedtitle) {
		driver.get(URL);
		try {
			HelperMethods.waitForPageLoaded();
			String VisitedUrl = driver.getCurrentUrl();
			String LoginPagetitle = driver.getTitle();
			Assert.assertEquals(URL, VisitedUrl);
			Assert.assertEquals(LoginPagetitle, LoginExpectedtitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void Test_Login_Logo_Text_isPresent() {
		loginpage = new LoginPage_Locators(driver);
		String LogoActualtext = loginpage.getloginLogoText();
		Assert.assertTrue(LogoActualtext.contains("Login"));
		//TestListeners.
	}

	@Test(priority = 3)
	public void Test_Username_Text_isPresent() {
		loginpage = new LoginPage_Locators(driver);
		String UsernameActualtext = loginpage.userNametext();
		Assert.assertTrue(UsernameActualtext.contains("Username"));
	}

	@Test(priority = 4)
	public void Test_Password_Text_isPresent() {
		loginpage = new LoginPage_Locators(driver);
		String PasswordActualtext = loginpage.passwordText();
		Assert.assertTrue(PasswordActualtext.contains("Password"));
	}

	@Test(priority = 5)
	@Parameters({ "Usernametooltip", "Passwordtooltip" })
	public void Click_LoginButton_without_usernamePaswword(String Usernametooltip, String Passwordtooltip) {
		loginpage = new LoginPage_Locators(driver);
		loginpage.clickOnloginButton();
		String Usnametooltip = loginpage.getUsernameTooltip();
		Assert.assertEquals(Usnametooltip, Usernametooltip);
		String Pwdtooltip = loginpage.getpasswordtooltip();
		Assert.assertEquals(Pwdtooltip, Passwordtooltip);

	}

	@Test(priority = 6)
	@Parameters("LoginText")
	public void Test_LoginButton(String LoginText) {
		loginpage = new LoginPage_Locators(driver);
		String LoginButtontext = loginpage.getLoginButtonText();
		Assert.assertEquals(LoginText, LoginButtontext);

	}

	@Test(priority = 7)
	@Parameters("ValidPassword")
	public void Test_Show_Hide_PasswordButton(String ValidPassword) {
		loginpage = new LoginPage_Locators(driver);
		loginpage.typePassword(ValidPassword);
		loginpage.ShowHidePasswordButton();
		String EnteredPwd = loginpage.getEnteredPawdText();
		Assert.assertEquals(ValidPassword, EnteredPwd);
		loginpage.ShowHidePasswordButton();
		loginpage.clearpassword();
	}

	@Test(priority = 8)
	@Parameters({ "ValidPassword", "Usernametooltip" })
	public void Test_login_without_Username(String ValidPassword, String Usernametooltip) {
		loginpage = new LoginPage_Locators(driver);
		driver.navigate().refresh();
		HelperMethods.waitForPageLoaded();
		loginpage.typePassword(ValidPassword);
		loginpage.clickOnloginButton();
		String Usnametooltip = loginpage.getUsernameTooltip();
		Assert.assertEquals(Usnametooltip, Usernametooltip);
		loginpage.clearpassword();
	}

	@Test(priority = 9)
	@Parameters({ "ValidUsername", "Passwordtooltip" })
	public void Test_login_without_Password(String ValidUsername, String Passwordtooltip) {
		loginpage = new LoginPage_Locators(driver);
		driver.navigate().refresh();
		HelperMethods.waitForPageLoaded();
		loginpage.typeUserName(ValidUsername);
		loginpage.clearpassword();
		loginpage.clickOnloginButton();
		String Pwdtooltip = loginpage.getpasswordtooltip();
		Assert.assertEquals(Pwdtooltip, Passwordtooltip);
		loginpage.clearUserName();
	}
	
	@Test(priority = 10)
	@Parameters({ "InvalidUsername", "InvalidPassword" })
	public void Test_for_Invalid_login(String InvalidUsername, String InvalidPassword) {
		loginpage = new LoginPage_Locators(driver);
		driver.navigate().refresh();
		HelperMethods.waitForPageLoaded();
		loginpage.typeUserName(InvalidUsername);
		loginpage.typePassword(InvalidPassword);
		loginpage.clickOnloginButton();
		String ToasterErrorMessage = loginpage.getToasterErrormessage();
		System.out.println(ToasterErrorMessage);
		extentTest.get().fail(ToasterErrorMessage);
		

	}

	@Test(priority = 11)
	@Parameters({ "ValidUsername", "ValidPassword" })
	public void valid_login(String ValidUsername, String ValidPassword) {
		loginpage = new LoginPage_Locators(driver);
		driver.navigate().refresh();
		HelperMethods.waitForPageLoaded();
		loginpage.typeUserName(ValidUsername);
		loginpage.typePassword(ValidPassword);
		loginpage.clickOnloginButton();
		System.out.println("UserA");

	}

}
