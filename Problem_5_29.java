import java.util.Scanner;
public class Problem_5_29 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter year: ");
		int year = s.nextInt();
		
		System.out.println("Enter the first day of the year from 0 to 6, 0 being Sunday, etc.: ");
		int day = s.nextInt();
		s.close();
		
		for(int i = 1; i <= 12; i++)
		{
			String month = "";
			int numDay =0;
			switch(i)
			{
			case 1:
				month = "January ";
				numDay = 31;
				break;
			case 2:
				month = "February ";
				if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
					numDay = 29;
				else numDay = 28;
				break;
			case 3:
				month = "March ";
				numDay = 31;
				break;
			case 4:
				month = "April ";
				numDay = 30;
				break;
			case 5:
				month = "May ";
				numDay = 31;
				break;
			case 6:
				month = "June ";
				numDay = 30;
				break;
			case 7:
				month = "July ";
				numDay = 31;
				break;
			case 8:
				month = "August ";
				numDay = 31;
				break;
			case 9:
				month = "September ";
				numDay = 30;
				break;
			case 10:
				month = "October ";
				numDay = 31;
				break;
			case 11:
				month = "November ";
				numDay = 30;
				break;
			case 12:
				month = "December ";
				numDay = 31;
				break;
			}
			
			System.out.println("\n             " + month + year);
			System.out.println(" _______________________________________");
			System.out.println(" Sun   Mon   Tue   Wed   Thu   Fri   Sat");
			for (int k = 1; k <= numDay; k++){
				if (day%7 == 0 && day !=0)
					System.out.println();
				System.out.printf("%4d  ",k);
				day += 1;
			}
			day%=7;
			
			System.out.print("\n\n");
		}
	}

}
