package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationpage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClas;

public class TC02_LoginToMyAccount extends BaseClas {
	@Test(groups={"sanity","Master"})
	public void verify_login_account() throws IOException {
		
		
		try
		{

		
		//home page
		HomePage Hm = new HomePage(driver);
		Hm.clickmyaccount();
		Hm.clicklogin();

		//Login Page
		LoginPage lp = new LoginPage(driver);
		lp.email(p.getProperty("email"));
		lp.password(p.getProperty("password"));
		lp.login();
		
		//MyAccountPage
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetpage = mp.ismyaccountpageexist();
		//Assert.assertEquals(targetpage, true,"Login failed");
		Assert.assertTrue(targetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		

	}

}
