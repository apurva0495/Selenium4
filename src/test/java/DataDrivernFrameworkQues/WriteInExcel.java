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

public class WriteInExcel {
	
	
	@Test
	public void writeData() throws IOException {
		Object[][] data= {{"P","PP",56,"PC"},
				{"Z","ZZ",85,"ZC"},
				{"S","SS",79,"SC"},
				{"R","RR",63,"RC"}};
		
		Object[][] headers= {{"FirstName","LastName","Age","City"}};
				
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\DataDrivernFrameworkQues\\WriteData.xlsx";
        FileOutputStream file = new FileOutputStream(filePath);
        Workbook book = new XSSFWorkbook();
        Sheet sheet=book.createSheet("Sheet2");
        Row row=sheet.createRow(0);
        for(int i=0;i<headers[0].length;i++) {
        	Cell cell=row.createCell(i);
        	cell.setCellValue((String)headers[0][i]);
        }
        
        
        for(int i=0;i<data.length;i++) {
        	Row r=sheet.createRow(i+1);
        	for(int j=0;j<data[0].length;j++) {
        		Cell cell=r.createCell(j);
        		cell.setCellValue(data[i][j].toString());
        	}
        }
        
        book.write(file);
        file.close();
		
	}
}
