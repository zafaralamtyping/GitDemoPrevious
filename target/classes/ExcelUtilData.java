package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilData {
	public static void main(String[] args) throws IOException {
		ArrayList<ExcelArrayList> arrayList = new ArrayList<ExcelArrayList>();
		arrayList = getExcelData();
		for(int i=0; i<arrayList.size(); i++) {
			System.out.print(arrayList.get(i).getUserName()
					+ "     " + arrayList.get(i).getPassword()
					+ "     " + arrayList.get(i).getComment());
			System.out.println();
		}
	
		System.out.println(arrayList.size());
		
		Object[][] dataObjects = new Object[3][3];
		
		for(int i=0; i<arrayList.size(); i++) {
			int j=0;
			dataObjects[i][j] =  arrayList.get(i).getUserName();
			j++;
			dataObjects[i][j] =  arrayList.get(i).getPassword();
			j++;
			dataObjects[i][j] =  arrayList.get(i).getComment();
			
		}
		System.out.println("2D array object");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(dataObjects[i][j] + "     ");
			}
			System.out.println();
		}
		
		
		
		

	}
	public static ArrayList<ExcelArrayList> getExcelData() throws IOException {
		ArrayList<ExcelArrayList> arrayList = new ArrayList<ExcelArrayList>();
//		ExcelArrayList excelArrayList = new ExcelArrayList();
		FileInputStream fisFileInputStream = new FileInputStream("C:\\Users\\admin\\work\\E2EProject\\src\\main\\java\\resources\\DemoData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fisFileInputStream);
		int numberOfSheets = workbook.getNumberOfSheets();
		System.out.println("Number of sheets: " + numberOfSheets);
		for(int i=0; i<numberOfSheets; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("E2EProject_data")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				while(rows.hasNext()) {
					Iterator<Cell> cells = rows.next().cellIterator();
					while(cells.hasNext()) {
//						arrayList.add(cells.next().getStringCellValue());
						arrayList.add(new ExcelArrayList(cells.next().getStringCellValue(), cells.next().getStringCellValue(), cells.next().getStringCellValue()));
					}
				}
				
				
				
			}//main if ends
		}//main for loop ends
		

	
		return arrayList;
		
		
		
		
	}
}
