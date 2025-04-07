package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this); 
		
	}
	
	@FindBy(xpath ="//input[@placeholder=\"E-Mail Address\"]")
	WebElement email;
	@FindBy(xpath ="//input[@placeholder=\"Password\"]")
	WebElement password;
	
	@FindBy(xpath="//input[@class=\"btn btn-primary\"]")
	WebElement clklogin;
	
	
	
	
	public void email(String mail) {
		email.sendKeys(mail);
	}
	public void password(String pass) {
		password.sendKeys(pass);
	}
	public void login() {
		clklogin.click();
	}

	

}
