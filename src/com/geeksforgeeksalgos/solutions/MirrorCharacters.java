package com.geeksforgeeksalgos.solutions;

public class MirrorCharacters {

	public static void main(String[] args) {
		String mirrorAlphabets = "zyxwvutsrqponmlkjihgfedcba";
		String str = "abcdef";
		String mirror = "";
		for (int i = 0; i < str.length(); i++) {
			mirror += mirrorAlphabets.charAt(str.charAt(i) - 'a');
		}
		System.out.println(mirror);
	}
}
