package com.trello.qspiders.datadriventesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataMining {
	public static void main(String[] args) {
		List<String> dayOptions=new ArrayList<String>();
		List<String> monthOptions=new ArrayList<String>();
		List<String> yearOptions=new ArrayList<String>();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/signup");
		List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
		// System.out.println(allDropDowns.size());
		for (WebElement dropdown : allDropDowns) {
			if (dropdown.isDisplayed()) {
				Select dropdownSelect = new Select(dropdown);
				if (dropdown.getAttribute("title").equals("Day")) {
					List<WebElement> allDropDownOptions = dropdownSelect.getOptions();
					for (WebElement option : allDropDownOptions) {
						dayOptions.add(option.getText());
					}
					
				} else if (dropdown.getAttribute("title").equals("Month")) {
					
					List<WebElement> allDropDownOptions = dropdownSelect.getOptions();
					for (WebElement option : allDropDownOptions) {
						monthOptions.add(option.getText());
					}
					System.out.println();
				} else if (dropdown.getAttribute("title").equals("Year")) {
					List<WebElement> allDropDownOptions = dropdownSelect.getOptions();
					for (WebElement option : allDropDownOptions) {
						yearOptions.add(option.getText());
					}
					
				}
				
			} else {
				System.out.println("Drop Down is not visible.");
			}
		}
		System.out.println(dayOptions);
		System.out.println(monthOptions);
		System.out.println(yearOptions);
		driver.quit();
	}
}
