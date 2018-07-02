package Automation;

import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class generalActions {
	public String generateRandomEmail() {
		String randomEmail = String.valueOf(System.currentTimeMillis()) + "@gmail.com";
		return randomEmail;
	}

	public void waitForControlStable(WebElement element) {
		try {
			Thread.sleep(1000);
			int count = 0;
			while (element.isDisplayed() == false && count <= 15) {
				Thread.sleep(1000);
				count++;
			}
			while (element.isEnabled() == false && count <= 15) {
				Thread.sleep(1000);
				count++;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebElement waitForControlDisplay(WebElement element) {
		try {
			Thread.sleep(1000);
			int count = 0;
			while (element.isDisplayed() == false && count <= 15) {
				System.out.println(element.isDisplayed());
				Thread.sleep(1000);
				count++;
			}
			while (element.isEnabled() == false && count <= 15) {
				System.out.println(element.isEnabled());
				Thread.sleep(1000);
				count++;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}

	public boolean checkControlDisplay(WebElement element) {
		boolean check1 = element.isDisplayed();
		return check1;
	}

	public void waitForControlNotDisplay(WebElement element) {
		try {
			Thread.sleep(1000);
			int count = 0;
			while (element.isDisplayed() == true && count <= 10) {
				System.out.println(element.isDisplayed());
				Thread.sleep(1000);
				count++;
			}
		} catch (InterruptedException e) {

		}
	}

	public WebElement dynamicXpath(String str1, String xpath1) {
		String newXpath = xpath1.replace("{0}", str1);
		return Constant.WEBDRIVER.findElement(By.xpath(newXpath));
	}

	public String getExcelCellValue(String excelFilepath, String sheetName, int row, int column)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		int sheetIndex = 0;

		Workbook workbook = WorkbookFactory.create(new File(excelFilepath));

		if (sheetName != "") {
			int temp = 0;
			for (Sheet sheet : workbook) {
				if (sheetName.equals(sheet.getSheetName())) {
					sheetIndex = temp;
					break;
				}
				temp++;
			}
		}

		Sheet sheet = workbook.getSheetAt(sheetIndex);
		DataFormatter dataFormatter = new DataFormatter();

		Row rowCell = sheet.getRow(row);
		Cell cell = rowCell.getCell(column);

		workbook.close();

		return dataFormatter.formatCellValue(cell);
	}

	public Object[][] getDataFromFile(String filePath, String sheetName) throws IOException {
		Object[][] obj;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Ko file");
		}
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row0 = sheet.getRow(0);
		int colNum = row0.getLastCellNum();
		int rowNum = sheet.getLastRowNum() + 1;
		System.out.println("Row: " + rowNum);
		System.out.println("Col: " + colNum);
		obj = new Object[rowNum - 1][colNum];

		for (int i = 1; i < rowNum; i++) {
			for (int j = 1; j <= colNum; j++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(j - 1);
				obj[i - 1][j - 1] = cell.getStringCellValue();
			}
		}

		workbook.close();
		return obj;
	};
}
