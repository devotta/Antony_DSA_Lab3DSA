package com.gl.balancing;

import java.util.*;

public class Balancingbrackets {
	//isValidstring Returns True - valid string with brackets [{()}]
	//              Returns False- Invalid string -any char other than brackets
	public static boolean isValidstring(String str) {
		boolean isValid = true;
		//Loop through each char of the string
		for (int i = 0; i < str.length(); i++) {
			if (!("{}()[]".indexOf(str.charAt(i)) >= 0)) {
				isValid = false;
				break;
			}

		}
		return isValid;

	}

	public static boolean checkmatchingBrackets(String str) {
		Stack<Character> stack = new Stack<>();
		char c;
		// Loop through each character in string entered
		for (int i = 0; i < str.length(); i++) {

			// push open brackets '[ { (' into the stack
			if ((str.charAt(i) == '[') || (str.charAt(i) == '(') || (str.charAt(i) == '{')) {
				stack.push(str.charAt(i));
			}
			// pop out of the stack if matching '}'
			if (str.charAt(i) == '}') {
				c = stack.pop();
				if (c != '{')
					break;
			}

			// pop out of the stack if matching ']'
			if (str.charAt(i) == ']') {
				c = stack.pop();
				if (c != '[')
					break;
			}

			// pop out of the stack if matching ')'
			if (str.charAt(i) == ')') {
				c = stack.pop();
				if (c != '(')
					break;
			}
		}
		// If stack is empty - true - balanced
		// Or else - false - Not balanced
		if (stack.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String br;
		int i=0;
            //Loop is to re-enter the correct string[
			do {
				System.out.println("Enter the brackets : ");
				br = sc.nextLine();
				
				// calling a isValidstring function
				// Validates the string entered by the user
				if (!isValidstring(br))
					System.out.println("Not a valid string - Please enter valid brackets");
			
				// if is invalid string (other than brackets)
				// user can continue by entering valid string
			} while (!isValidstring(br));

			// CheckmatchBrackets True - Balanced bracket
			// and False - Not balanced brackets
			if (checkmatchingBrackets(br))
				System.out.println("The entered String has Balanced Brackets");
			else
				System.out.println("The entered String does not contain Balanced Brackets");
	

		sc.close();
		System.out.println("------Program successfully completed------");
	}
}