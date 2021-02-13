package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelCitac {
	
	File fajl;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String value;
	
	public ExcelCitac(String filePath) throws IOException {
		fajl = new File(filePath);
		fis = new FileInputStream(fajl);
		wb = new XSSFWorkbook(fis);
	}
	
	
	public String getData(String sheetName, int rowNumber, int columnNumber) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNumber - 1);
		cell = row.getCell(columnNumber - 1);
		if (cell.getCellType() == CellType.NUMERIC) { 
			value = String.valueOf((int) cell.getNumericCellValue());
		} else {
			value = cell.getStringCellValue();
		}
		return value;
	}

	
	
//	public String getStringData(String sheetName, int rowNumber, int columnNumber) {
//		sheet = wb.getSheet(sheetName);
//		row = sheet.getRow(rowNumber-1);
//		cell = row.getCell(columnNumber-1);
//		return  cell.getStringCellValue();
//		
////		DataFormatter formatter = new DataFormatter();
////		String stringCell = formatter.
//	}
//	
//	public int getIntData(String sheetName, int rowNumber, int columnNumber) {
//		sheet = wb.getSheet(sheetName);
//		row = sheet.getRow(rowNumber-1);
//		cell = row.getCell(columnNumber-1);
//		return (int)cell.getNumericCellValue();
//	}
}


