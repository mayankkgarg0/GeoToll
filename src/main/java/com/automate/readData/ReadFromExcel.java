package com.automate.readData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import org.apache.poi.ss.usermodel.*;;

public class ReadFromExcel {

	public Workbook workbook;

    public ReadFromExcel(String excelFilePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(excelFilePath);
        workbook = WorkbookFactory.create(fileInputStream); // Supports both .xls and .xlsx
    }

    public String[][] getData(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        String[][] data = new String[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip header row
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = cell.toString(); // Convert cell value to string
            }
        }

        return data;
    }

    public void close() throws IOException {
        workbook.close();
    }

}
