package comp2000;

import java.util.Scanner;
import java.util.Stack;

public class Lisp {

	private static Stack<Object> opStack = new Stack<>();
	private static Stack<Double> numStack = new Stack<>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string for evaluation: ");
		System.out.println(eval(input.nextLine()));
		input.close();
	}
	
	private static double eval(String input) {
		
		char a = ' ';
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == ' ')
				continue;
			else
				a = input.charAt(i);
			
			if(Character.isDigit(a))
				opStack.push(a);
			
			switch(a) {
				case '(':
					break;
				case ')':
					parenthesisEval();
					break;
				case '*':
				case '/':
				case '+':
				case '-':
					opStack.push(a);
					break;
			}
		}
		return Double.parseDouble(String.valueOf(opStack.pop()));
	}
	
	private static void parenthesisEval() {
		double result = 0;
		boolean isNum = true;
		String a = " ";

		while(isNum == true) {
			a = String.valueOf(opStack.pop());
			if(isNum(a))
				numStack.push(Double.valueOf(a));
			else
				isNum = false;
		}
		
		if(numStack.isEmpty())
			result += 0;
		else
			result = numStack.pop();
		
		switch(a) {
			case "*":
				if(numStack.isEmpty() && result == 0)
					result = 1;
				else if(numStack.isEmpty())
					result *= 1;
				while(!numStack.isEmpty())
					result *= numStack.pop();
				break;
			case "/":
				if(numStack.isEmpty() && result == 0) {
					System.out.println("CANNOT DIVIDE BY 0");
					System.exit(0);
				}
				else if(numStack.isEmpty())
					result = 1 / result;
				while(!numStack.isEmpty())
					result /= numStack.pop();
				break;
			case "+":
				if(numStack.isEmpty())
					result += 0;
				while(!numStack.isEmpty())
					result += numStack.pop();
				break;
			case "-":
				if(numStack.isEmpty())
					result *= -1;
				while(!numStack.isEmpty())
					result -= numStack.pop();
				break;
			default:
				break;
		}
		
		//System.out.println(result); //debugging purposes
		opStack.push(result);
	}
	
	public static boolean isNum(String a) {
	    try {
	        Double.parseDouble(a);
	        return true;
	    }
	    catch (NumberFormatException e) {
	        return false;
	    }
	}
	
}
