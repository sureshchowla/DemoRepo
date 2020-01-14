import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sushee1 {
	public static void main(String[] args) throws Exception
	{
		

		System.out.println("Starts");

		FileInputStream fis=new FileInputStream("C:\\Users\\Shanker\\Desktop\\testdata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet s=wb.getSheet("Sheet2");
	for(int i=1;i<=s.getLastRowNum();i++)
	{
		
		String s1=s.getRow(i).getCell(0).getStringCellValue();
				String s2=s.getRow(i).getCell(1).getStringCellValue();
				System.setProperty("webdriver.gecko.driver","C:\\Users\\Shanker\\Downloads\\geckodriver.exe");
				WebDriver driver=new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
				driver.get("https://online.actitime.com/t20/login.do");

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(s1);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Password')]")).sendKeys(s2);
		driver.findElement(By.xpath("//a[@id='loginButton']//div[contains(text(),'Login')]")).click();
		String exptitle="Enter";
		
		String a1=driver.getTitle();
		
		
		s.getRow(i).createCell(3).setCellValue(a1);
		if(a1.contains(exptitle))
		{
		s.getRow(i).createCell(4).setCellValue("Pass");
		
		}
		else
		{
			s.getRow(i).createCell(4).setCellValue("fail");

		}
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Shanker\\Desktop\\testdata.xlsx");
		wb.write(fos);

	}
	
	System.out.println("Ends");

	}

	}

