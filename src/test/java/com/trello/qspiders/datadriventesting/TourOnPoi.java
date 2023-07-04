package com.trello.qspiders.datadriventesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TourOnPoi {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/facebookdropdown.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("dropdownoption");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println("noOfRowsUsed = " + noOfRows);
		int firstRowIndex = sheet.getFirstRowNum();
		System.out.println("firstRowIndex = " + firstRowIndex);
		int lastRowIndex = sheet.getLastRowNum();
		System.out.println("lastRowIndex = " + lastRowIndex);
		// Study day row
		short dayRowCellCount = sheet.getRow(0).getLastCellNum();
		System.out.println("dayRowCellCount = " + dayRowCellCount);
		short firstDayCellNum = sheet.getRow(0).getFirstCellNum();
		System.out.println("firstDayCellNum = " + firstDayCellNum);
		// Study month row
		short monthRowCellCount = sheet.getRow(1).getLastCellNum();
		System.out.println("monthRowCellCount = " + monthRowCellCount);
		// cell type in day row
		CellType whoAreU = sheet.getRow(0).getCell(0).getCellType();
		System.out.println(whoAreU);
		if (whoAreU.equals("NUMERIC")) {
			long numericValue = (long)sheet.getRow(0).getCell(0).getNumericCellValue();
			System.out.println(numericValue);
		}else if (whoAreU.equals("STRING")) {
			String stringValue = sheet.getRow(0).getCell(0).getStringCellValue();
			System.out.println(stringValue);
		}
		workbook.close();
	}
}
