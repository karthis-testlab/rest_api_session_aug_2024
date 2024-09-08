package week3.day2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class DataHandler {

	public static String[][] readExcelData(String excelFileName) {
		XSSFWorkbook workbook;
		String[][] data = null;
		try {
			workbook = new XSSFWorkbook("src/main/resources/data/" + excelFileName + ".xlsx");			
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return data;
	}

	public static String[][] readCsvData(String csvFileName) {
		CSVReader reader;
		List<String[]> rowRecords = null;
		String[][] data = null;
		try {
			reader = new CSVReaderBuilder(new FileReader("src/main/resources/data/" + csvFileName + ".csv")).withSkipLines(1).build();
			rowRecords = reader.readAll();			
			data = new String[rowRecords.size()][rowRecords.get(0).length];
			for (int i = 0; i < rowRecords.size(); i++) {
				for (int j = 0; j < rowRecords.get(0).length; j++) {
					data[i][j] = rowRecords.get(i)[j];
				}
			}
		} catch (IOException | CsvException e) {
			System.err.println(e.getMessage());
		}
		return data;
	}
	
	public static void main(String[] args) {
		try {
			CSVReader reader = new CSVReaderBuilder(new FileReader("src/main/resources/data/incidents.csv")).withSkipLines(1).build();
			List<String[]> readAll = reader.readAll();
			System.out.println("Total Rowcount: "+readAll.size());
			System.out.println("Total Colcount: "+readAll.get(0).length);
			for (String[] strings : readAll) {
				System.out.println(Arrays.toString(strings));
			}
		} catch (IOException | CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}