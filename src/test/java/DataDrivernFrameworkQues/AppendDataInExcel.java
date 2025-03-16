package DataDrivernFrameworkQues;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class AppendDataInExcel {

	@Test
	public void writeData() throws IOException {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\DataDrivernFrameworkQues\\WriteData.xlsx";
		Object[][] newData = {
				{"John", "Doe", 30, "New York"},
				{"Alice", "Smith", 28, "Los Angeles"}
		};
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("Sheet2");

		int last=sheet.getLastRowNum();
		for(int i=0;i<newData.length;i++) {
			Row row=sheet.createRow(++last);
			for(int j=0;j<newData[i].length;j++) {
				Cell cell=row.createCell(j);
				cell.setCellValue(newData[i][j].toString());
			}
		}
		fis.close();
		FileOutputStream fiss = new FileOutputStream(filePath);
		workbook.write(fiss);
		fiss.close();
		workbook.close();
		
	}

}
