package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search extends BaseClass {
	
	WebDriver driver;

	public Search(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder=\"Search\"]")
	WebElement searchbox;
	@FindBy(xpath="//span[@class=\"input-group-btn\"]//button[@type=\"button\"]")
	WebElement clksearch;//added in step 6
	@FindBy(xpath="//div[@id=\"content\"]//h1[contains (text(),\"Search - iphone\")]")
	WebElement ressearch;
	
	
	
	public void searchbox(String search)
	{
	searchbox.sendKeys(search);
	}
	
	public void clicksearch()
	{
		clksearch.click();
	}
	
	public boolean ressearch()
	{
		try {
			return (ressearch.isDisplayed());
		} catch (Exception e) {
			return false;

		}
	}
	


}
