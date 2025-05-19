package RSA.dataComponent;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import RSA.pom.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class basetestp1 {
public WebDriver driver;
public landingPage LandingPage;

	
	public WebDriver initializer() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\RSA\\resorces\\browserDetails.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			
		}else if(browserName.contains("firefox"))
			{
				driver = new FirefoxDriver();
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		
	}
	
	
	
	public List<HashMap<String, String>> jsondata(String filepath) throws IOException
	{
		 
		String jsoncontent = FileUtils.readFileToString( new File(filepath),StandardCharsets.UTF_8 );	 //convert from json to string	
		ObjectMapper  mapper = new ObjectMapper();
		List<HashMap<String , String>> data =mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String , String>>>() {}); //convert from string to hash map
		return data;	
	}
	
	public String screenshot(String testcaseName, WebDriver driver ) throws IOException
	{
		TakesScreenshot	ss=(TakesScreenshot)driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File path = new File( System.getProperty("user.dir")+ testcaseName + "//.png");
		FileUtils.copyFile(src, path);
		return System.getProperty("user.dir")+ testcaseName + "//.png";
	}
	
	
	@BeforeMethod
	public landingPage launchBrowser() throws IOException
	{
		driver = initializer();
		landingPage LandingPage = new landingPage(driver);
		LandingPage.goTo();
		return LandingPage;
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
}
