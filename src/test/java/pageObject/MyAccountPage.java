package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BaseTest{
	
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(partialLinkText = "Log out")
	WebElement verifyLoginSucess;
	
	public WebElement getVerifyLoginSucess() {
		return verifyLoginSucess;
	}

}
