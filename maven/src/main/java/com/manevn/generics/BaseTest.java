package com.manevn.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest<webdriver> implements AutoConstant{
	
	static{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(gecko_key, gecko_value);
	}
	
	public static WebDriver driver;
	public static int Passcount =0, Failcount = 0;
	
	@BeforeClass
	@Parameters("sbrowser")
	public static void OpenBrowser(String sbrowser) {
		if (sbrowser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if (sbrowser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void OpenApplictaion() {
		driver.get(URL);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult res) {
		int status = res.getStatus();
		String Methodname = res.getName();
		if (status == 1) {
			Passcount++;
		}else {
			Failcount++;
			String path = Photo_path+Methodname+".png";
			
		}
		driver.close();
	}
	
	@AfterSuite
	public void PrintReport() {
		Reporter.log("passcount: " + Passcount);
		Reporter.log("FailCount: " + Failcount);
	}

}
