package agilecrm;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakesScreenShot extends BaseClass {
	public TakesScreenShot(String dstFilePath) {
		try {
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		File srcFile=screenShot.getScreenshotAs(OutputType.FILE); 
		File dstFile= new File(dstFilePath);
		FileUtils.copyFile(srcFile, dstFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
