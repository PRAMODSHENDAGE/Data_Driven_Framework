package com.fb.qa.util;

public class Read_Excel_Data {

	public static void main(String[] args) {

		Excel_Data_Config excel =new Excel_Data_Config("C:\\Users\\Admin\\Desktop/UserData.xlsx");
		System.out.println(excel.getData(0, 0, 1));
	}

}
