package ReadWriteExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite) throws IOException
	{
		File file = new File(filePath);
		FileInputStream inputstream = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		Sheet sh = wb.getSheet(sheetName);

		int rowcount = sh.getLastRowNum()-sh.getFirstRowNum();
		Row row = sh.getRow(0);


		Row newRow = sh.createRow(rowcount+1);


		//Create a loop over the cell of newly created Row

		for(int j = 0; j < row.getLastCellNum(); j++){

			//Fill data in row

			Cell cell = newRow.createCell(j);

			cell.setCellValue(dataToWrite[j]);

		}


		//Close input stream

		inputstream.close();

		//Create an object of FileOutputStream class to create write data in excel file

		FileOutputStream outputStream = new FileOutputStream(file);

		//write data in the excel file

		wb.write(outputStream);

		//close output stream

		outputStream.close();

	}


	public static void main(String...strings) throws IOException{

		//Create an array with the data in the same order in which you expect to be filled in excel file

		String[] valueToWrite = {"Mr. E","Noida"};

		//Create an object of current class

		WriteExcelFile objExcelFile = new WriteExcelFile();

		//Write the file using file name, sheet name and the data to be filled

		objExcelFile.writeExcel(System.getProperty("user.dir")+"\\src\\excelExportAndFileIO","ExportExcel.xlsx","ExcelDemoWrite",valueToWrite);

	}
}

