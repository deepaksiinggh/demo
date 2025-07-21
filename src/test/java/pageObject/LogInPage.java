package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BaseTest {

	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="Email")
     private WebElement txtEmail;
	
	@FindBy(id="Password")
	private WebElement txtPassword;
	
	@FindBy(css = ".button-1.login-button")
	private WebElement btnLogIn;
	
	
	public void settxtEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void settxtPassword(String password) {
		txtEmail.sendKeys(password);
	}
	
	public WebElement gettxtEmail() {
		return txtEmail;
	}
	public WebElement gettxtPassword() {
		return txtPassword;
	}
	
	public void clickLoginBtn() {
		btnLogIn.click();
	}
	

	
}
