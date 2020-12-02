package com.em.common;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListeners extends BrowsersFactory implements ITestListener {

	ExtentTest test;
	private static ExtentReports extent = ExtentReporterNG.getReportObject();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		String logText = "<b>" + result.getMethod().getMethodName() + " Test Case " + " Passed Successfull</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
	}

	public void onTestFailure(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		String logText = "<b>" + testMethodName + " Test Case " + " Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);
		extentTest.get().fail(result.getThrowable());
		String path = HelperMethods.takeScreenshot(testMethodName);
		try {
			
			//extentTest.get().addScreenCaptureFromPath(HelperMethods.takeScreenshot(testMethodName), result.getMethod().getMethodName());
			extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>", MediaEntityBuilder.createScreenCaptureFromPath(path).build());

		} catch (Exception e) {
			extentTest.get().fail("Test case are failed, cannot take Screenshot");
			e.printStackTrace();
		}


	}

	public void onTestSkipped(ITestResult result) {
		String logText = "<b>" + result.getMethod().getMethodName() + " Test Case " + " Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP, m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}