
import java.awt.geom.Rectangle2D;
import java.util.Scanner;
//3.28
public class Problem_3_28 {
	
	public static void main(String[] args){
		//Open the scanner
		Scanner s = new Scanner(System.in);
		
		//Instantiate rectangle objects
		Rectangle2D r1 = new Rectangle2D.Double();
		Rectangle2D r2 = new Rectangle2D.Double();
		
		//Prompt user for first rectangle dimensions
		System.out.println("Enter r1's center x-, y-coordinates, width, and height: ");
		
		//Store first rectangle dimensions
		double x = onlyNumbers(s);
		double y = onlyNumbers(s);
		double width = onlyNumbers(s);
		double height = onlyNumbers(s);
		
		//Transform provided "center coordinates" to upper-left coordinates, to conform to Java rectangle objects
		x = (x - (width / 2));
		y = (y - (height / 2));
		
		//Set First Rectangle Dimensions
		r1.setRect(x, y, width, height);
		
		//Prompt user for second rectangle dimensions
		System.out.println("Enter r2's center x-, y-coordinates, width and height: ");
		
		//Override variables with second rectangle values
		x = onlyNumbers(s);
		y = onlyNumbers(s);
		width = onlyNumbers(s);
		height = onlyNumbers(s);
		s.close();
		
		//Transform provided "center coordinates" to upper-left coordinates, to conform to Java rectangle objects
		x = (x - (width / 2));
		y = (y - (height / 2));
		
		//Set Second Rectangle Dimensions
		r2.setRect(x, y, width, height);
		
		//Check if second rectangle is wholly inside the first
		if (r1.contains(r2)){
			System.out.println("r2 is inside r1");
		}
		
		//Check if the second rectangle overlaps the first at any point
		else if (r1.intersects(r2)){
			System.out.println("r2 overlaps r1");
		}
		
		//If neither are true, the two rectangles do not touch
		else System.out.println("r2 does not overlap r1");
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
