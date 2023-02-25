package com.fb.qa.util;

import org.testng.annotations.Test;

import com.fb.qa.base.Excel_Data_Config;

public class Read_Excel_Data {

	@Test
	public void read_Data() {

		Excel_Data_Config excel =new Excel_Data_Config("C:\\Users\\Admin\\Desktop/UserData.xlsx");
		System.out.println(excel.getData(0, 0, 1));
	}

}
