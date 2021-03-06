package ex.org.selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testing.testing1;
import utils.ExcelUtility;

public class BookTicketTest {
	private WebDriver driver;
	private int cloNum = 2;
	private static int rowNum = 1;
	

	@Test(priority=1,dataProvider="logindata")
	public void login(String uname,String pass) throws Exception {
	try{
		testing1.uname.sendKeys(uname);
		testing1.password.sendKeys(pass);
        testing1.Login_button.click();
        
        WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("tirpType")));
        		
        
        Assert.assertEquals("Find a Flight:Mercury", driver.getTitle());
	
        ExcelUtility.setExcelData(rowNum, cloNum, "pass");
            
       driver.get("http://newtours.demoaut.com/");
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("userName")));
	}catch(AssertionError e) {
		ExcelUtility.setExcelData(rowNum, cloNum, "Fail");
		
	}
	finally {
		rowNum++;	
	}
	}
	
	/*@Test(priority=2)
	public void findflight()
	{
		 
		driver.findElement(By.cssSelector("input[name='tripType'][value='oneway']")).click();
		
		Select passengers = new Select(driver.findElement(By.name("passCount")));
		passengers.selectByValue("2");
		
		Select DepartingFrom = new Select(driver.findElement(By.name("fromPort")));
		DepartingFrom.selectByValue("London");
		
		Select On = new Select(driver.findElement(By.name("fromMonth")));
		On.selectByValue("7");
		
		Select date = new Select(driver.findElement(By.name("fromDay")));
		date.selectByValue("10");
		
		Select ArrivingIn = new Select(driver.findElement(By.name("toPort")));
		ArrivingIn.selectByValue("Frankfurt");
		
		Select Returning = new Select(driver.findElement(By.name("toMonth")));
		Returning.selectByValue("7");
		
		Select date1 = new Select(driver.findElement(By.name("toDay")));
		date1.selectByValue("15");

		
		driver.findElement(By.cssSelector("input[name='servClass'][value='Business']")).click();
		
		Select Airline = new Select(driver.findElement(By.name("airline")));
		Airline.selectByVisibleText("Blue Skies Airlines");
		
		driver.findElement(By.name("findFlights")).click();
		
					
				
	}*/

	@DataProvider(name="logindata")
	public String[][] login_data() throws Exception {
		ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_P5.Training\\Desktop\\Selenium Drivers\\SeleniumTestData.xlsx");
		String[][] excelData = ExcelUtility.getExcelTable();
		return excelData;
		
		}
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\A06438_P5.Training\\Desktop\\Selenium Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		PageFactory.initElements(driver, testing1.class);
		
	}

	@AfterTest
	public void afterTest() {
	}

}
