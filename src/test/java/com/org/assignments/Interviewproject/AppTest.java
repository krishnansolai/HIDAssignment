package com.org.assignments.Interviewproject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AppTest extends UtilityFile {

	public static String URL = "https://legacy.reactjs.org/";
	static Response response;

	public void launchURL() {
		try {

			getURL(URL);
			waitForBrowserload();
			System.out.println("Successfully Launched URL: " + URL);

		} catch (Exception e) {

			Assert.fail("Failed to launch URL : " + e);
		}
	}

	public void clickDocsTab() {
		try {

			implictWait(30);

			WebElement docs = driver.findElement(By.xpath("//a[text()='Docs']"));

			if (docs.isDisplayed()) {
				docs.click();

				System.out.println("Sucessfully clicked on Docs Tab");
			} else {
				Assert.fail("Failed to click on Docs Tab");
			}
		} catch (Exception e) {

			Assert.fail("Failed to click on Docs Tab: " + e);
		}
	}

	public void mainConcepts() {
		try {

			implictWait(30);

			WebElement mc = driver.findElement(By.xpath("//div[text()='Main Concepts']"));

			if (mc.isDisplayed()) {
				mc.click();
				System.out.println("Sucessfully clicked on Main Concepts");
				List<WebElement> MCtextvalues = driver.findElements(By.xpath("//ul[@class='css-ts0qly']//li/a"));
				for (WebElement textele : MCtextvalues) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
							textele);
					System.out.println("Text Value:" + textele.getText());
				}
				System.out.println("Sucessfully printed main concept text values");
			} else {
				Assert.fail("Failed to click on main concept Tab");
			}
		} catch (Exception e) {

			Assert.fail("Failed to click on main concept Tab: " + e);
		}
	}

	public void advancedGuides() {
		try {

			Thread.sleep(3000);
			WebElement ac = driver.findElement(By.xpath("//div[text()='Advanced Guides']"));
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} catch (Exception e2) {

			}

			if (ac.isDisplayed()) {
				ac.click();
				System.out.println("Sucessfully clicked on Advanced Guides");
				List<WebElement> MCtextvalues = driver.findElements(By.xpath("//ul[@class='css-ts0qly']//li/a"));
				for (WebElement textele : MCtextvalues) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
							textele);

					System.out.println("Text Value:" + textele.getText());
				}
				System.out.println("Sucessfully printed advanced guides text values");
			} else {
				Assert.fail("Failed to click on Advanced Guides Tab");
			}
		} catch (Exception e) {

			Assert.fail("Failed to click on Advanced Guides Tab: " + e);
		}
	}

	public void clickTutorialTab() {
		try {

			implictWait(30);

			WebElement tutorial = driver.findElement(By.xpath("//a[text()='Tutorial' and @class='css-hobwqm']"));

			if (tutorial.isDisplayed()) {
				tutorial.click();

				System.out.println("Sucessfully clicked on Tutorial Tab");
			} else {
				Assert.fail("Failed to click on Tutorial Tab");
			}
		} catch (Exception e) {

			Assert.fail("Failed to click on Tutorial Tab: " + e);
		}

	}

	public void verifyTutorial() {
		try {

			Thread.sleep(3000);

			for (int i = 0; i < 5; i++) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,2000)");

				List<WebElement> fontw = driver.findElements(By.xpath("//li[@class='css-atv6j6']//a"));
				for (WebElement fw : fontw) {
					String fontWeight = fw.getCssValue("font-weight");
					if (fontWeight.equals("700")) {
						System.out.println("Font in bold is -> " + fw.getText());
						System.out.println("Font is bold and font-weight value is -> " + fontWeight);
						WebElement lc = driver.findElement(By.xpath("//li[@class='css-atv6j6']//a/span"));
						String line = lc.getCssValue("border-left");
						if (line.contains("97, 218, 251")) {
							System.out.println("Line color is blue and border-left value is -> " + line);
						}
					}
				}
			}

		} catch (Exception e) {

			Assert.fail("Failed to verify Tutorial Tab: " + e);
		}

	}

	public void getCallAPI() {
		RestAssured.baseURI = "https://coinmap.org/api/v1/venues/";
		RequestSpecification httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "");
//		System.out.println("Response =>" + response.prettyPrint());
	}

	public void countCategories() {
		JsonPath jp = new JsonPath(response.asString());
		String numFromsResponse = jp.get("venues.category.size()").toString();
		System.out.println("Count of categories =>" + numFromsResponse);

	}

	public void getNames() {
		List<String> food = response.jsonPath().getList("venues.category");
		int j=0;

		for (String i : food) {
			
			if (i.equals("food")) {
				System.out.println("Category: "+i);
				List<String> name = response.jsonPath().getList("venues.name");
				System.out.println("Name: " + name.get(j));
				List<String> geolocation = response.jsonPath().getList("venues.geolocation_degrees");
				System.out.println("geo location: " + geolocation.get(j));
			}
			j++;
		}

	}

}
