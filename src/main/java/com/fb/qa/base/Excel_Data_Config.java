package com.fb.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Data_Config {

	XSSFWorkbook workbook;
	XSSFSheet sheet1;
	
	public Excel_Data_Config(String excelPath) {
		
		try {
			File file = new File(excelPath);
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getData(int sheetNumber, int row, int column) {
		sheet1 = workbook.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetIndex) {
		int row = workbook.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		return row;
	}
}

