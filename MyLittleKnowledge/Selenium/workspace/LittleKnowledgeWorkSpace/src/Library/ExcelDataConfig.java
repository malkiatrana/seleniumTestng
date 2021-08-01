package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utility.ConfigReader;

/**
 * Author: @(Malkiat)
 * 
 */
public class ExcelDataConfig {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelDataConfig(String excelpath) {

		try {
			// Specify the path of file
			File src = new File(excelpath);

			// Convert file into input stream
			FileInputStream fis = new FileInputStream(src);

			// Load workbook
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}

	public String getData(int sheetNumber, int row, int column) {

		// Load sheet
		sheet = wb.getSheetAt(sheetNumber);

		// getRow() specify which row we want to read.
		// and getCell() specify which column to read.
		// getStringCellValue() specify that we are reading String data.
		String data = sheet.getRow(row).getCell(column).getStringCellValue();

		return data;

	}
	
 public void writedata(String excelpath,String name) throws IOException {
	    Object[][] bookData = {
                {name},
            
        };
    
	    int rowCount = 3;
	    for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);
             
            int columnCount = 2;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(+columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
             
        }
    	File src = new File(excelpath);
        try (FileOutputStream outputStream = new FileOutputStream(src)) {
            wb.write(outputStream);
        }
		
    }



	
	public int getDatanumber(int sheetNumber, int row, int column) {

		// Load sheet
		sheet = wb.getSheetAt(sheetNumber);

		// getRow() specify which row we want to read.
		// and getCell() specify which column to read.
		// getStringCellValue() specify that we are reading String data.
		int data = (int) sheet.getRow(row).getCell(column).getNumericCellValue();

		return data;

	}


	public int getRowCount(int sheetindex) {

		int row = wb.getSheetAt(sheetindex).getLastRowNum();

		row = row + 1;

		return row;

	}
	
	

}
