package Utilities;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public void writeExcel(String[][] arr, String path) throws IOException {
		FileOutputStream file = new FileOutputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Year");
		for(int i = 0; i < arr.length; i++) {
			XSSFRow row = sheet.createRow(i);
			for(int j = 0; j < arr[i].length; j++) {
				XSSFCell cell = row.createCell(j);
				cell.setCellValue(arr[i][j]);
			}
		}
		wb.write(file);
		wb.close();
		file.close();
	}
	
}
