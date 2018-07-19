import java.util.*;
//3.1
public class Problem_3_1 {
	
	public static void main(String[] args){
		//Allocate variables
		double a, b, c, disc, root1, root2;
		
		//Scan in user input
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter value for a, b, c: ");
		a = onlyNumbers(reader);
		b = onlyNumbers(reader);
		c = onlyNumbers(reader);
		reader.close();
		
		//Calculate the discriminant
		disc = Math.pow(b, 2.0) - 4 * a * c;
		
		//Check the and evaluate accordingly
		if(disc > 0){
			root1 = (-b + Math.sqrt(Math.pow(b, 2.0) - (4 * a * c))) / ( 2 * a);
			root2 = (-b - Math.sqrt(Math.pow(b,  2.0) - (4 * a * c))) / (2 * a);
			System.out.println("There are two roots: " + root1 +  " and " + root2);
		}
		if(disc == 0){
			root1 = (-b+ Math.sqrt(Math.pow(b, 2.0) - (4 * a * c))) / ( 2 * a);
			System.out.println("There is one root: " + root1);
		}
		if(disc < 0){
			System.out.println("There are no real roots.");
		}
	}
	
	//Exception Handling
	public static double onlyNumbers(Scanner input) {
		double number = 0;
		try {
			number = input.nextDouble();
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
