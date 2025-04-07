package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationpage;
import pageObjects.HomePage;
import testBase.BaseClas;

public class Tc01_Accountregistrationtest extends BaseClas {
	

	@Test(groups={"Regression","Master"})
	public void verify_account_regestration() {

		 

		HomePage Hm = new HomePage(driver);
		System.out.println("driver"+driver);

		Hm.clickmyaccount();
		Hm.clickrigister();

		AccountRegistrationpage Ar = new AccountRegistrationpage(driver);
		Ar.firstname(randomString().toUpperCase());
		Ar.lastname(randomString().toLowerCase());
		Ar.email(randomString() + "@gmail.com");// randomly generated the email

		String password = randomalphanumeric();

		Ar.phonenumber(randomphnsnumber());
		Ar.password(password);
		Ar.confirmpass(password);
		Ar.agreebox();
		Ar.continu();
		String crm = Ar.getconfirmationmessage();
		Assert.assertEquals(crm, "Your Account Has Been Created!");

	}
	
	

}
