package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLibrary implements FrameWorkConstant {
	
	
	static FileInputStream fis;
	
	static FileOutputStream fos;
	
	static Properties property;
	
	
	
	
	
	public static String readData(String key) 
	{
		//convert the external file to java readable file
		
		try {
			fis = new  FileInputStream(propertypath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//create object for properties class
		Properties property=new Properties();
		//load the properties 
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Read /Fetch the data
		return property.getProperty(key);
		 
	
	
	}
	
public static void writeData(String newkey, String newvalue) {
		
		
		//convert external file into java readable
		
		try {
			fis = new FileInputStream(propertypath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Create an Object for Properties Class
		Properties property=new Properties();
		
		//Load The Properties
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//put the new data inside properties file
		property.put(newkey, newvalue);
		// Convert java readable file to external file
		
		try {
			fos = new FileOutputStream(propertypath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//store the data
		try {
			property.store(fos, "Updated New Key and VAlue...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("writeDataSuccesful");	
		
				
}
}
