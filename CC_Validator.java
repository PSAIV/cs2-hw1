//Checks if a users input meets the criteria for a valid credit card number using mod10 validation
import java.util.Scanner;

public class CC_Validator {
	
	public static boolean isValid(long number){
		
		int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
		
		if ((total % 10 == 0) && (prefixMatched(number, 1) == true) && (getSize(number)>= 13 ) && (getSize(number)<= 16)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int getDigit(int number){
		if (number <= 9){
			return number;
		}
		else {
			int firstDigit = number % 10;
			int secondDigit = (int) (number / 10);
			
			return firstDigit + secondDigit;
		}
	}
	
	public static int sumOfOddPlace(long number){
		int result = 0;
		
		while (number > 0){
			result += (int) (number % 10);
			number = number /100;
		}
		
		return result;
	}
	
	public static int sumOfDoubleEvenPlace(long number){
		
		int result = 0;
		long temp = 0;
		
		while (number > 0){
			temp = number % 100;
			result += getDigit((int) (temp / 10) * 2);
			number = number / 100;
		}
		
		return result;
	}
	
	public static boolean prefixMatched(long number, int d) {
		if ((getPrefix(number, d) == 4) || (getPrefix(number, d) == 5) || (getPrefix(number, d) == 3)) {
			if (getPrefix(number, d) == 4) {
				System.out.println("\nVisa Card ");
			}
			else if (getPrefix(number, d) == 5) {
				System.out.println("\nMaster Card ");
			}
			else if (getPrefix(number, d) == 3) {
				System.out.println("\nAmerican Express Card ");
			}
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int getSize(long d) {
		int count = 0;
		
		while (d > 0) {
			d = d / 10;
			
			count++;
		}
		
		return count;
	}
	
	public static long getPrefix(long number, int k){
		
		if(getSize(number) < k) {
			return number;
		}
		else {
			
			int size = (int) getSize(number);
			
			for (int i = 0; i < (size - k); i++){
				number = number / 10;
			}
			
			return number;
		}
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter a credit card number as a long integer: ");
		
		long number = s.nextLong();
		s.close();
		
		if(isValid(number) == true){
			System.out.println(number + " is valid.");
		}
		else {
			System.out.println(number + " is not valid.");
		}
	}

}
