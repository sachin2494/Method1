package GoogleSearch;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtility {
	
	
	public static String[][] getDataFromExcel(String fileName, String sheetName)
	{
		//FileInputStream inputStream;
		//XSSFWorkbook workBook;
		//XSSFSheet Sheet;
		String[][] data = null;
		
		try {
			// open file in read open
			FileInputStream inputStream = new FileInputStream(fileName);
			
			// access file in workbook
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			
			// access sheet of workbook
			XSSFSheet Sheet = workBook.getSheet(sheetName);
			
			// get total numbers of rows
			int totalRows = Sheet.getLastRowNum() + 1;
			
			// get total numbers of cells
			int totalCells = Sheet.getRow(0).getLastCellNum();
			
			// initialize an array
			data = new String[totalRows-1][totalCells];		
			
			for(int currentRow = 1; currentRow<totalRows; currentRow++)
			{
				for(int curerentCell = 0; curerentCell<totalCells; curerentCell++)
				{
					data[currentRow-1][curerentCell] = Sheet.getRow(currentRow).getCell(curerentCell).toString();
				}
			}
			workBook.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}

}
