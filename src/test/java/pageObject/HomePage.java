package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseTest {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(partialLinkText = "Register")
	private WebElement linkRegister;
	
	@FindBy(partialLinkText = "Log in")
	private WebElement linkLogin;
	
	// click register button
	
	public void clickRegister() {
		linkRegister.click();
	}
	
	// click login button
	
	public void clickLogin() {
		linkLogin.click();
	}
	
	
	
	
}
