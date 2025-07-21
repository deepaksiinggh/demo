package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterUtility implements ITestListener {
	
	ExtentReports extents;
	ExtentSparkReporter spark;
	ExtentTest test;
	String reportFileName;
	@Override
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		reportFileName = "test_report"+timeStamp+".html";
		
		
		spark = new ExtentSparkReporter(".//reports//"+reportFileName);
		spark.config().setDocumentTitle("demo web shop");
		spark.config().setReportName("functional demo webshop testing");
		spark.config().setTheme(Theme.DARK);
		
		
		extents=new ExtentReports();
		extents.attachReporter(spark);
		
		extents.setSystemInfo("Author", "Deepak Singh");
		extents.setSystemInfo("Application", "Demo WebShop");
		extents.setSystemInfo("Enviroment", "QA");
		extents.setSystemInfo("Module", "admin");
		extents.setSystemInfo("SubModule", "user");
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extents.setSystemInfo("Browser",browser);
		
		String os = context.getCurrentXmlTest().getParameter("os");
		extents.setSystemInfo("Operating-System", os);
		
		List<String> groups = context.getCurrentXmlTest().getIncludedGroups();
		if(!groups.isEmpty()) extents.setSystemInfo("Groups", groups.toString());
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test=extents.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=extents.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "method skipped");
	}



	@Override
	public void onFinish(ITestContext context) {
		extents.flush();;
	}

	
}
