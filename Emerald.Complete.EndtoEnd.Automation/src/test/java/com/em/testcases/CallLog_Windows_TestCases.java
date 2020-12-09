package com.em.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.em.common.BrowsersFactory;
import com.em.common.HelperMethods;
import com.em.locators.CallLogs_Windows_Locators;
import com.em.locators.LoginPage_Locators;

public class CallLog_Windows_TestCases extends BrowsersFactory {
	CallLogs_Windows_Locators CallLogpage;
	HelperMethods HelpMethod = new HelperMethods();

	@Test(priority = 12)
	public void Test_CallLog_Windows_Switch_toCall_12() {
		HelperMethods.waitForPageLoaded();
		CallLogpage = new CallLogs_Windows_Locators(driver);
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

	}

}
