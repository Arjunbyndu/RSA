package RSA.testcases;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import RSA.dataComponent.basetestp1;
import RSA.pom.landingPage;



public class tc1 extends basetestp1{
	
	
	
	/*@Test(dataProvider = "userData")
	public void testLogin_User_InValidEmail(HashMap<String , String> input)
	{
		landingPage LoginPage = new landingPage(driver);
		LoginPage.Login(input.get("email"), input.get("pwd"));
		driver.close();
		dependsOnMethods = "testLogin_User_InValidEmail" ,
	}*/
	@Test( dataProvider ="userData")
	public void placeorder(HashMap<String ,String> input)
	{
		landingPage LandingPage = new landingPage(driver);
		LandingPage.Login(input.get("email"), input.get("pwd"));
		
	}

	@DataProvider
	public Object[][] userData() throws IOException
	{
		
	List<HashMap<String, String>>	path =jsondata(System.getProperty("user.dir")+"\\src\\test\\java\\RSA\\testData\\userdata.json");
		return new Object[][] { {path.get(0)}, {path.get(1)} };
		
	}
}
