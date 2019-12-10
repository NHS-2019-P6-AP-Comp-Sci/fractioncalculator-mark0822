package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		String original = userInput();
		produceAnswer(original);
	}
// TODO: Read the input from the user and call produceAnswer with an equation

//Simplify the fraction
	public static int simplify(int numerator, int denominator) {
		int num = Math.abs(numerator);
		int denom = Math.abs(denominator);
		while (num != denom) {
			if (num > denom)
				num = num - denom;
			else
				denom = denom - num;
		}
		return Math.min(num, denom);
	}

//UserInput
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
		int leftnumerator = 0;
		int rightnumerator = 0;
		int leftdenominator = 0;
		int rightdenominator = 0;
		int numerator = 0;
		int denominator = 0;
		int rightNum = 0;
		int leftNum = 0;
		int gcd = 0;
		int finalNum = 0;
		int finalNumerator = 0;
		String answer = "";

// separate left and right
		int space = input.indexOf(" ");
		if (Character.isWhitespace(input.charAt(space + 2))) {
			String operator = Character.toString(input.charAt(space + 1));
			String left = input.substring(0, space);

// separate numerator and denominator
			if (left.indexOf("/") != -1) {
				int leftDivide = left.indexOf("/");

// check underscore
				if (left.indexOf("_") != -1) {
					leftNum = Integer.parseInt(left.substring(0, left.indexOf("_")));
					leftdenominator = Integer.parseInt(left.substring(leftDivide + 1, left.length()));
					leftnumerator = Integer.parseInt(left.substring(left.indexOf("_") + 1, leftDivide))
							+ Math.abs(leftNum) * leftdenominator;
					if (String.valueOf(leftNum).contains("-")) {
						leftnumerator = Integer.parseInt("-" + leftnumerator);
					}
				} else {
					leftnumerator = Integer.parseInt(left.substring(0, leftDivide));
					leftdenominator = Integer.parseInt(left.substring(leftDivide + 1, left.length()));
				}
			} else {
				leftnumerator = Integer.parseInt(left);
				leftdenominator = 1;

			}

// separate numerator and denominator
			String right = input.substring(space + 3, input.length());
			if (right.indexOf("/") != -1) {
				int rightDivide = right.indexOf("/");

// check underscore
				if (right.indexOf("_") != -1) {
					rightNum = Integer.parseInt(right.substring(0, right.indexOf("_")));
					rightdenominator = Integer.parseInt(right.substring(rightDivide + 1, right.length()));
					rightnumerator = Integer.parseInt(right.substring(right.indexOf("_") + 1, rightDivide))
							+ Math.abs(rightNum) * rightdenominator;
					if (String.valueOf(rightNum).contains("-")) {
						rightnumerator = Integer.parseInt("-" + rightnumerator);
					}
				} else {
					rightnumerator = Integer.parseInt(right.substring(0, rightDivide));
					rightdenominator = Integer.parseInt(right.substring(rightDivide + 1, right.length()));
				}
			} else {
				rightnumerator = Integer.parseInt(right);
				rightdenominator = 1;
			}

// check if denominator is zero
			if (rightdenominator == 0 || leftdenominator == 0) {
				System.out.println("ERROR: Cannot divide by zero.");
				System.exit(0);
			}

// operators
			if (operator.contains("+")) {
				numerator = leftnumerator * rightdenominator + rightnumerator * leftdenominator;
				denominator = leftdenominator * rightdenominator;
			}
			if (operator.contains("-")) {
				numerator = leftnumerator * rightdenominator - rightnumerator * leftdenominator;
				denominator = leftdenominator * rightdenominator;
			}
			if (operator.contains("*")) {
				numerator = leftnumerator * rightnumerator;
				denominator = leftdenominator * rightdenominator;
			}
			if (operator.contains("/")) {
				numerator = leftnumerator * rightdenominator;
				denominator = rightnumerator * leftdenominator;
			}

// simplify
			if (numerator != 0 && denominator != 0) {
				gcd = simplify(numerator, denominator);
				System.out.println(gcd);
				numerator = numerator / gcd;
				denominator = denominator / gcd;
				System.out.println(numerator);
				System.out.println(denominator);
			}
// output
			finalNum = numerator / denominator;
			finalNumerator = Math.abs(numerator % denominator);

			if (finalNum != 0) {
				if (finalNumerator != 0) {
					if (denominator != 1) {
						answer = finalNum + "_" + finalNumerator + "/" + Math.abs(denominator);
					} else {
						answer = finalNum + "_" + finalNumerator;
					}
				} else {
					answer = Integer.toString(finalNum);
				}

			} else {
				if (denominator != 1) {
					answer = numerator + "/" + Math.abs(denominator);
				} else {
					answer = Integer.toString(numerator);
				}
			}

			if (numerator == 0) {

				answer = Integer.toString(0);
			}
		} else {
			System.out.println("ERROR: Input is in an invalid format.");
			System.exit(0);
		}

		System.out.println(answer);

		return answer;
	}

}
