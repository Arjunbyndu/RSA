package RSA.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage  
{

		WebDriver driver;
		
		public landingPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//page factory elements
		private @FindBy(id="userEmail")
		WebElement emailfield;
		
		private @FindBy(id="userPassword")
		WebElement passwordfield;
		
		private @FindBy(css="#login")
		WebElement loginbutton;
		
		
		
		//action methods
		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client/");
		}
		
		public void Login(String EnterUserName , String EnterPassword)
		{
			emailfield.sendKeys(EnterUserName);
			passwordfield.sendKeys(EnterPassword);
			loginbutton.click();
		}
}
