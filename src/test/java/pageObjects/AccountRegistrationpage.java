package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationpage extends BaseClass {
	public AccountRegistrationpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id=\"input-firstname\"]")
	WebElement firstName;

	@FindBy(xpath = "//input[@id=\"input-lastname\"]")
	WebElement lastname;

	@FindBy(xpath = "//input[@id=\"input-email\"]")
	WebElement email;

	@FindBy(xpath = "//input[@id=\"input-telephone\"]")
	WebElement phone;

	@FindBy(xpath = "//input[@id=\"input-password\"]")
	WebElement password;

	@FindBy(xpath = "//input[@id=\"input-confirm\"]")
	WebElement confirmpassword;

	@FindBy(xpath = "//input[@name=\"agree\"]")
	WebElement agreebox;
	@FindBy(xpath = "//input[@value=\"Continue\"]")
	WebElement contnue;

	@FindBy(xpath = "//div[@id=\"content\"]//h1")
	WebElement message;

	public void firstname(String fname) {
		firstName.sendKeys(fname);
	}

	public void lastname(String lname) {
		lastname.sendKeys(lname);
	}

	public void email(String emai) {

		email.sendKeys(emai);
	}

	public void phonenumber(String tel) {
		phone.sendKeys(tel);
	}

	public void password(String pa) {
		password.sendKeys(pa);
	}

	public void confirmpass(String cps) {
		confirmpassword.sendKeys(cps);
	}

	public void agreebox() {
		agreebox.click();
	}

	public void continu() {
		contnue.click();
	}

	public String getconfirmationmessage() {
		try {
			return (message.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}

}
