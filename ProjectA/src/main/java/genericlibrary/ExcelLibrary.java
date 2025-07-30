package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary  implements FrameWorkConstant{
	
	
    static FileInputStream fis;
	
	static FileOutputStream fos;
	static Workbook book;
	
		
		
			
			public static String readData(String sheet, int row, int column)  {
				//Convert External file to Java Readable 
				
				try {
					fis = new  FileInputStream(excelpath);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				//create  workbook using workbookFactory
			    
				try {
					book = WorkbookFactory.create(fis);
				} catch (EncryptedDocumentException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			     
			     //read the data using workbook,sheet,row,cell{
			   return book.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
			 
			   }
			     
				
				
				
				
			     public static void writeData_Existing(String sheet, int row, int column,String data1) {
						//Convert External file to Java Readable 
					
						try {
							fis = new  FileInputStream(excelpath);
						} catch (FileNotFoundException e) {
							
							e.printStackTrace();
						}
						//create  workbook using workbookFactory
					  
						try {
							book = WorkbookFactory.create(fis);
						} catch (EncryptedDocumentException e) {
							
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					     
					     
						//read the data using workbook,sheet,row,cell
					     book.getSheet(sheet).getRow(row).createCell(column).setCellValue(data1);
					   //convert readable to external file
					   
						try {
							fos = new  FileOutputStream(excelpath);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					     
					     
					     //call the write method
					     try {
							book.write(fos);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					     //close the browser
					     try {
							book.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					     
					     System.out.println("new data written succesfully");
			     }
	}



