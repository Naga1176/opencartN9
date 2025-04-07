package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {
	WebDriver driver;

	public HomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this); 
	}

	@FindBy(xpath = "//span[contains(text(),\"My Account\")]")
	 WebElement Myaccount;
	@FindBy(xpath = "//ul[@class=\"dropdown-menu dropdown-menu-right\"]//li//a[contains(text(),\"Register\")]")
	 WebElement Register;
	
	@FindBy(xpath = "//ul[@class=\"dropdown-menu dropdown-menu-right\"]//li[2]//a")
	 WebElement lnkLogin;//loginlink

	public void clickmyaccount() 
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      //  wait.until(ExpectedConditions.elementToBeClickable(Myaccount)).click();

		Myaccount.click();
	}

	public void clickrigister() 
	{
		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        //wait.until(ExpectedConditions.elementToBeClickable(Register)).click();
		Register.click();
	}
	
	public void clicklogin()
	{
		lnkLogin.click();
	}

}
