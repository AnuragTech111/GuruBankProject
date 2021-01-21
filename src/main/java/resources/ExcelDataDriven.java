package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {

	public ArrayList<String> getData(String testcaseName) throws IOException
	{
		ArrayList<String> list = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\Anurag\\Documents\\GuruExcelDataDriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		System.out.println("Number of sheets : " +sheets);
		
		for(int i=0; i<sheets; i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("Testdata"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				
				Iterator<Cell> cells = firstrow.cellIterator();
				
				int k=0;
				int column=0;
				while(cells.hasNext())
				{
					Cell value = cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
					{
						column=k;
					}
					k++;
				}
				System.out.println("Column count : " + column);
				
				while(rows.hasNext())
				{
					Row row = rows.next();
					if(row.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
					{
						Iterator<Cell> cellValue = row.cellIterator();
						while(cellValue.hasNext())
						{
							Cell c = cellValue.next();
							if(c.getCellTypeEnum() == CellType.STRING)
							{
							list.add(c.getStringCellValue());
							}
							else
							{
								list.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
		return list;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
	}

}
