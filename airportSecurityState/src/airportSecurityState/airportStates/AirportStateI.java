package airportSecurityState.driver;

public interface AirportStateI {

	/*
		Interface declares all the method headers
		to be implemented via the ContextState class
		All methods are group according to being
		a setter, getter, or misc method 
	*/
	
	public int avgTraffic(int dayIn);
	public int avgProhibited(int dayIn);
	
	public void tightenOrLoosenSecurity(ContextState context, int currDayIn, String itemIn);
	public void incTravelerCount();
	public void incProhibitedCount();
	
	public String getOpList();
	public String toString();
}
