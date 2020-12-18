package com.qa.flipkart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	private static Workbook book;
	private static Sheet sheet;

	public static Object[][] getData(String sheetName) {

		Object[][] data = null;
		try {
			FileInputStream ip = new FileInputStream(new File(""));
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int row = 0; row < sheet.getLastRowNum(); row++)
				for (int col = 0; col < sheet.getRow(0).getLastCellNum(); col++) {

					data[row][col] = sheet.getRow(row+1).getCell(col).toString();
					
				}

		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

}