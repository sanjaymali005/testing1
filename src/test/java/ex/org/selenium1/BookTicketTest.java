package ex.org.selenium1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testing.testing1;
import utils.ExcelUtility;

public class BookTicketTest {
	private WebDriver driver;

	@Test(priority=1,dataProvider="logindata")
	public void login(String uname,String pass) {
		testing1.uname.sendKeys(uname);
		testing1.password.sendKeys(pass);
        testing1.Login_button.click();
        
	}
	
	@DataProvider(name="logindata")
	public String[][] login_data() throws Exception {
		ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_P5.Training\\Desktop\\Selenium Drivers\\SeleniumTestData.xlsx");
		String username = ExcelUtility.getCellData(1, 1);
		String password = ExcelUtility.getCellData(1, 2);
		
		return new String[][]{
			new String[] {username,password}
			};
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
