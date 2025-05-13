package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddCartAfterSearch;
import pageObjects.Checkout;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Search;
import testBase.BaseClas;

public class TC06_Checkout extends BaseClas
{
	@Test(groups={"sanity","Master"})
	public void Checkout_Test() throws IOException, InterruptedException {
		
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
		
		//search functionality
		
		
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
		
		//add cart
		AddCartAfterSearch ad = new AddCartAfterSearch(driver);
		ad.clickaddcart();
		
		
		
		//checkout
		Checkout ch = new Checkout(driver);
		
		Thread.sleep(2000);
		ch.clickcart();
		Thread.sleep(2000);
		ch.checkout();
		
		ch.checkoutmessage();
		
		
		
		
		

	}


}
