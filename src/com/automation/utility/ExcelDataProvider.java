package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	public XSSFWorkbook xb;
	//This constructor will load the excel as soon as we create an object of this class.
	public ExcelDataProvider()
	{
		File src = new File("./TestData/TestData.xlsx");
		
		try 
		{
			FileInputStream fis =  new FileInputStream(src);  //This will convert this file into raw data
			xb = new XSSFWorkbook(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to read excel file. "+e.getMessage()); //e.getMessage() will print the exception
		}
	}
	
	public String getStringData(String sheetName, int row, int cell)    //By sheet name we can do via getSheetIndex() also
	{
		return xb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int row, int cell)    //this will return a double
	{
		return xb.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
	}
}
