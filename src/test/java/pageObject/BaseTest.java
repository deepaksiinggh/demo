package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {
 WebDriver driver ;
	public BaseTest(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
}
