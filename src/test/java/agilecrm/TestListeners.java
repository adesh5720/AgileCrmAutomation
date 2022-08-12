package agilecrm;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	
public class TestListeners extends BaseClass implements ITestListener, ISuiteListener {
	File file;
	ExtentHtmlReporter htmlReport;
	ExtentReports extentReport;
			public void onStart(ISuite suite) {
				
			System.out.println("This is a onStart suite method...");
			String reportFolderPath = System.getProperty("user.dir")+"/ExtentReport";
			createFolder(reportFolderPath);
			// EexecutionReport_6_8_2022_16_48 dd_mm_yyyy_HH mm DateTimeFormatter formatter 
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd MM_yyyy HH_mm"); 
			String dateTime = formatter.format(LocalDateTime.now()); 
			String reportPath = "ExecutionReport_" + dateTime; 
			executionReports= reportFolderPath + "/" + reportPath;
			createFolder(executionReports);
			htmlReport = new ExtentHtmlReporter(reportFolderPath + "/" + reportPath + "/AutomationReport.html");
			extentReport=new ExtentReports();
			extentReport.attachReporter(htmlReport);
			extentReport.setSystemInfo("System", "Windows");
			extentReport.setSystemInfo("User", "System");
			extentReport.setSystemInfo("Env", "Test");
			}
			
			public void onFinish (ISuite suite) {
			System.out.println("This is a onFinish suite method...");
			extentReport.flush();
			}
			
			public void onStart(ITestContext context) {
				System.out.println("This is onTest Start Method...."+context.getName()); 
			}
			
			
			public void onFinish(ITestContext context) {
			System.out.println("This is onTest Finish Method...." +context.getName());
			}
			
			public void onTestStart (ITestResult result) {
			System.out.println("Test execution started for method:" +result.getName());
			Logger = extentReport.createTest(result.getName());
			methodName=result.getName();
			}
			
			public void onTestSuccess (ITestResult result) {
			System.out.println("Method execution completed successfully for:" + result.getName()); 
			Logger.pass(result.getName());
			}
			
			public void onTestFailure (ITestResult result) { 
				System.out.println("Method execution failed for:" +result.getName()); 
				System.out.println("Failure Reason:" + result.getThrowable()); 
				Logger.fail(result.getName()+ " : "+result.getThrowable());
				String filePath=executionReports + "/"+ methodName+".png";
				new TakesScreenShot(filePath);
				try {
					Logger.addScreenCaptureFromPath(filePath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			public void onTestSkipped (ITestResult result) {
			System.out.println("Method skipped and name is: "+result.getName()); 
			Logger.skip(result.getName());
			}
			
			public void createFolder(String filePath) { 
				file= new File(filePath);
			
			if (!file.exists()) {
			file.mkdir();
			}
		}
			
			
	}
			
			