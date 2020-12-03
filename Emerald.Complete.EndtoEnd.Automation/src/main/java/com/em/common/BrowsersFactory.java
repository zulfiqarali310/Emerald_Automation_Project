package com.em.common;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BrowsersFactory {
	public static WebDriver driver;
	static String UserDir = System.getProperty("user.dir");
	static String Chromebrowserpath = UserDir + "\\driver\\chromedriver.exe";
	static String firefoxbrowserpath = UserDir + "\\driver\\geckodriver.exe";
	static String InternetExplorerbrowserpath = UserDir + "\\driver\\IEDriverServer.exe";
	static String Operabrowserpath = UserDir + "\\driver\\operadriver.exe";
	static String Edgebrowserpath = UserDir + "\\driver\\msedgedriver.exe";
	
	@BeforeTest
	@Parameters("browser")
	public static WebDriver startBrowser(String browser) throws Exception {
		System.out.println("Initilized Browser is : " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("use-fake-ui-for-media-stream");
			System.setProperty("webdriver.chrome.driver", Chromebrowserpath);
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxbrowserpath);
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", InternetExplorerbrowserpath);
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", Operabrowserpath);
			driver = new OperaDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", Edgebrowserpath);
			driver = new EdgeDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("browser is not found");
		}
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

	@AfterTest
	public void afterMethod() {
		//driver.quit();
	}

}
