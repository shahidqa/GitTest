package notous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	 public void config()
	 {
		//ExtentReports,ExtentSparkReporter
		
		 String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomation");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "shahid");
		
	 }
	
	@Test
	public void IntialDemoTest()
	{    
		extent.createTest("IntialDemoTest");
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Webdriver_Maven\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://rahulshettyacademy.com");
		driver.getTitle();
		extent.flush();
	}

}
