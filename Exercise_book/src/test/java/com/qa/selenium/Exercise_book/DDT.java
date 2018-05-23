package com.qa.selenium.Exercise_book;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
	
	
public class DDT {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	String LoginData = "C:\\Users\\Admin\\Downloads\\Automated Testing Materials (1)\\Automated Testing Materials\\DemoSiteDDT.xlsx";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\JAVA EE\\web drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		report = new ExtentReports("C:\\\\Users\\\\Admin\\\\Documents\\\\Reports.html");
		test = report.startTest("StartingTest");
	}
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();

		report.endTest(test);
		
		report.flush();

	}

@Test
	public void excelTest() throws InterruptedException, IOException {

		FileInputStream file = null;
		file = new FileInputStream(LoginData);
		XSSFWorkbook workbook = null;
		workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

			XSSFCell username = sheet.getRow(i).getCell(0);
			XSSFCell password = sheet.getRow(i).getCell(1);

			String user = username.getStringCellValue();
			String pass = password.getStringCellValue();

			driver.get("http://thedemosite.co.uk/login.php");
			test.log(LogStatus.INFO, "navigate to demosite homepage");

			test.log(LogStatus.INFO, "inputting new username");
		
			WebElement UserElement = driver.findElement(By.name("username")); 
			UserElement.click();
			UserElement.sendKeys(user);
			test.log(LogStatus.INFO, "inputting new PASSWORD");
			WebElement PassElement = driver.findElement(By.name("password")); 
			PassElement.click();
			PassElement.sendKeys(pass);
			WebElement FormElement = driver.findElement(By.name("FormsButton2")); 
			FormElement.click();
}
		workbook.close();
}}