package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.spi.FileSystemProvider;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClas {

	public static WebDriver driver;
	public Properties p;

	@BeforeClass(groups= {"sanity","Regresssion","Master"})
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {
		
		
		//loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		
		p = new Properties();
		p.load(file);
		/* This is for grid environment
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);	
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);	
			}
			else
			{
				System.out.println("No Matching OS");
			}
			
			//browser
			
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch (br.toLowerCase())
			{
			case "chrome":driver = new ChromeDriver();break;
			case "edge":driver = new EdgeDriver();break;
			case "firefox":driver = new FirefoxDriver();break;
			default:System.out.println("Invalid browser name..");return;
			}	
		}
		*/
		
		switch (br.toLowerCase())
		{
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		default:System.out.println("Invalid browser name..");return;
		}	
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(p.getProperty("appURL"));//reading URL from properties file

	}

	@AfterClass(groups= {"sanity","Regresssion","Master"})
	public void teardown() {
		driver.quit();
	}

	// private Class<?> logger() {
	// TODO Auto-generated method stub
	// return null;
	// }

	public String randomString() {

		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

	public String randomphnsnumber() {

		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	public String randomalphanumeric() {

		String generatedstring = RandomStringUtils.randomAlphabetic(4);

		String generatednumber = RandomStringUtils.randomNumeric(4);

		return (generatedstring + "@" + generatednumber);
	}

	public String captureScreen(String tname) throws IOException
	{
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File sourceFile =takescreenshot.getScreenshotAs(OutputType.FILE);
		
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname +"_"+ timeStamp +".pmg";	
		File targetFile = new File (targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

}
