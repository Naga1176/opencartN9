package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends BaseClass 
{
WebDriver driver;
	
	public Checkout(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id=\"cart\"]")
	WebElement clickcart;
	
	@FindBy(xpath="//p[@class=\"text-right\"]//a[2]")
	WebElement checkout;
	@FindBy(xpath="//div[@class=\"alert alert-danger alert-dismissible\"]")
	WebElement checkoutmessage;
	
	
	
	public void clickcart()
	{
		clickcart.click();
	}
	public void checkout()
	{
		checkout.click();
	}
	
	public boolean checkoutmessage()
	{
		try {
			return (checkoutmessage.isDisplayed());
		} catch (Exception e) {
			return false;

		}
	}
	
	

}
