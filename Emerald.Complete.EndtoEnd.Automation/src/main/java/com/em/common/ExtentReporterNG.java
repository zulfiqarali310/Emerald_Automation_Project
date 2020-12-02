package com.em.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	static ExtentReports extent;

	public static ExtentReports getReportObject() {
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//String path = System.getProperty("user.dir") + "\\reports\\" + "Emerald_" + timeStamp + ".html";
		/*String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "\\reports\\";
		new File(directory).mkdirs();
		String path = directory + fileName;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);*/
		

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + ".\\reports\\index.html");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Emerald Test Results");
		htmlReporter.config().setReportName("Emerald Automation Test Results");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester", "Zulfiqar Ali");
		extent.setSystemInfo("Browser Name", "Chrome");
		extent.setSystemInfo("OS Name", System.getProperty("os.name"));
		extent.setSystemInfo("OS Version", System.getProperty("os.version"));
		extent.setSystemInfo("Server Location", System.getProperty("user.country"));

		return extent;
	}
	
	public static String getReportName() {
		Date d = new Date();
		String fileName = "Automation_Report_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		return fileName;
	}
}
