import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Child extends Parent{
	
	@Test
	public void createUser()
	{driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	WebElement s1=	driver.findElement(By.xpath("//div[@id='container_tasks']"));
	Actions a1=new Actions(driver);
	a1.moveToElement(s1).click().build().perform();
WebElement a=driver.findElement(By.xpath("//div[@class='plusIcon']"));
		Select sel=new Select(a);
		sel.selectByIndex(0);
		WebElement b=driver.findElement(By.xpath("//div[@class='customerNameDiv']//input[@placeholder='Enter Customer Name']"));
		b.sendKeys("shanker");
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys("software engineer");
		WebElement b1=driver.findElement(By.xpath("//div[@class='emptySelection']"));
		Select s=new Select(b1);
		s.selectByIndex(1);
		driver.findElement(By.xpath("//div[contains(text(),'Create Customer')]")).click();
		Reporter.log("customer created",true);
	}
	@Test
	public void deleteUser()
	{
	
		driver.findElement(By.xpath("//div[@id='container_tasks']")).click();

		driver.findElement(By.xpath("//div[@class='node customerNode editable selected editing']//div[@class='editButton']")).click();
	
	driver.findElement(By.xpath("//div[@class='actionButtonWrapper pressed']//div[@class='action'][contains(text(),'ACTIONS')]")).click();
    driver.findElement(By.xpath("//div[@class='taskManagement_customerPanel']//div[@class='title'][contains(text(),'Delete')]")).click();
	Reporter.log("customer deleted",true);
	}
	

}
