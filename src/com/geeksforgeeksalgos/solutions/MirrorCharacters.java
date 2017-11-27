package com.geeksforgeeksalgos.solutions;

public class MirrorCharacters {

	public static void main(String[] args) {
		String reservedAlphabets = "zyxwvutsrqponmlkjihgfedcba";
		String str = "abcdef";
		String mirror = "";
		for (int i = 0; i < str.length(); i++) {
			mirror += reservedAlphabets.charAt(str.charAt(i) - 'a');
		}
		System.out.println(mirror);
	}
}
