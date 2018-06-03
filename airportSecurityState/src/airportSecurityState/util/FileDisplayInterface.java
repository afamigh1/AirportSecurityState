package airportSecurityState.driver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileDisplayInterface {

	private String outputfile;
	private PrintWriter outputWriter;

	/*
		FileDisplayInterface Constructor
		@param String fileOut the file name to output to
		@ret none
	*/
	public FileDisplayInterface(String fileOut) {
		outputfile = fileOut;
		
		try {
			File textFileOutput = new File(outputfile);
			outputWriter = new PrintWriter(textFileOutput);
		} catch(IOException e) {
			System.out.println("Warning: " +
				"Could not write to " + outputfile + ".\n");
		} finally {
		
		}
	}

	/*
		Method used to write result strings into result array
		@param String s result message for the output file
		@ret none
	*/
	public void writeToFile(String s) {
		outputWriter.println(s);
	}
	
	/*
		Getter method for outputfile name
		@param none
		@ret String outputfile name
	*/
	public String getOutputFile() {
		return outputfile;
	}
	
	/*
		Getter method for PrintWriter
		@param none
		@ret PrintWriter variable
	*/
	public PrintWriter getWriter() {
		return outputWriter;
	}
	
	/*
		Closes the writer used to write to file
		@param none
		@ret none
	*/
	public void closeOutput() {
		outputWriter.close();
	}
	
	/*
		toString for debugging objects with print statements
		@param none
		@return String description of the class
	*/
	public String toString() {
		return "FileDisplayInterface class";
	}


}
