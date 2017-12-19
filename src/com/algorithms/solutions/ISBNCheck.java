package com.geeksforgeeksalgos.solutions;

public class ISBNCheck {

	public static void main(String[] args) {

		String str = "011211242";
		String success = "Not Valid";
		if(str.length() == 10){
			success = validISBN(str);
		}
		System.out.println(success);

	}

	private static String validISBN(String str) {

		int sum = 0;
		int i = 10;
		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) != 'X') {
				sum += i * (str.charAt(j) - '0');
				System.out.println(i * (str.charAt(j) - '0'));
			} else {
				sum += i * 10;
				System.out.println(i * 10);
			}
			i--;
		}
		System.out.println(sum);

		return (sum % 11 == 0) ? "Valid" : "Not Valid";

	}
}
