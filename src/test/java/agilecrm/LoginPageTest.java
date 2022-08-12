package agilecrm;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseClass {
	PropertyHandling prop;
	LoginPage login;
	String url;
	String userName;
	String password;
	String blank;
	String invalidUserName;
	String invalidPassword;
	
	@BeforeClass
	@Parameters({"browser"})
	public void login(String browser) {
		
		String configFilePath=System.getProperty("user.dir")+"/config.properties";
		prop=new PropertyHandling(configFilePath);
		
		launchBrowser(browser);
		url=prop.getProperty("url");
		driver.get(url);
		login=new LoginPage();
	}
	
	@Test
	public void testCase1() {
		userName=prop.getProperty("userName");
		password=prop.getProperty("password");
		login.loginPage(userName,password);
		login.logout();
	}
	@Test
	public void testCase2() {
		blank=prop.getProperty("blank");
		login.loginPage(blank,password);
	}
	
	@Test
	public void testCase3() {
		login.loginPage(userName,blank);
	}
	
	@Test
	public void testCase4() {
		login.loginPage(blank,blank);
	}
	
	@Test
	public void testCase5() {
		invalidUserName=prop.getProperty("invalidUserName");
		login.loginPage(invalidUserName,password);
	}
	
	@Test
	public void testCase6() {
		invalidPassword=prop.getProperty("invalidPassword");
		login.loginPage(userName,invalidPassword);
	}
}
