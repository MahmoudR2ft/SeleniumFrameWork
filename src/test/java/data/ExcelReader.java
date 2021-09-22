package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static FileInputStream fis = null ;
	
	public FileInputStream getFileInputStream () throws FileNotFoundException
	{
		
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.xlsx" ;
		File scrFile = new File(filePath);
		
		fis = new FileInputStream(scrFile);
		
		return fis ;
	}
	
	public Object [][] getExcelData() throws IOException
	{
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumbersOfClos = 4 ;
		
		String [][] arrayExcelData = new String[TotalNumberOfRows][TotalNumbersOfClos] ;
		
		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumbersOfClos; j++) 
			{
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j]=row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData;
		
		
	}

}
