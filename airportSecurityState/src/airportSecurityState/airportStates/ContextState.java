package airportSecurityState.driver;

import java.util.ArrayList;

public class ContextState {

	AirportStateI state;
	
	public ContextState() {
		state = null;
	}
	
	public void updateState(ContextState contextIn, AirportStateI highIn, AirportStateI lowIn, 
				AirportStateI modIn, int currDay, String item) {
		lowIn.tightenOrLoosenSecurity(contextIn, currDay, item);
		modIn.tightenOrLoosenSecurity(contextIn, currDay, item);
		highIn.tightenOrLoosenSecurity(contextIn, currDay, item);
	}	
	
	public void setState(AirportStateI state) {
		this.state = state;
	}
	
	public AirportStateI getState() {
		return state;
	}

}
