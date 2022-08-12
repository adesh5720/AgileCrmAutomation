package agilecrm;

import org.openqa.selenium.By;

public class LoginPage extends BaseClass {

	public void loginPage(String userName, String password) {
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	
	public void logout() {
		driver.findElement(By.id("fat-menu")).click();
		driver.findElement(By.xpath("//a[@href='/login?sur=true']")).click();
	}
	

}
