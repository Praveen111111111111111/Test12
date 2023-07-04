package handlingframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PlayWithFrames {
public static void main(String[] args) {
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
	WebDriver prentFrame = driver.switchTo().frame("iframeResult");
	driver.switchTo().frame(0);
	WebElement textWithinChildFrame = driver.findElement(By.tagName("h1"));
	String childText = textWithinChildFrame.getText();
	System.out.println("childText= " + childText);
	driver.switchTo().parentFrame();
	String parentText = driver.findElement(By.xpath("//body/p")).getText();
	System.out.println("parentText = " + parentText);
	driver.manage().window().minimize();
	driver.quit();
}
}
