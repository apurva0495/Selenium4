package DataDrivernFrameworkQues;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CallingFromDataProvider {
	
	
	
	@DataProvider(name="dp")
	public static Object[][] readData() throws IOException{
		
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\DataDrivernFrameworkQues\\TestData.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        DataFormatter format = new DataFormatter();
        Workbook book = new XSSFWorkbook(file);
        Sheet sheet = book.getSheet("Sheet1");
		int row=sheet.getPhysicalNumberOfRows();
		int cells=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[row-1][cells];
		for(int i=1;i<row;i++) {
			Row rows=sheet.getRow(i);
			for(int j=0;j<rows.getLastCellNum();j++) {
				Cell cell=rows.getCell(j);
				format=new DataFormatter();
				 data[i-1][j]=format.formatCellValue(cell);
				
				
			}
		
		}
		return data;
		
	}
		
	@Test(dataProvider="dp")
	public void allData(String FirstName, String LastName,String Age, String City) {
		
		System.out.println(FirstName+" "+LastName+" "+Age+" "+City);
		
	}
	
	
	

}
