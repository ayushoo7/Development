package com.ayush.datastructure;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String nextLine = scan.nextLine();
		Stack<String> stckString = new Stack<String>();
		List<String> lstOperator = Arrays.asList(new String[] { "+", "-", "*", "/", "%", "(" });
		for (String character : nextLine.split("")) {
			if (character.equals(")")) {
				String pop;
				do {
					pop = stckString.pop();
					if (!pop.contains("(")) {
						System.out.print(pop);
					}

				} while (!stckString.isEmpty() && !pop.equals("("));
			} else if (lstOperator.contains(character)) {
				// A*B-(C+D)+E
				while (!stckString.isEmpty() && !character.equalsIgnoreCase("(") && !stckString.peek().equals("(")
						&& lstOperator.indexOf(character) < lstOperator.indexOf(stckString.peek())) {// lower wala
																										// nikaal jaegaa
																										// aur upper
																										// walaa bhar
																										// jaegaa if
																										// lower walaa
																										// ayaa toh woo
																										// bhar jaegaa
					System.out.print(stckString.pop());
				}

				stckString.push(character);

			} else {
				System.out.print(character);
			}
		}
		while (!stckString.isEmpty()) {
			System.out.print(stckString.pop());
		}

	}
}