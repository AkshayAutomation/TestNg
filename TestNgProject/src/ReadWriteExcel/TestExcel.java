package ReadWriteExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {

	public void ReadTestExcel(String filepath, String filename, String sheetname) throws IOException
	{
		File file = new File(filepath+"\\"+filename);
		FileInputStream inputstream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		Sheet sh = wb.getSheet(sheetname);
		
		int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
		
		for (int i = 0; i < rowCount+1; i++) 
		{
			Row row = sh.getRow(i);

			//Create a loop to print cell values in a row

			for (int j = 0; j < row.getLastCellNum(); j++) 
			{
				//Print Excel data in console
				System.out.print(row.getCell(j).getStringCellValue()+"|| ");
			}
			System.out.println();
		} 

	}
	//Main function is calling readExcel function to read data from excel file

		public static void main(String...strings) throws IOException{

			//Create an object of ReadGuru99ExcelFile class

			ReadExcelFile objExcelFile = new ReadExcelFile();

			//Prepare the path of excel file

			String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
			
			//Call read file method of the class to read data

			objExcelFile.readExcel(filePath,"ExportExcel.xlsx","ExcelGuru99Demo");

		}
}
