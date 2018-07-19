import java.util.Scanner;
//4.21
public class Problem_4_21 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String social = null;
		
		System.out.println("Enter a Social Security Number: ");
		social = s.nextLine();
		s.close();
		
		if(validSSN(social) == true){
			System.out.println("This SSN is valid!");
		}
		if(validSSN(social) == false){
			System.out.println("This SSN is not valid.");
		}
	}
	
	public static boolean validSSN(String str){
		//check length first
		if (str.length() != 11) return false;
		
		//traverse through each character
		for (int i = 0; i < str.length(); i++){
			if (i <= 2){
				//these must be digits, otherwise return false
				if(!isDigit(str.charAt(i))){
					return false;
				}
			}
			else if (i == 3 || i == 6){
				//these must be dashes, otherwise return false
				if(!isDash(str.charAt(i))){
					return false;
				}
			}
			else if (i > 6){
				//these must be digits, otherwise return false
				if(!isDigit(str.charAt(i))){
					return false;
				}
			}
		}
		//return true if no errors occur
		return true;
	}
	public static boolean isDigit(char c){
		return Character.isDigit(c);
	}
	public static boolean isDash(char c){
		return (c == '-');
	}

}
