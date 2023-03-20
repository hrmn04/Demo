package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Elements
	@FindBy(xpath = "//span[text() = 'My Account']") WebElement linkMyAcct;
	@FindBy(linkText = "Register") WebElement linkRegister;
	
	//Action Methods
	public void clickMyAcct()
	{
		linkMyAcct.click();

	}
	
	public void clickRegister() {
		linkRegister.click();
	}
}
