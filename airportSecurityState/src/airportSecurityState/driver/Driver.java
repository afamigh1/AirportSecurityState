package airportSecurityState.driver;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Driver {
	
	public static void main(String[] args) {
		int i, j;
		String line;
		
		ArrayList<String> days = new ArrayList<String>(10);
		ArrayList<String> timeOfDay = new ArrayList<String>(10);
		ArrayList<String> airlines = new ArrayList<String>(10);
		ArrayList<String> items = new ArrayList<String>(10);
		
		
		try {
			if(args.length != 3) { 
				System.err.println("Please enter 3 arguments.\n");
				System.exit(0);
			}
			
			FileProcessor fileProc1 = new FileProcessor(args[0]);
			
			ContextState context = new ContextState();
			LowRiskState low = new LowRiskState();
			ModerateRiskState mod = new ModerateRiskState();
			HighRiskState high = new HighRiskState();
			
			Results resObj = new Results();
			
			i=0;
			while( (line = fileProc1.readLine()) != null) {
				StringTokenizer multiTokenizer = new StringTokenizer(line, ";");
				
				while(multiTokenizer.hasMoreTokens()) {
					String split = multiTokenizer.nextToken();
					if(split.substring(0, 3).equals("Day")) {
						days.add(split.substring(4));
					} else if(split.substring(0,3).equals("TOD")) {
						timeOfDay.add(split.substring(4));
					} else if(split.substring(0,3).equals("Air")) {
						airlines.add(split.substring(8));
					} else if(split.substring(0,3).equals("Ite")) {
						items.add(split.substring(5));
					}
				}
				
				context.updateState(context, high, low, mod, Integer.parseInt(days.get(i)), items.get(i));
				resObj.storeNewResult(context.getState().getOpList());
				results.add(context.getState().getOpList());
				i++;
			}
			
			FileDisplayInterface writeFileObj = new FileDisplayInterface(args[1]);
			
			for(i=0; i < resObj.getResultsArray().size(); i++) {
				//System.out.println((i+1) + ": " + results.get(i));
				writeFileObj.writeToFile(resObj.getResultsArray().get(i));
				//writeFileObj.writeToFile(results.get(i));
			}
			/*IMPLEMENT MY LOGGER FINALLY*/
			writeFileObj.closeOutput();
			fileProc1.closeInput();
						
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Warning: " 
			+ "ArrayIndexOutOfBoundsException.");	
			System.exit(0);	
		} catch(NumberFormatException e) {
			System.out.println("Warning: " 
			+ "NumberFormatException.");
			System.exit(0);
		} finally {
			
		}
	
	}

}
