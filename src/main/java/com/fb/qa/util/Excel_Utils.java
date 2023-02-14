package com.fb.qa.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel_Utils {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public Excel_Utils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook("C:\\Users\\Admin\\Desktop/UserData.xlsx");
			sheet = workbook.getSheet("Sheet1");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public static void getRowCount() {
		try {
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of rows: "+rowCount);
		
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
    }
  }	
	@Test
	public static void getCellDataString(int rowNum, int colNUm) {
		try {
		String cellData = sheet.getRow(rowNum).getCell(colNUm).getStringCellValue();
		System.out.println(cellData);
		
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
	@Test
	public static void getCellDataNumber(int rowNum, int colNUm) {
		try {
		double cellData = sheet.getRow(rowNum).getCell(colNUm).getNumericCellValue();
		System.out.println(cellData);
		
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}

	
