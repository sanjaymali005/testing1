package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFWorkbook wBook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	public static void setExcelPath(String sheetName, String path) throws IOException 
	{
		FileInputStream fis = new FileInputStream(path);
		wBook = new XSSFWorkbook(fis);
		sheet = wBook.getSheet(sheetName);
		
	}
	public static String getCellData(int rownum, int colnum) {
		String stringCellData;
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		stringCellData = cell.getStringCellValue();
				
		return stringCellData;
				
	}
	
	public static String[][] getExcelTable(){
		
		int numOfRows = sheet.getLastRowNum();
		int numOfClos = 2;
		int ci,cj;
		ci=1;
		cj=0;
		
		String [][] excelData = new String[numOfRows][numOfClos];
		
		for(int i=0; i<numOfRows; i++,ci++) {
			cj=0;
			for(int j=0; j<numOfClos; j++,cj++) {
				
				excelData[i][j] = getCellData(ci, cj);
}
		}
		return excelData;
	}
	
	public static void setExcelData(int rownum, int colnum, String data) throws Exception 
	{
	row = sheet.getRow(rownum);
	cell = row.getCell(colnum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
	if(cell== null) {
		cell=row.createCell(colnum);
		cell.setCellValue(data);
	}
	else {
		cell.setCellValue(data);
	}
	FileOutputStream fos= new FileOutputStream("C:\\Users\\A06438_P5.Training\\Desktop\\Selenium Drivers\\SeleniumTestData.xlsx");
	wBook.write(fos);
	fos.flush();
	fos.close();
	

	}
	
}
