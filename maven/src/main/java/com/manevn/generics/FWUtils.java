package com.manevn.generics;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWUtils {
	
	public static void VerifyPageTitle(WebDriver driver, String ExpectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(ExpectedTitle));
		String ActualTitle = driver.getTitle();
		if (ActualTitle.equals(ExpectedTitle)) {
			System.out.println("Expected Title is Dispalyed: " + ExpectedTitle);
		}else {
			System.out.println("Actual Title Is Dispalyed: " + ActualTitle);
		}
	}
	
	public static String Read_XL_Data(String path, String sheetName, int rownum, int cellnum) {
		String data= "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			data = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static int Read_Last_RowCount(String path, String SheetName) {
		int count = 0;
		
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(SheetName).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static void Set_XL_Data(String path, String SheetName, int rownum, int cellnum, int data) {
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(SheetName).getRow(rownum).getCell(cellnum).setCellValue(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TakeScreenShot(WebDriver driver, String path) {
		try {
			 TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dsc = new File(path);
			FileUtils.copyFile(src, dsc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
