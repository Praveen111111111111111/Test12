package handlingframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class IndividualFrames {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
	driver.switchTo().frame("packageListFrame");
	driver.findElement(By.xpath("//li/a[text()='org.openqa.selenium']")).click();
	Thread.sleep(4000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("packageFrame");
	driver.findElement(By.xpath("//span[text()='Alert']")).click();
	Thread.sleep(2000);
	driver.manage().window().minimize();
	driver.quit();
}
}
