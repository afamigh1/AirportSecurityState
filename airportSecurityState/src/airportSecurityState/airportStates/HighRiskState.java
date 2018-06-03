package airportSecurityState.driver;

public class HighRiskState implements AirportStateI {

	int travelerCount, prohibItemCount;
	ContextState context;
	
	public HighRiskState() {
		travelerCount = 0;
		prohibItemCount = 0;
	}
	
	public void tightenOrLoosenSecurity(ContextState context, int currDayIn, String itemIn) {
		incTravelerCount();
		
		if( itemIn.equals("Blade") || itemIn.equals("NailCutter") || itemIn.equals("Gun") || itemIn.equals("Knife") ) {
			incProhibitedCount();
		}
		
		int avgTraf = avgTraffic(currDayIn);
		int avgProhib = avgProhibited(currDayIn);
		
		if( (avgTraf >= 8) || (avgProhib >= 2) ) {
			//System.out.println("Hit high flag");
			context.setState(this);
		}
	}
	
	public int avgTraffic(int dayIn) {
		return ( travelerCount / dayIn );
	}
	
	public int avgProhibited(int dayIn) {
		return ( prohibItemCount / dayIn );
	}
	
	public void incTravelerCount() {
		travelerCount++;
	}
	
	public void incProhibitedCount() {
		prohibItemCount++;
	}
	
	public String getOpList() {
		return "2 4 6 8 10";
	}
	
	public String toString() {
		return "HIGH_RISK state";
	}
	
}
