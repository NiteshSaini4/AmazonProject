package com.testcase.com;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.utlities.com.ReadConfiguration;

public class BaseClass 
{
	public static WebDriver driver;
	public static Logger l;
	public ReadConfiguration rc=new ReadConfiguration();
	String Browser=rc.getBrowser();//Chrome
	String url=rc.getUrl();//https://practicetestautomation.com/practice-test-login/
	@BeforeTest
	void browserLaunch()
	{
		switch(Browser.toLowerCase())
		{
		case "chrome":
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		break;
		
		case "msedge":
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		break;
		case "firefox":
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		break;
		default :
			driver=null;
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		l=LogManager.getLogger("DataDrivenFramework");
	}
	public  void  ScreenShot() throws IOException
	{
			
		File Source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Destination=new File("C:\\Users\\dell\\eclipse-workspace\\DataDrivenFramework\\ScreenShots\\wwe.png");
		FileUtils.copyFile(Source, Destination);
		
	}
	@AfterTest
	void closeup()
	{
		driver.close();
		driver.quit();
	}
}
