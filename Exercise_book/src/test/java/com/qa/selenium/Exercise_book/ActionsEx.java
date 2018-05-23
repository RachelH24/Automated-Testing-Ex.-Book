package com.qa.selenium.Exercise_book;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

;

public class ActionsEx {

	WebDriver driver;

	ExtentReports report;

	ExtentTest test;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\JAVA EE\\web drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demoqa.com/draggable/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		report = new ExtentReports("C:\\Users\\Admin\\Documents\\Reports.html", true);

		test = report.startTest("new Test");

	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();

		report.endTest(test);

		report.flush();

	}

	@Test
	public void dragAndDrop() {
		Actions action = new Actions(driver);

		WebElement draggable = driver.findElement(By.id("draggable"));
		
		draggable.getLocation();

		action.moveToElement(draggable).clickAndHold().moveByOffset(220, 220).release().perform();

		draggable.getLocation();
		
		test.log(LogStatus.INFO, "Info");

	}
}
