package demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LearningAdvanceReport {
	
	
	public static void main(String[]args) {
		
		

		
		//Create A SparkReport
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/report.html");
		
		//Configure The SparkReport Information
		spark.config().setDocumentTitle("Regression Testing  for the  Swag Labs");
		spark.config().setReportName("RegressionSuite");
		spark.config().setTheme(Theme.STANDARD);
		
		
		//Create the Extent Report
		
		ExtentReports report= new ExtentReports();
		
		//Attach THe Spark Report and  Extent Report
		report.attachReporter(spark);
		
		//Configure the system Information in Extent Report
		report.setSystemInfo("DeviceName:", "Kalyani");
		report.setSystemInfo("OperatingSystem:", "MacBook Air");
		report.setSystemInfo("Browser:", "chrome");
		report.setSystemInfo("BrowserVerision", " chromeVersion- 138.0.7204.169 ");
		
		//create the Test Information
		ExtentTest test=report.createTest("Regressiontest");
		
		
		//Steps Information
		
		test.log(Status.INFO, "Step1:Launching The Browser Successfully");
		
		test.log(Status.INFO, "Step2:Navigating To Appplication via Url Successfully");
		
		test.log(Status.PASS, "Step3:Verified the Webpage  Successfully");
		
		
		if(true==true) {
			

		test.log(Status.PASS, "Step4:Verified The WebElements Is Displayed");
		}
		
		else {
			test.log(Status.FAIL, "Step4:Verified The WebElements Is  Not Displayed");
		}
			
		test.log(Status.SKIP, "Step5: Element IS Hidden");
		
		
		//FLush The Report 
		report.flush();
		System.out.println("execution done");
		
		
		
		
		
		
		
	}

}
