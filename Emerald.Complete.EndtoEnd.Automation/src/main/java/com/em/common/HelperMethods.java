package com.em.common;

import java.io.File;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HelperMethods extends BrowsersFactory {

	public static String takeScreenshot(String testMethodName) {
		String fileName = getScreenshotName(testMethodName);
		String directory = System.getProperty("user.dir") + "\\screenshots\\";
		new File(directory).mkdir();
		String path = directory + fileName;

		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			

			FileUtils.copyFile(screenshot, new File(path));
			//System.out.println("Screenshot path are: " + path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName =  methodName + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}
	
	
	public static void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, 120);
		try {
			Thread.sleep(10000);
			wait.until(expectation);
		} catch (Throwable error) {
			Reporter.log("Timeout waiting for Page Load Request to complete.");
		}
	}

	// waitForElementToBeClickable(by.locator)
	public static void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementsVisibility(List<WebElement> searchResults) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
	}

	public static boolean presenceOfElement(WebElement element) {
		boolean bPresent;
		try {
			 WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.isDisplayed();
			bPresent = true;
		} catch (NoSuchElementException e) {
			bPresent = false;
		}
		return bPresent;
	}

}
