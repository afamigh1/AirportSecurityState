package airportSecurityState.driver;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileProcessor {
	
	private String inputfile;
	private Scanner scan;
	
	public FileProcessor() { }
	
	/*
		FileProcessor Constructor
		@param String fileIn the name of the input.txt file
		@ret none
	*/
	public FileProcessor(String fileIn) {
		inputfile = fileIn;
		
		try {
			File textFileInput = new File(inputfile);
			scan = new Scanner(textFileInput);
		} catch(FileNotFoundException e) {
			System.out.println("Warning: " + inputfile + " not found.\n");
		} finally {
			//when do you close the scanner and file
		}
		
	}
	
	/*
		Returns one line at a time when reading from a file
		@param none
		@ret String lineRead the line read from input file
	*/
	public String readLine() {
		String lineRead = "";
		if(scan.hasNextLine()) {
			lineRead = scan.nextLine();
		} else {
			return null;
		}
		
		return lineRead;
	}
	
	/*
		Closes the scanner used for file input
		@param none
		@ret none
	*/
	public void closeInput() {
		scan.close();
	}
	
	/*
		Getter method for inputfile name
		@param none
		@ret String inputfile name
	*/
	public String getInputFile() {
		return inputfile;
	}
	
	/*
		Getter method for Scanner
		@param none
		@ret Scanner variable
	*/
	public Scanner getScanner() {
		return scan;
	}
	
	/*
		toString for debugging objects with print statements
		@param none
		@return String description of the class
	*/
	public String toString() {
		return "FileProcessor class";
	}
	

}
