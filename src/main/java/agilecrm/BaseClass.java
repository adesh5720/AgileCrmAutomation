package agilecrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static WebDriver driver;
	public static ExtentTest Logger;
	public String executionReports;
	public String methodName;
	public static void launchBrowser(String browser)
	{
		switch (browser) {
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "mozilla" :
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		case "edge" :
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		default :
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				
		}
	}
}