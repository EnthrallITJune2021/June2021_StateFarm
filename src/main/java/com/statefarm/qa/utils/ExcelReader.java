package com.statefarm.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	Workbook workbook;
	Sheet sheet;
	
	public ExcelReader(String fileName, String sheetName) {
		try {
			if (fileName.endsWith(".xls")) {
				workbook = new HSSFWorkbook(new FileInputStream(fileName));
				sheet = (HSSFSheet) workbook.getSheet(sheetName);
			} else if (fileName.endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(new FileInputStream(fileName));
				sheet = (XSSFSheet) workbook.getSheet(sheetName);
			} else {
				System.out.println("File not supported");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}
	
	public Object[][] dataTable(){
		Object[][] data = {};
		int numberOfRows = sheet.getLastRowNum();
		int numberOfCells = sheet.getRow(0).getLastCellNum();
		data = new String[numberOfRows][numberOfCells];
		DataFormatter dataFormatter = new DataFormatter();
		for(int i = 0; i < numberOfRows; i++ ) {
			Row row = sheet.getRow(i+1);
			for (int j = 0; j < numberOfCells; j++) {
				Cell cell = row.getCell(j);
				String value = dataFormatter.formatCellValue(cell);
				data[i][j] = value;
			}
		}		
		return data;
	}
	
}
