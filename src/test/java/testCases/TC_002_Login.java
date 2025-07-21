package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LogInPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utils.ConfigrationReader;

public class TC_002_Login extends BaseClass {

	
	@Test
	public void verifyLogin() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.clickLogin();
		LogInPage login = new LogInPage(driver);
		login.settxtEmail(ConfigrationReader.readDataFromConfigFile("email"));
		login.settxtPassword(ConfigrationReader.readDataFromConfigFile("password"));
		login.clickLoginBtn();
		MyAccountPage myAccount = new MyAccountPage(driver);
		boolean loginVerification=myAccount.getVerifyLoginSucess().isDisplayed();
		

	Assert.assertTrue(loginVerification,"Login unsucess");
		
	}
}
