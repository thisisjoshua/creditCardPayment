
package PP2;

public class Customer {
	
	private int id;
	private String fName, lName;
	private double amount;
	private CreditCard card;
	
	public static int numberOfCustomers = 0;
	public Customer(String fName, String lName, int id, double amount, CreditCard card) {
		super();
		this.fName = fName;  
		this.lName = lName;  
		this.id = id;
		this.amount = amount;
		this.card = card;
		numberOfCustomers++;
		
	}
	
	// add public setter/getter methods, and also the toString method


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFName() {
	return fName;
}

public void setFName(String fName) {
	this.fName = fName;
}

public String getLName() {
	return lName;
}

public void setLName(String lName) {
	this.lName = lName;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}




public void setCard(CreditCard card) {
	this.card = card;
}


//toStringmethod 
public String toString() {
	
	return "First Name: "+getFName()+"\nLast Name: "+getLName() +"\nAmount: "+getAmount()+"\n Card Details: " +getCard().toString();
}

public CreditCard getCard() {
	// TODO Auto-generated method stub
	return card;
}
}