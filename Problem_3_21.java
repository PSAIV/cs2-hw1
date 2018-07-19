import java.util.*;
//3.21
public class Problem_3_21 {
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		//Scan in the users inputs
		System.out.println("Enter year: ");
		int year = onlyNumbers(s);
		System.out.println("Enter month (1-12): ");
		int month = onlyNumbers(s);
		System.out.println("Enter the day of the month (1-31): ");
		int day = onlyNumbers(s);
		s.close();
		
		//Converts January and February to fit the formula
		if(month == 1 || month == 2){
			month += 12;
			year--;
		}

		
		int dotw = (day + (26 * (month +1)/10) + (year % 100) + ((year % 100) / 4) + ((year / 100) / 4) + 5 * (year / 100)) % 7;
		String dotwString;
		switch (dotw) {
		case 0: dotwString = "Saturday";
				break;
		case 1: dotwString = "Sunday";
				break;
		case 2: dotwString = "Monday";
				break;
		case 3: dotwString = "Tuesday";
				break;
		case 4: dotwString = "Wednesday";
				break;
		case 5: dotwString = "Thursday";
				break;
		case 6: dotwString = "Friday";
				break;
		default: dotwString = "Error in computation. Please check your input.";
		}
		System.out.println("The day of the week is " + dotwString);
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
