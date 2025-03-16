package DataDrivernFrameworkQues;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
public class ReadAllData {
	
	

	public static Object[][] readData() throws IOException {
		
		
		DataFormatter format;
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\DataDrivernFrameworkQues\\TestData.xlsx");
		Workbook book=new XSSFWorkbook(file);
		Sheet sheet=book.getSheet("Sheet1");
		int row=sheet.getPhysicalNumberOfRows();
		int cells=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[row][cells];
		for(int i=1;i<row;i++) {
			Row rows=sheet.getRow(i);
			for(int j=0;j<rows.getLastCellNum();j++) {
				Cell cell=rows.getCell(j);
				format=new DataFormatter();
				 data[i][j]=format.formatCellValue(cell);
				System.out.print(data[i][j]+" ");
				
			}
			System.out.println();
		}
		return data;
		
	}
	
	
	
	@Test
	public void callData() throws IOException {
		Object[][] a=ReadAllData.readData();
		System.out.println(Arrays.toString(a));
	}

}
