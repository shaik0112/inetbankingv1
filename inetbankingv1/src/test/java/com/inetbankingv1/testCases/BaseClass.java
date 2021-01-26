package com.inetbankingv1.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbankingv1.Utilities.ReadConfig;

public class BaseClass {
ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public  Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
				System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
	}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getFirefoxpath());
			driver=new FirefoxDriver();	
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getIEpath());
			driver=new InternetExplorerDriver();
		}
	}
	@AfterClass
	public void tearDown() 
	{
				driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname)throws IOException
	{
		TakesScreenshot As=(TakesScreenshot)driver;
		File source=As.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/screendhots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
		
	}

