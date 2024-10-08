package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class D15ReadingData {
	String fPath = "ExcelFiles\\LoginData.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	//@Test
	public void getData() {
		row = sheet.getRow(0);
		cell = row.getCell(0);
		
		System.out.println(cell.getStringCellValue());
		
		System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
		System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());
		System.out.println(sheet.getRow(0).getCell(2).getStringCellValue());
	}
	
	@Test
	public void getAllData()
	{
		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i = 0; i < totalRows; i++)
		{
			row = sheet.getRow(i);
			for(int j = 0; j < totalCells; j++)
			{
				cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
			}
			System.out.println();
		}
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new  XSSFWorkbook(fis);
		//While reading the data from Workbook pass the fileinputstream object
		//Because we are not supposed to create the workbook
		//rather we are just reading the workbook which is already present.
		sheet = wb.getSheet("Login Data");
		//Why getSheet()? because we are not supposed to create the sheet
		//rather we are going to read the sheet
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.close();
		fis.close();
	}

}
