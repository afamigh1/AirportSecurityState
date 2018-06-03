package airportSecurityState.driver;

public class LowRiskState implements AirportStateI {

	int travelerCount, prohibItemCount;
	ContextState context;
	
	public LowRiskState() {
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
		
		if( (avgTraf >= 0 && avgTraf < 4) || (avgProhib >= 0 && avgProhib < 1) ) {
			//System.out.println("Hit low flag");
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
		return "1 3 5 7 9";
	}
	
	public String toString() {
		return "LOW_RISK state";
	}
	
}
