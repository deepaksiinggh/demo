package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utils.ConfigrationReader;

public class BaseClass {
         public static WebDriver driver;
           
           // launch the browser
           
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) throws IOException {
		switch(browser.toLowerCase()) {
		case "chrome":driver = new ChromeDriver(); break;
		case "firefox":driver=new FirefoxDriver();break;
		case "safari":driver=new SafariDriver();break;
		case "edge":driver=new EdgeDriver();break;
		default: System.out.println("Invalid browser name"); return;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(ConfigrationReader.readDataFromConfigFile("url"));
		
	}
	
	       // close browser
	
	@AfterClass
	public void tearDown() {
		driver.quit();;
	}
	
	
	public String takeScreenShot(String tName) {
		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts =(TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenShots\\"+tName+"_"+timeStamp+".png";
		File targetFile = new File(targetFilePath);
		file.renameTo(targetFile);
		return targetFilePath;
		
		
	}
}
