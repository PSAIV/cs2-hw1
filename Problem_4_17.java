import java.util.Scanner;
//4.17
public class Problem_4_17 {
	
	public static void main(String[] args){
		//Open scanner
		Scanner s = new Scanner (System.in);
		
		//Scan in user inputs
		System.out.println("Enter a year: ");
		int year = onlyNumbers(s);
		System.out.println("Enter the first 3 letters of a month: ");
		String month = s.next();
		month = month.substring(0, 1).toUpperCase() + month.substring(1);
		s.close();
		int numDays = 0;
		
		switch (month) {
		case "Jan":
			numDays = 31;
			break;
		case "Feb":
			numDays = 28;
			//Adds an extra day in case of leap year
			if(year % 4 == 0){
				numDays++;
			}
			break;
		case "Mar":
			numDays = 31;
			break;
		case "Apr":
			numDays = 30;
			break;
		case "May":
			numDays = 31;
			break;
		case "Jun":
			numDays = 30;
			break;
		case "Jul":
			numDays = 31;
			break;
		case "Aug":
			numDays = 31;
			break;
		case "Sep":
			numDays = 30;
			break;
		case "Oct":
			numDays = 31;
			break;
		case "Nov":
			numDays = 30;
			break;
		case "Dec":
			numDays = 31;
			break;
		default:
			System.out.println("Invalid format, please try again.");
		}
		
		System.out.print(month + " " + year + " has " + numDays + " days.");
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