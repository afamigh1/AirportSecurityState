package airportSecurityState.driver;

import java.util.ArrayList;

public class Results {

	ArrayList<String> resultsArray;

	public Results() {
		resultsArray = new ArrayList<String>(5);
	}
	
	/*
		store new results into the results array
		@param String result
		@ret none
	*/
	public void storeNewResult(String result) {
		resultsArray.add(result);
	}
	
	/*
		getter method for the results array
		@param none
		@ret ArrayList<String> resultsArray
	*/
	public ArrayList<String> getResultsArray() {
		return resultsArray;
	}
	
	/*
		toString for debugging objects with print statements
		@param none
		@return String description of the class
	*/
	public String toString() {
		return "Results class";
	}

}
