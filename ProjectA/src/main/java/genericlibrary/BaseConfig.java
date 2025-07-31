package genericlibrary;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pagerepository.LogOutPage;
import pagerepository.LoginPage;



public class BaseConfig {
	
	public WebDriver driver;
public static WebDriver staticdriver;
	
	public String url;
	public String username;
	public String password;
	public String FirstName;
	public String LastName;
	public String Zipcode;
	
	
	public ExtentSparkReporter spark;
	
    public ExtentReports report;
    public ExtentTest test;
    
    
	@BeforeTest
	public void ReportSetup() {
		
		//Create A SparkReport
				spark=new ExtentSparkReporter("./AdvanceReports/report.html");
				
				//Configure The SparkReport Information
				spark.config().setDocumentTitle("Regression Testing  for the  Swag Labs");
				spark.config().setReportName("RegressionSuite");
				spark.config().setTheme(Theme.STANDARD);
				
				
				//Create the Extent Report
				
				 report= new ExtentReports();
				
				//Attach THe Spark Report and  Extent Report
				report.attachReporter(spark);
				
				//Configure the system Information in Extent Report
				report.setSystemInfo("DeviceName:", "Kalyani");
				report.setSystemInfo("OperatingSystem:", "MacBook Air");
				report.setSystemInfo("Browser:", "chrome");
				report.setSystemInfo("BrowserVerision", " chromeVersion- 138.0.7204.169 ");
				
		
	}
	@AfterTest
	public void ReportTerminate() {
		report.flush();
	}
	
	
	
	@Parameters("BrowserName")

	@BeforeClass
	public void browserSetup(String browser	)  {
		//String browser ="chrome";
		
		//open the browser
		
		driver=WebDriverLibrary.openBrowser(browser);
		staticdriver=driver;
		
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");
		String currentDate = sdf.format(new Date());
		System.out.println(currentDate);
		
		//maximize the Browser
		
		WebDriverLibrary.maximizeBrowser();
				

		
		//Wait Statement
		WebDriverLibrary.waitstatement();
		

		// Navigate to the application via URL
		WebDriverLibrary.navToApp(PropertiesLibrary.readData("url"));
		
		
		//verify the page
		Assert.assertEquals("Swag Labs",driver.getTitle());
		
		//browser opened successfully
		Reporter.log("browser opened successfully", true);
		
	}
	@BeforeMethod
	public void login() throws InterruptedException  {
		//Wait Statement
		WebDriverLibrary.waitstatement();
		//create an object for login page
		LoginPage loginobj=new LoginPage(driver);
		
		//validate the UserName
		Assert.assertTrue(loginobj.getusernametextfield().isDisplayed());

		// Enter UserName in UserName TextField
		WebDriverLibrary.enterTheData(loginobj.getusernametextfield(),PropertiesLibrary.readData("username"));

		
		//validate the password
		Assert.assertTrue(loginobj.getpasswordtextfield().isDisplayed());

		// Enter password in password TextField
		
		WebDriverLibrary.enterTheData(loginobj.getpasswordtextfield(),PropertiesLibrary.readData("password"));

		
		//Click on login button
		WebDriverLibrary.elementClick(loginobj.getloginbutton());
		
		Thread.sleep(9000);
		//login success
		Reporter.log("Login successfully", true);

		
		

		
		FirstName = ExcelLibrary.readData("CO_Details", 1, 0);
		LastName= ExcelLibrary.readData("CO_Details", 1, 1);
		Zipcode = ExcelLibrary.readData("CO_Details", 1, 2);

	}

	@AfterMethod
	public void Logout() {

		//Wait Statement
		WebDriverLibrary.waitstatement();
		

		// Create an object for LogOutPage
		LogOutPage logoutobj = new LogOutPage(driver);
		
		//validate the logout menu
		Assert.assertTrue(logoutobj.getmenubar().isDisplayed());
		
		
		//click on logout MenuBar 
		WebDriverLibrary.elementClick(logoutobj.getmenubar());
		
		

		WebDriverLibrary.waitstatement(logoutobj.getlogout());
		
		
		//validate the logout link
		//Assert.assertTrue(logoutobj.getlogout().isDisplayed());
				
				
		
		//click on logout link
		WebDriverLibrary.elementClick(logoutobj.getlogout());

		

		Reporter.log("Logout is done", true);

	}

	@AfterClass
	public void broserTerminate() {

		// Close the Browser
		WebDriverLibrary.closeAllWindows();

	}

	@DataProvider
	public Object[][] Details() {
		Object[][] data=new Object[1][3];
		data[0][0]=ExcelLibrary.readData("CO_Details", 1, 0);
		data[0][1]=ExcelLibrary.readData("CO_Details", 1, 1);
		data[0][2]=ExcelLibrary.readData("CO_Details", 1, 2);
		return data;
		
		
	}
	
	
	
	
	
}



