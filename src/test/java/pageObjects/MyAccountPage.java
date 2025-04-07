package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BaseClass {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id=\"content\"]//h2[contains(text(),\"My Account\")]")
	WebElement header;
	@FindBy(xpath="//div[@class=\"list-group\"]//a[contains(text(),\"Logout\")]")
	WebElement clklogout;//added in step 6

	public boolean ismyaccountpageexist() {
		try {
			return (header.isDisplayed());
		} catch (Exception e) {
			return false;

		}
	}
	public void clicklogout() {
		clklogout.click();
	}
}
