package PP2;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Payment {

	public static Validation validating;
	public static HashCode hashing;
	public static Customer[] customers;

	// this will check whether a card is valid
	public static Boolean isValidCard(String number){
		
		if (validating.aValidNumber(number) == true) {
			return true;
		}
		else 
			return false;

	}// end of the isValidCard method

	// creates a hash code for the credit card number to be stored in file
    public static String createHashCode(String number){
    	
    	String converted = hashing.getHashCode(number);
		return converted;

	}// end of the createHashCode method


     // it adds a new customer to the array of customers once the payment was successful
 	 public static void addCustomer(Customer customer){
 		 
	   for(int i=0;i<customers.length; i++)  		
		   if(customers[i] == null) { 			
			   customers[i] = customer; 			
			   break; 		
			   }

 	 } // end of the addCustomer method


	// it displays the payments AVG, MAX payment, and MIN payment,
	// only for accepted payments with valid cards
	public static void displayStat(){
		
		double maxPayment = 0;
		double minPayment = customers[0].getAmount();
		
		//calculate average payment
		
	   int total = 0;
	   double averagePayment = 0;
	   
	   
	   for (int i = 0; i < customers.length; i++) { 
		   if(customers[i] != null) {
		   total += customers[i].getAmount();
		   averagePayment = (total / customers.length);
		   }
		   if(customers[i] != null) {
			   if (customers[i].getAmount() < minPayment) {
			   minPayment = customers[i].getAmount();
				 	}
				 }
		   if(customers[i] != null) {
				 if (customers[i].getAmount() > maxPayment) {
					 maxPayment = customers[i].getAmount();
				 }
			   }
	   	}
	   
	String message1 = "Average Payment\tMinimum Payment\tMaximum Payment\n";
	message1 +=	"\t$" + Double.toString(averagePayment) +"\t$" + Double.toString(minPayment) + "\t$" + Double.toString(maxPayment);
	JOptionPane.showMessageDialog(null, new JTextArea(message1));
	   
	}// end of the displayStat method

	// write data to file, the credit card number should be encrypted
	// using one-way hash method in the Hashing class
    public static void writeToFile(String[] fName, String[] lNameArr, String[] numberInputArr) throws FileNotFoundException{
    	
    	File file = new File("output.txt");
    	java.io.PrintWriter output = new java.io.PrintWriter(file);

		String message = "First Name\tLast Name\tCreditCardNumber\n";
	     for (int i = 0; i < customers.length; i++)
		message += fName[i] +"\t" + lNameArr[i] + "\t" + numberInputArr[i]+"\n";
	     
		JOptionPane.showMessageDialog(null, new JTextArea(message));
    
		output.print(message);
		output.close();
		JOptionPane.showMessageDialog(null, "File  " + file + "  created" + file.getAbsolutePath());

    } // end of the writeToFile method


	// the main entry method of the program that will get data from user and
	// perform the business logic
	public static void main(String[] args) throws Exception {
		
		boolean proceed;
		int n = 0;
		int id = 0;
		//long[] number;
		String [] fNameArr, lNameArr;
		String [] numberInputArr;
		String fName = null,lName = null, numberInput="";
		
		hashing = new HashCode();
		validating = new  Validation();
        
		// input the number of customers and stores it into variable n

        String nInput = JOptionPane.showInputDialog(null, "Please enter the number or customers: ");
        int numOfCust = Integer.parseInt(nInput);
        
		customers = new Customer[numOfCust];
		fNameArr = new String[numOfCust];
		lNameArr = new String[numOfCust];
		numberInputArr = new String[numOfCust];
		
		for (int i = 0; i < numOfCust; i++) {
		//enter customer id
		String input = JOptionPane.showInputDialog(null, "Please enter the Customer ID ");
		id = Integer.parseInt(input);
		
		if (id == 0) {
			break;
		}
		else {	
			//enter customer first and last name	
			 fName = JOptionPane.showInputDialog(null, "Please enter the customer's first name: ");
			 lName = JOptionPane.showInputDialog(null, "Please enter the customer's last name: ");
	
			//enter card number		
			numberInput = JOptionPane.showInputDialog(null, "Please enter the credit card number: ");
			long number = Long.parseLong(numberInput); 
			
			if(isValidCard(numberInput) == true) {
				
				addCustomer(customers[i]);
				JOptionPane.showMessageDialog(null, "Card is valid!!");
			}
			else {
				JOptionPane.showMessageDialog(null,"Card is invalid");
				break;
			}
			
			//enter card expiration date
			String expDate = JOptionPane.showInputDialog(null, "Please enter expiration date ");
			
			//enter payment amount
			String inputAmount = JOptionPane.showInputDialog(null, "Please enter payment amount ");
			double  amount = Double.parseDouble(inputAmount);
			 	
			//initialize objects
			CreditCard card = new CreditCard(number, expDate);
			 		 
			customers[i] = new Customer(fName, lName, id, amount, card);			
		}
		//createHashCode(numberInput);
		fNameArr[i] = fName;
		lNameArr[i] = lName;
		numberInputArr[i]= createHashCode(numberInput);
		
		}// end of for loop
		
		writeToFile(fNameArr, lNameArr, numberInputArr);
		displayStat();
		for (int i=0; i < numOfCust; i++) {
		JOptionPane.showMessageDialog(null,customers[i].toString());
		}
		
	}
}
