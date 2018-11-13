package commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public static Object[][] readExcel(String path) throws IOException, InvalidFormatException {
		int totalRowNum, totalCellNum;
		Object[][] tabArray = null;

		Workbook workbook = WorkbookFactory.create(new File(path));
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

		Iterator<Sheet> sheetIterator = workbook.sheetIterator();
		System.out.println("Retrieving Sheets using Iterator");

		while (sheetIterator.hasNext()) {
			Sheet sheet = sheetIterator.next();
			System.out.println("=> " + sheet.getSheetName());
		}
		Sheet sheet = workbook.getSheetAt(0);
		totalRowNum = sheet.getPhysicalNumberOfRows();
		DataFormatter dataFormatter = new DataFormatter();
		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			totalCellNum = row.getLastCellNum();
			if (tabArray == null) {
				tabArray = new String[totalRowNum - 1][totalCellNum - 1];
			}
			if (row.getRowNum() == 0) {
				continue;
			} else {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String cellValue = dataFormatter.formatCellValue(cell);
					if (cell.getColumnIndex() == 0) {
						continue;
					} else {
						tabArray[row.getRowNum() - 1][cell.getColumnIndex() - 1] = cellValue;
					}
				}
			}
		}
		workbook.close();
		return tabArray;
	}

	public static void writeData(int index, String value) {
		try {
			File file = new File(".//resources//TestData.xlsx");
			InputStream input = new FileInputStream(file);
			Workbook workbook = WorkbookFactory.create(input);
			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(index);
			Cell cell = row.getCell(3);
			if (cell == null) {
				cell = row.createCell(3);
			}
			cell.setCellValue(value);
			FileOutputStream output = new FileOutputStream(file);
			workbook.write(output);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		}
	}
}
