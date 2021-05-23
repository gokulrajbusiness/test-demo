package ExcelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManip {
   public String getExcel(String Title) {
	    String retVal;
	try {
	File file =new File("C:\\Users\\admin\\eclipse-workspace\\practice\\src\\main\\resources\\Excel\\ExcelInput.xlsx");
	FileInputStream inputStream = new FileInputStream(file);
	@SuppressWarnings("resource")
	Workbook wb = new XSSFWorkbook(inputStream);
	Sheet ws =wb.getSheet("gokul");
	Row row = ws.getRow(0);
    retVal= (row.getCell(0).getStringCellValue());
    int rowcount =0;
    Row newRow = ws.createRow(rowcount+1);
    newRow.createCell(0).setCellValue(Title);
    inputStream.close();
    
    FileOutputStream fout=new FileOutputStream(file);
    wb.write(fout);
    fout.close();
    return retVal;
   
    
	
   }
   catch(Exception e) {
	   return null;
   }
	
  
}}	
