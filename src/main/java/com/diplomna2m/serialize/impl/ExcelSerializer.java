package com.diplomna2m.serialize.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.diplomna2m.model.Detail;

public class ExcelSerializer{

	public static void serialize(List<Detail> t, String filename) {
		
		  Workbook workbook = null;
		  
		    if (filename.endsWith("xlsx")) {
		        workbook = new XSSFWorkbook();
		    } else if (filename.endsWith("xls")) {
		        workbook = new HSSFWorkbook();
		    } else {
		        throw new IllegalArgumentException("The specified file is not Excel file");
		    }
		    
		    Sheet sheet = workbook.createSheet();
		    
		    Row row0 = sheet.createRow(2);
	        Cell cell0 = row0.createCell(1);
	        cell0.setCellValue("Id");
	        cell0 = row0.createCell(2);
	        cell0.setCellValue("Line");
	        cell0 = row0.createCell(3);
	        cell0.setCellValue("Debit");
	        cell0 = row0.createCell(4);
	        cell0.setCellValue("Credit");
	        cell0 = row0.createCell(5);
	        cell0.setCellValue("Amount");
	        cell0 = row0.createCell(6);
	        cell0.setCellValue("Text Of Entry");
	        cell0 = row0.createCell(7);
	        cell0.setCellValue("Header Id");
	        cell0 = row0.createCell(8);
	        cell0.setCellValue("Firm");
	        cell0 = row0.createCell(9);
	        cell0.setCellValue("Journal Number");
	        cell0 = row0.createCell(10);
	        cell0.setCellValue("Period");
	        cell0 = row0.createCell(11);
	        cell0.setCellValue("Document Type");
	        cell0 = row0.createCell(12);
	        cell0.setCellValue("Document Number");
	        cell0 = row0.createCell(13);
	        cell0.setCellValue("Document Date");
	        cell0 = row0.createCell(14);
	        cell0.setCellValue("Operation Kind");
	        cell0 = row0.createCell(15);
	        cell0.setCellValue("Status");
	        cell0 = row0.createCell(16);
	        cell0.setCellValue("Text Of Entry");
	        cell0 = row0.createCell(17);
	        cell0.setCellValue("Contracting party number");
	        cell0 = row0.createCell(18);
	        cell0.setCellValue("Contracting party name");
		 
		    int rowCount = 2;
		 
		    for (Detail detail : t) {
		        Row row = sheet.createRow(++rowCount);
		        Cell cell = row.createCell(1);
		        cell.setCellValue(detail.getId());
		     
		        cell = row.createCell(2);
		        cell.setCellValue(detail.getLine());
		        
		        cell = row.createCell(3);
		        cell.setCellValue(detail.getDebit());
		        cell = row.createCell(4);
		        cell.setCellValue(detail.getCredit());
		        cell = row.createCell(5);
		        cell.setCellValue(detail.getAmount());
		        cell = row.createCell(6);
		        cell.setCellValue(detail.getTextOfEntry());
		        cell = row.createCell(7);
		        cell.setCellValue(detail.getAccHeaderId().getId());
		        cell = row.createCell(8);
		        cell.setCellValue(detail.getAccHeaderId().getFirm());
		        cell = row.createCell(9);
		        cell.setCellValue(detail.getAccHeaderId().getJournalNumber());
		        cell = row.createCell(10);
		        cell.setCellValue(detail.getAccHeaderId().getPeriod().toString());
		        cell = row.createCell(11);
		        cell.setCellValue(detail.getAccHeaderId().getDocType());
		        cell = row.createCell(12);
		        cell.setCellValue(detail.getAccHeaderId().getDocNr());
		        cell = row.createCell(13);
		        cell.setCellValue(detail.getAccHeaderId().getDocDate().toString());
		        cell = row.createCell(14);
		        cell.setCellValue(detail.getAccHeaderId().getOperationKind());
		        cell = row.createCell(15);
		        cell.setCellValue(detail.getAccHeaderId().getStatus());
		        cell = row.createCell(16);
		        cell.setCellValue(detail.getAccHeaderId().getTextOFEntry());
		        cell = row.createCell(17);
		        cell.setCellValue(detail.getAccHeaderId().getRefNr());
		        cell = row.createCell(18);
		        cell.setCellValue(detail.getAccHeaderId().getRefName());
		    }
		 
		    try (FileOutputStream outputStream = new FileOutputStream(filename)) {
		        workbook.write(outputStream);
		        workbook.close();
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
