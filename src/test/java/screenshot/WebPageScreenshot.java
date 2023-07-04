package screenshot;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebPageScreenshot {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new EdgeDriver();
	String timeStamp = LocalDateTime.now().toString().replace(':', '-');
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.facebook.com/");
	TakesScreenshot ts = (TakesScreenshot)driver;
	File tempFile = ts.getScreenshotAs(OutputType.FILE);
	//String addressOffbScreenshot = tempFile.getAbsolutePath();
	//System.out.println(addressOffbScreenshot);
	//Thread.sleep(30000);
	File destFile = new File("./errorshots/"+timeStamp+"fbscreenshot.png");
	FileUtils.copyFile(tempFile, destFile);
	driver.manage().window().minimize();
	driver.quit();
}
}
