package wordCount.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import wordCount.util.Logger.DebugLevel;
/**
 * FileProcessor class for reading writing files.
 * @author Ankush
 *
 */
public class FileProcessor {
	private Scanner x;
	String ip_file, op_file;
	File file;
	Writer fileWriter = null;
    BufferedWriter bufferWriter = null;
	/**
	 * FileProcessor constructor to open input file and create output file
	 * @param inputfile
	 * @param outputfile
	 */
	public FileProcessor(String inputfile, String outputfile){
		ip_file = inputfile;
		op_file = outputfile;
		
		DebugLevel db = DebugLevel.CONSTR;
		Logger.getUniqueInstance();
		Logger.writeMessage("FileProcessor constructor called. Input File= " + inputfile + " Output File= " + outputfile,db);
		
		try {
			x = new Scanner(new File(ip_file)).useDelimiter("\\s\\n");
			
			file = new File(op_file);
			if(file.exists()){
				file.delete();
			}
			
			if(!file.exists()) {
				file.createNewFile();
			}
			file.setWritable(true);
			fileWriter = new FileWriter(file,false);
        	bufferWriter = new BufferedWriter(fileWriter);
		} catch(Exception e) {
			System.out.println("could not find file");
		}
		finally{
			
		}
	}
	/**
	 * FileProcessor constructor to create output file
	 * @param outputfile
	 */
	public FileProcessor(String outputfile){
		op_file = outputfile;
		
		DebugLevel db = DebugLevel.CONSTR;
		Logger.getUniqueInstance();
		Logger.writeMessage("FileProcessor constructor called. Output File= " + outputfile,db);
		
		try {
			
			file = new File(op_file);
			if(file.exists()){
				file.delete();
			}
			
			if(!file.exists()) {
				file.createNewFile();
			}
			file.setWritable(true);
			fileWriter = new FileWriter(file,false);
        	bufferWriter = new BufferedWriter(fileWriter);
		} catch(Exception e) {
			System.out.println("could not find file");
		}
		finally{
			
		}
	}
	/**
	 * method to get next line from the input file
	 * @return string line of text
	 */
	public String readFromFile() {
		if(x.hasNext()) 		
	          return x.nextLine();
	    return null;
	}
	/**
	 * method to write string text to file
	 * @param data - to write to file
	 */
	public void writeToFile(String data) {
	
        
        try {
        	      		
        	bufferWriter.write(data+"\n");
        	bufferWriter.flush();
        	
        	DebugLevel db = DebugLevel.RESULTS;
    		Logger.getUniqueInstance();
    		Logger.writeMessage("Data written to file: " + file + " Data: " + data,db);
        	
        } catch (IOException e) {
        	System.err.println("Error writing the file : ");
        	e.printStackTrace();
        } finally {
        /*	if(bufferWriter != null && fileWriter != null) {
        		try {
        			bufferWriter.close();
        			fileWriter.close();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        		finally{
        			
        		}
        	} */
        }
	}
}
