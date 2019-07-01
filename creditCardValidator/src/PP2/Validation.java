package PP2;

public class Validation {

	// Return true if the card number is valid, otherwise returns false, this method
	// is already implemented
	public boolean aValidNumber(String n) {

		long number = Long.parseLong(n);
		boolean valid = (numLength(number) >= 13) && (numLength(number) <= 16)
				&& (prefixCheck(number, 4) || prefixCheck(number, 5)
						|| prefixCheck(number, 6) || prefixCheck(number, 37))
				&& (totalEevenNumbers(number) + totalOddNumbers(number)) % 10 == 0;

		return valid;
	}// end of aValidNumber method

	// get the sum of even places numbers, Starting from the second digit from right
	private int totalEevenNumbers(long number) {

		int sum = 0;
		  int length = numLength(number);
		   
		  for (int i=0;i< length; i++){
		  if(i%2 !=0)
		  {
		  sum += singleDigit((int)(number % 10)*2);
		  number = number/10;
		   }
		   else 
		   number = number/10;
		  }
		  System.out.println("total even number"+sum);
		   return sum;

		
		
	}// end of totalEevenNumbers method

	// Return the same number if it is a single digit, otherwise, return the sum of
	// the two digits in this number
	private int singleDigit(int number) {
  	  
		if (number <= 9) {
            return number;
        } else {
            int firstDigit = number % 10;
            int secondDigit = (int) (number / 10);

            return firstDigit + secondDigit;
        }
	  
	  
  } // end of singleDigit method
		// Return the sum of odd place digits in number

	private int totalOddNumbers(long number) {

		int sum = 0;
		String numLength = number + "";
		for (int i = numLength(number) - 1; i >= 0; i -= 2) {
			sum += Integer.parseInt(numLength.charAt(i) + "");
		}
		System.out.println("total odd number"+sum);
		return sum;
	}// end of totalOddNumbers method

	// Return true if the digit d is a prefix for number
	private boolean prefixCheck(long number, int d) {

		return numPrefix(number, numLength(d)) == d;

	}// end of prefixCheck method

	// Return the number of digits in this number parameter
	private int numLength(long number) {

		String num = number + "";
		System.out.println("number length"+ num.length());
		return num.length();

	}// end of numLength method

	// Return the first k number of digits from number, which is either a first
	// digit or first two digits
	// Depending on the card type
	private long numPrefix(long number, int k) {

		if (numLength(number) > k) {
			String num = number + "";
			return Long.parseLong(num.substring(0, k));
		}
		return number;
	}// end of numPrefix method

}// end of the class
