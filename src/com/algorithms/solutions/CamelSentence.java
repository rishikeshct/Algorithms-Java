package com.geeksforgeeksalgos.solutions;

public class CamelSentence {

	public static void main(String[] args) {
		
		String str = "I got intern at geeksforgeeks";
		String[] strArray = str.split(" ");
		String result = strArray[0];

		for(int i=1; i<strArray.length; i++){
			result += Character.toUpperCase(strArray[i].charAt(0)) + strArray[i].substring(1, strArray[i].length());
		}
		System.out.println(result);
	}
}
