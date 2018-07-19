import java.util.*;
import java.text.NumberFormat;

public class CalcTax {
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		//Scan inputs in
		System.out.println("Enter employee's name: ");
		String name = s.nextLine();
		
		System.out.println("Enter number of hours worked in a week: ");
		double hours = s.nextDouble();
		
		System.out.println("Enter hourly pay rate: ");
		double payRate = s.nextDouble();
		
		System.out.println("Enter federal tax withholding rate: ");
		double fedTax = s.nextDouble();
		
		System.out.println("Enter state tax withholding rate: ");
		double stateTax = s.nextDouble();
		//Close the scanner
		s.close();
		
		//Perform calculations
		double grossPay = payRate * hours;
		double fedHeld = grossPay * fedTax;
		double stateHeld = grossPay * stateTax;
		double totalDeduction = fedHeld + stateHeld;
		double netPay = grossPay - totalDeduction;
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		//Display results, with currency variables converted to proper notation
		System.out.println("Employee name : " + name);
		System.out.println("Hours Worked: " + hours);
		System.out.println("Pay Rate: " + currency.format(payRate));
		System.out.println("Gross pay: " + currency.format(grossPay));
		System.out.println("Deductions: ");
		System.out.println("\t Federal Withholding (" + fedTax + "): " + currency.format(fedHeld));
		System.out.println("\t State Withholding (" + stateTax + "): " + currency.format(stateHeld));
		System.out.println("\t Total Deduction: " + currency.format(totalDeduction));
		System.out.println("Net Pay: " + currency.format(netPay));
		
	}

}
