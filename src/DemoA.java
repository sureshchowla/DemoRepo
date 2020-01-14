import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DemoA {
	@BeforeClass
	public void openApp()
	{
		Reporter.log("application opened",true);	
	}
	@AfterClass
	public void closeApp()
	{
		Reporter.log("applicationed close",true);
	}
	@BeforeMethod
	public void login()
	{
		Reporter.log("login application",true);
	}
	@AfterMethod
	public void logout()
	{
		Reporter.log("logout application",true);
	}
	@Test
	public void createcust()
	{
		Reporter.log("custid is created",true);
	}
	@Test
	public void deletecust()
	{
		Reporter.log("cust id is deleted",true);
	}
}
