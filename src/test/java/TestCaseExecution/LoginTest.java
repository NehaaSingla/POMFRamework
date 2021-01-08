package TestCaseExecution;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.BrowserSetup;
import BaseClass.log;
import PageObjectRepository.login;

public class LoginTest extends BrowserSetup {
	
	WebDriver driver;
	static login lg;
	
	//builds a new report using the html template 
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    //helps to generate the logs in test report.
    ExtentTest test;

	
	@BeforeTest
	public void startreport(){
		htmlReporter =  new ExtentHtmlReporter(System.getProperty("user.dir") + "//extendedreport//report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("OS", "WINDOW 10");
		extent.setSystemInfo("JAVA", "1.8");
		extent.setSystemInfo("BROWSER", "CHROME");
		extent.setSystemInfo("TESTER NAME", "NEHA");
		
		htmlReporter.config().setDocumentTitle("SELENIUM AUTOMATION");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("EXTENDED REPORT");
		
	}
	
	@BeforeMethod
	public void openbrowser() throws InterruptedException{
		DOMConfigurator.configure("C:\\Users\\neha\\workspace\\POMFramework\\Logs\\log4j.xml");
		driver= BrowserSetup.StartBrowser("Chrome", "https://www.ck12.org/student/");
		log.info("Browser opened successfully");
		
	}
	
	@Test
	public void logintest() throws InterruptedException{
		log.startTestCase("Test Case Started");
		test = extent.createTest("logintest");
		
		lg =  new login(driver);
		Thread.sleep(2000);
		lg.getSignInButton();
		log.info("User clicked on Sign Button");
		lg.setUserName("chatterjeeamit42@gmail.com");
		log.info("User enters UserName");
		lg.setPassword("Testing123$");
		log.info("User enters password");
		Thread.sleep(1000);
		lg.getLoginButton();
		Thread.sleep(1000);
		log.endTestCase("Test Case Ended");
	}
	
	@AfterMethod
    public void getResult(ITestResult result) {
		
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
     
    @AfterTest
    public void tearDown() {
    	//to write or update test information to reporter
        extent.flush();
        driver.close();
    }
}

	/*@AfterMethod
	public void closeBrowser(){
		lg.TearDown();
		
	}*/


