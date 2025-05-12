package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.Search;
import testBase.BaseClas;

public class TC04_Search extends BaseClas{
	
	@Test(groups={"sanity","Master"})
	public void verify_search() throws IOException {
		
		try
		{

		
		//home page
		/*HomePage Hm = new HomePage(driver);
		Hm.clickmyaccount();
		Hm.clicklogin();*/

		//Login Page
		LoginPage lp = new LoginPage(driver);
		lp.Myaccount();
		lp.intiallogin();
		lp.email(p.getProperty("email"));
		lp.password(p.getProperty("password"));
		lp.login();
		
		//search
		
		
		Search se = new Search(driver);
		se.searchbox(p.getProperty("search"));
		se.clicksearch();
		
		
		boolean targetpage = se.ressearch();
		//Assert.assertEquals(targetpage, true,"Login failed");
		Assert.assertTrue(targetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		

	}

}
