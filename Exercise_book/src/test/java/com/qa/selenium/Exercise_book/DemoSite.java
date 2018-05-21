package com.qa.selenium.Exercise_book;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSite {
WebDriver driver;

@Before
		public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\JAVA EE\\web drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?id_category=8&controller=category");

	}
@After
 public void teardown() {
driver.quit();
}
 
@Test public void findTest() {
	WebElement findElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/h5"));
	
	assertEquals("Printed Dress",findElement.getText());
}
}