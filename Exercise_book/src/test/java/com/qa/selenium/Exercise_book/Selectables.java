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

;
public class Selectables {
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\JAVA EE\\web drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demoqa.com/selectable/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
	@Test
	public void select() {
		Actions action =new Actions (driver);
		WebElement seven = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[7]"));
		action.click(seven).perform();
	}
}
