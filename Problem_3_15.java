
import java.util.Scanner;
import java.util.stream.IntStream;
 
//3.15
public class Problem_3_15 {
    public static void main(String [] args){
 
    	//Generate random number with 3 digits
    	int randomNumber = 100 + (int)(Math.random() * ((999 - 100)+1));
    	int award;
    	
    	//Start scanner
    	Scanner s = new Scanner (System.in);
    	
    	//Prompt user to enter three digits
    	System.out.println(" Enter the three digit integer");
    	int userNumber = onlyNumbers(s);
    	
    	//In case number exceeds 3 digits, divide by 10 until it is below 1000
    	while(userNumber > 999){
    		userNumber = userNumber / 10;
    	}
    	s.close();
    	
    	//Convert both user number and random number into arrays
    	int [] randArray = toArray(randomNumber);
    	int [] userArray = toArray(userNumber);
    	
    	//Display numbers
    	System.out.println("You chose: " + userNumber);
    	System.out.println("The winning number is... " + randomNumber);
    
    	//Check for a perfect match
    	if(randomNumber == userNumber){
    		award = 10000;
    		System.out.println("Perfect match!! You won: $" + award + "!");
    	}
    	
    	//Check for all matching digits, regardless of order
    	else if(IntStream.of(userArray).anyMatch(x -> x == randArray[0]) &&
    			IntStream.of(userArray).anyMatch(x -> x == randArray[1]) &&
    			IntStream.of(userArray).anyMatch(x -> x == randArray[2])){
    		award = 3000;
    		System.out.println("All digits match! You won $" + award + "!");
    	}
    	
    	//Check for at least one match
    	else if(IntStream.of(userArray).anyMatch(x -> x == randArray[0]) ||
    			IntStream.of(userArray).anyMatch(x -> x == randArray[1]) ||
    			IntStream.of(userArray).anyMatch(x -> x == randArray[2])){
    		award = 1000;
    		System.out.println("At least one digit matches. You won $" + award);
    	}
    	
    	//If none of the above are true, there are no matches
    	else System.out.println("No matches, try again.");
    }
    
    
    
    
    //Converts both numbers to an array for easier comparison
    public static int[] toArray(int number){
    	String temp = Integer.toString(number);
    	int[] converted = new int[temp.length()];
    	for (int i = 0; i < temp.length(); i++)
    	{
    		converted[i] = temp.charAt(i) - '0';
    	}
    	return converted;
    }
    
    //Exception Handling
	public static int onlyNumbers(Scanner input) {
		int number = 0;
		try {
			number = input.nextInt();
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid input, please enter only numbers: ");
			input.nextLine();
			number = onlyNumbers(input);
		}
		return number;
	}
}