package com.geeksforgeeksalgos.solutions;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BracketSearch {

	public static void main(String[] args) {
		String str = "[ABC[23]][89]";

		System.out.println(findClosingBracket(str, 1));
	}

	private static String findClosingBracket(String str, int index) {
		List<String> myList = new ArrayList<String>(Arrays.asList(str.split("")));
		Stack<String> stack = new Stack<>();

		if (myList.get(index).equals("[")) {
			for (int i = index; i < myList.size(); i++) {
				if (myList.get(i).equals("[")) {
					stack.push(myList.get(i));
				}
				if (myList.get(i).equals("]")) {
					stack.pop();
					if (stack.isEmpty()) {

						return i + "";
					}
				}

			}

		}

		return "not found";

	}
}
