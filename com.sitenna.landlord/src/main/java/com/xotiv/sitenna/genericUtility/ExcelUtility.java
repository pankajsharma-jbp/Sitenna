package com.xotiv.sitenna.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String readTheString(String sheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\Sitenna_TestCase_Data (2).xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		String value = cell.getStringCellValue();
		return value;
	}

}
