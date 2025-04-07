package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClas;
import utilities.DatProviders;


/*Data is valid - login success- testpass-logout
 * Data is valid - login failed -test fail-
 * 
 * Data is invalid - login success- test fail-logout
 * Data is invalid - login failed -test pass-
 * */
public class TC03_LoginDataDrivenTest extends BaseClas {

	@Test(dataProvider="LoginData",dataProviderClass=DatProviders.class,groups="datadriven")//this to get dataprovider classfrom different class

	public void verify_LoginDDT(String email, String pwd,String exp) {
		
		try
		{

		// home page
		HomePage Hm = new HomePage(driver);
		Hm.clickmyaccount();
		Hm.clicklogin();

		// Login Page
		LoginPage lp = new LoginPage(driver);
		lp.email(email);
		lp.password(pwd);
		lp.login();

		// MyAccountPage
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetpage = mp.ismyaccountpageexist();
		// Assert.assertEquals(targetpage, true,"Login failed");
		
		
		/*Data is valid - login success- testpass-logout
		 * Data is valid - login failed -test fail-
		 * 
		 * Data is invalid - login success- test fail-logout
		 * Data is invalid - login failed -test pass-
		 * */
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				mp.clicklogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				mp.clicklogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		

	
	}

}
