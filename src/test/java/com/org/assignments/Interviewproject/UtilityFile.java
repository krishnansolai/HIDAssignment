package com.org.assignments.Interviewproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityFile {

	public static String Value = null;

	public static WebDriver driver;

	public static String driverPath = "";

	public static void initializeDriver() {

		WebDriverManager.edgedriver().setup();
		EdgeDriver edgeDriver = new EdgeDriver();		
		driver=edgeDriver;
		

	}

	public void getURL(String urltext) {

		driver.get(urltext);
		driver.manage().window().maximize();
	}

	public void implictWait(int n) {

		driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);

	}

	public void waitForBrowserload() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i <= 20; i++) {

			try {

				if (js.executeScript("return document.readyState").toString().equals("complete")) {

					break;

				} else {

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}

			} catch (Exception e) {

				System.out.println("Failed to load the page\n " + e);
			}
		}

	}

}
