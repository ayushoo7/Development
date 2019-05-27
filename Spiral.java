package com.ayush.unique;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Spiral {

	public static void main(String[] args) {

		String input = "ABCDEFGHIJKLMN";
		char[] charArray = input.toCharArray();
		List<Character> collect = input.chars().mapToObj(x -> (char) x).collect(Collectors.toList());
		Collections.sort(collect);
		Stack<Character> order = new Stack();
		Stack<Character> reverse = new Stack();
		int j = 0;
		System.out.println(collect);
		boolean toggle = true;
		for (int i = 0; i < collect.size(); ) {
			j++;
			
			int k =j;
			do {
				Character c = collect.get(i);
				if (toggle) {
					order.push(c);

				} else {
					order.push(c);

				}
				i++;
				k--;
			}
			while (k > 0  && collect.size() > i);
			if (toggle) {
				while(!order.isEmpty()) {
					reverse.push(order.pop());
				}
				while (!reverse.isEmpty()) {
					System.out.print(reverse.pop());
				}

			} else {
				while (!order.isEmpty()) {
					System.out.print(order.pop());
				}

			}
			order.clear();
			reverse.clear();
			System.out.println();
			toggle =! toggle;

		}

		

	}

}
