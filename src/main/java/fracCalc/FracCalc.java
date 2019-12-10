package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		String original = userInput();
		produceAnswer(original);
	}
// TODO: Read the input from the user and call produceAnswer with an equation


	public static String userInput() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Type Your Equation Here");
		String original = userInput.nextLine();
		return original;
		

	}

// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
// test your code
// This function takes a String 'input' and produces the result
//
// input is a fraction string that needs to be evaluated. For your program, this
// will be the user input.
// e.g. input ==> "1/2 + 3/4"
//
// The function should return the result of the fraction after it has been
// calculated
// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
// TODO: Implement this function to produce the solution to the input
	
		String right = "";
		String left = "";
// separate left and right
		int space = input.indexOf(" ");
		if (Character.isWhitespace(input.charAt(space + 2))) {
			String operator = Character.toString(input.charAt(space + 1));
			left = input.substring(0, space);
			right = input.substring(space + 3, input.length());
			
		}
		return (right);
	}
}

