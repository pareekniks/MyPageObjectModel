package com.qa.hubspot.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static String TEST_DATA_PATH = "C:\\Users\\nikhilpareek\\eclipse-workspace\\POMSeries\\src\\main\\java\\com\\qa\\hubspot\\testdata\\HubSpotTestData.xlsx";
	public static Workbook book;
	public static Sheet sheet;

	public static Object[][] getData(String SheetName) {

		try {
			FileInputStream fs = new FileInputStream(TEST_DATA_PATH);
			book = WorkbookFactory.create(fs);
			sheet = book.getSheet(SheetName);
			Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {

				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				}

			}
			return data;

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
