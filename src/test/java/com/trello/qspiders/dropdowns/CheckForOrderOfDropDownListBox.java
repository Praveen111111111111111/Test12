package com.trello.qspiders.dropdowns;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckForOrderOfDropDownListBox {
public static void main(String[] args) throws Throwable {
	List<String> actualDayList=new ArrayList<String>();
	List<String> actualMonthList=new ArrayList<String>();
	List<String> actualYearList=new ArrayList<String>();
	List<String> expectedDayList=new ArrayList<String>();
	List<String> expectedMonthList=new ArrayList<String>();
	List<String> expectedYearList=new ArrayList<String>();
	FileInputStream fis = new FileInputStream("./src/test/resources/facebookdropdown.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("dropdownoption");
	int firstRowIndex = sheet.getFirstRowNum();
	//System.out.println(firstRowIndex);
	int lastRowIndex = sheet.getLastRowNum();
	//System.out.println(lastRowIndex);
	//int noOfRows = sheet.getPhysicalNumberOfRows();
	for(int i = firstRowIndex;i<=lastRowIndex; i++) {
		short firstCellIndex = sheet.getRow(i).getFirstCellNum();
		//System.out.println(firstCellIndex);
		short cellCountInRow = sheet.getRow(i).getLastCellNum();
		//System.out.println(cellCountInRow);
		for(short j=firstCellIndex; j<cellCountInRow;j++) {
			 String cellType = sheet.getRow(i).getCell(j).getCellType().toString();
			if (cellType.equals("NUMERIC")) {
				long numericValue = (long)sheet.getRow(i).getCell(j).getNumericCellValue();
				if (cellCountInRow==31) {
					expectedDayList.add(String.valueOf(numericValue));
				}else if (cellCountInRow==119) {
					expectedYearList.add(String.valueOf(numericValue));
				}
			}else if (cellType.equals("STRING")) {
				String stringValue = sheet.getRow(i).getCell(j).getStringCellValue();
				//System.out.println(stringValue);
				expectedMonthList.add(stringValue);
			}
		}
	}
	workbook.close();
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.facebook.com/signup");
	List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
	for (WebElement dropdown : allDropDowns) {
		if (dropdown.isDisplayed()) {
			Select dropdownSelect = new Select(dropdown);
			if (dropdown.getAttribute("title").equals("Day")) {
				List<WebElement> allOptions = dropdownSelect.getOptions();
				for (WebElement option : allOptions) {
					actualDayList.add(option.getText());
				}
			}else if (dropdown.getAttribute("title").equals("Month")) {
				List<WebElement> allOptions = dropdownSelect.getOptions();
				for (WebElement option : allOptions) {
					actualMonthList.add(option.getText());
				}
			}else if (dropdown.getAttribute("title").equals("Year")) {
				List<WebElement> allOptions = dropdownSelect.getOptions();
				for (WebElement option : allOptions) {
					actualYearList.add(option.getText());
				}
			}
		}
	}
	System.out.println(expectedDayList);
	System.out.println(actualDayList);
	if (actualDayList.equals(expectedDayList)) {
		System.out.println("Pass: All the Day Dropdown Options are found correct with right order and it is verified.");
	}else {
		System.out.println("Fail: All the Day Dropdown Options are found incorrect with right order and it is verified.");
	}
	System.out.println(expectedMonthList);
	System.out.println(actualMonthList);
	if (actualMonthList.equals(expectedMonthList)) {
		System.out.println("Pass: All the Month Dropdown Options are found correct with right order and it is verified.");
	}else {
		System.out.println("Fail: All the Month Dropdown Options are found incorrect with right order and it is verified.");
	}
	System.out.println(expectedYearList);
	System.out.println(actualYearList);
	if (actualYearList.equals(expectedYearList)) {
		System.out.println("Pass: All the Year Dropdown Options are found correct with right order and it is verified.");
	}else {
		System.out.println("Fail: All the Year Dropdown Options are found incorrect with right order and it is verified.");
	}
	for (WebElement dropdown : allDropDowns) {
		if (dropdown.isDisplayed()) {
			Select dropdownSelect = new Select(dropdown);
			if (dropdown.getAttribute("title").equals("Day")) {
				List<WebElement> allOptions = dropdownSelect.getOptions();
				for (WebElement option : allOptions) {
					dropdownSelect.selectByVisibleText(option.getText());
					if (option.isSelected()) {
						System.out.println(option.getText() + "is Selected.");
					}else {
						System.out.println(option.getText() + "is not Selected.");
					}
				}
			}else if (dropdown.getAttribute("title").equals("Month")) {
				List<WebElement> allOptions = dropdownSelect.getOptions();
				for (WebElement option : allOptions) {
					dropdownSelect.selectByVisibleText(option.getText());
					if (option.isSelected()) {
						System.out.println(option.getText() + "is Selected.");
					}else {
						System.out.println(option.getText() + "is not Selected.");
					}
				}
			}else if (dropdown.getAttribute("title").equals("Year")) {
				List<WebElement> allOptions = dropdownSelect.getOptions();
				for (WebElement option : allOptions) {
					dropdownSelect.selectByVisibleText(option.getText());
					if (option.isSelected()) {
						System.out.println(option.getText() + "is Selected.");
					}else {
						System.out.println(option.getText() + "is not Selected.");
					}
				}
			}
		}
		
	}
	driver.manage().window().minimize();
	driver.quit();
}
}
