package PP2;

public class CreditCard {
	
	private long number;
	private String expDate;
	
	public CreditCard(long number, String expDate){
		this.number = number;
		this.expDate = expDate;
	}
	
	// add public setter/getter methods, and also the toString method //trin's Q did I set up the getter setter
	//correctly for long?
	
	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}
	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
		
}

	@Override
	public String toString() {
		return "\nCredit card number=" + number + "\nexpDate=" + expDate;
	} 

}
