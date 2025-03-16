package DataDrivernFrameworkQues;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class FetchOnlyHeaders {

	
public static Object[][] readData() throws IOException {
		
		
		DataFormatter format = new DataFormatter();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\DataDrivernFrameworkQues\\TestData.xlsx");
		Workbook book=new XSSFWorkbook(file);
		Sheet sheet=book.getSheet("Sheet1");
		int col=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[1][col];
		Row row=sheet.getRow(0);
		for(int i=0;i<col;i++) {
			Cell cell=row.getCell(i);
			data[0][i]=format.formatCellValue(cell);
			
		}
		return data;
		
	}
	
	
	
	@Test
	public void callData() throws IOException {
		Object[][] a=FetchOnlyHeaders.readData();
		System.out.println(Arrays.deepToString(a));
	}

}
