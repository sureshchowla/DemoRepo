import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Parent {
 WebDriver driver;


	@BeforeClass
	public void openApp()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Shanker\\Downloads\\geckodriver.exe");
		 driver=new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://online.actitime.com/t20/login.do");
Reporter.log("applicatoion opned",true);
	}
	@AfterClass
	public void closeApp()
	{
		driver.close();
		Reporter.log("application closed",true);
	}
	@BeforeMethod
	public void Login()
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("susheelanagireddy25@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("redcherry421");
		driver.findElement(By.xpath("//a[@id='loginButton']//div[contains(text(),'Login')]")).click();
	}
@AfterMethod
public void closeLogin()
{
	driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
	driver.close();
}
}
