package com.tutorialsninja.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static FileInputStream fileIn;
	public static FileOutputStream fileOut;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fileIn = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fileIn);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		fileIn.close();
		return data;

	}
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{
	    fileIn = new FileInputStream(xlfile);
	    workbook = new XSSFWorkbook(fileIn);
	    sheet = workbook.getSheet(xlsheet);

	    int rowcount = sheet.getLastRowNum();

	    workbook.close();
	    fileIn.close();

	    return rowcount;
	}
}
