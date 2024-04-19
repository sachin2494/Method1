package GoogleSearch;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchMultipleWords {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");	}
	
	@DataProvider(name = "getDataProvider")
	public String[][] getData()
	{
		String excelFile = "D:\\selenium\\Automation2\\DataFolder\\Book2.xlsx";
		String[][] excelKeyWord = TestUtility.getDataFromExcel(excelFile, "Sheet1");
		System.out.println(excelKeyWord);
		return excelKeyWord;
	}
	
	@Test(dataProvider = "getDataProvider")
	public void searchWord(String keyword) throws InterruptedException
	{
		WebElement searchKeyword = driver.findElement(By.name("q"));
		searchKeyword.sendKeys(keyword);
		searchKeyword.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
