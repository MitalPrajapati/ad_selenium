package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/** 
	 * this method is used to read data from Excel file by using data formatter
	 * @param SheetName
	 * @param RowNum
	 * @param CellNum
	 * @return
	 * @throws Throwable
	 * @author Mital
	 */
	public String getExcelDataUsingFormatter(String SheetName, int RowNum, int CellNum) throws Throwable {
		FileInputStream fis2 = new FileInputStream("C:\\Users\\Mitu\\Desktop\\Selenium\\Ad. selenium Qspi\\vtiger_data.xlsx");
		Workbook w = WorkbookFactory.create(fis2);
		Sheet sheet = w.getSheet(SheetName);
		Row row = sheet.getRow(RowNum);
		Cell cel = row.getCell(CellNum);
		DataFormatter format = new DataFormatter();
		String exceldata = format.formatCellValue(cel);
		return exceldata;	
	}
	
	/**
	 * this method is used to read data from Excel file
	 * @param SheetName
	 * @param RowNum
	 * @param CellNum
	 * @return
	 * @throws Throwable
	 * @author Mital
	 */
	public String getExcelData(String SheetName, int RowNum, int CellNum) throws Throwable {
		FileInputStream fis2 = new FileInputStream("C:\\Users\\Mitu\\Desktop\\Selenium\\Ad. selenium Qspi\\vtiger_data.xlsx");
		Workbook w = WorkbookFactory.create(fis2);
		Sheet sheet = w.getSheet(SheetName);
		Row row = sheet.getRow(RowNum);
		Cell cel = row.getCell(CellNum);
		String exceldata = cel.getStringCellValue();
		return exceldata;
	}
	
	/**
	 * this method is used to read multiple data from Excel file
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 * @author Mital 
	 */
	
	public Object[][] getDataProviderData(String SheetName) throws Throwable 
	{
		FileInputStream fis2 = new FileInputStream("C:\\Users\\Mitu\\Desktop\\Selenium\\Ad. selenium Qspi\\vtiger_data.xlsx");
		Workbook w = WorkbookFactory.create(fis2);
		Sheet sheet = w.getSheet(SheetName);
		int lastRow = sheet.getLastRowNum() + 1;
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				objArr[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return objArr;
		
	}
}
