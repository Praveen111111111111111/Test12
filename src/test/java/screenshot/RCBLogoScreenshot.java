package screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class RCBLogoScreenshot {
public static void main(String[] args) throws IOException {
	WebDriver driver = new EdgeDriver();
	String timeStamp = LocalDateTime.now().toString().replace(':', '-');
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.royalchallengers.com/");
	WebElement rcbLogo = driver.findElement(By.xpath("//div[@class='hdr-logo']//img"));
	File tempFile = rcbLogo.getScreenshotAs(OutputType.FILE);
	File destFile = new File("./errorshots/"+timeStamp+"rcbLogo.png");
	driver.manage().window().minimize();
	driver.quit();
	FileUtils.copyFile(tempFile, destFile);
}
}
