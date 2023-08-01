package DP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPalindromeSubstring {
    static int maxLen = 0;
    static int start = 0;

    static List<String> palindromes = new ArrayList<>();
    public static void main(String[] args) {
        String s = "babad";
       LongestPalindromeSubstringFunc(s);
      String str = s.substring(start, start + maxLen);
        System.out.println(str);
        System.out.println(palindromes);
    }

    private static void LongestPalindromeSubstringFunc(String s) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            expandString(charArray, i, i);
            expandString(charArray, i, i+1);
        }
    }

    private static void expandString(char[] charArray, int left, int right) {
        while (left >= 0 && right < charArray.length && charArray[left] == charArray[right]) {
            palindromes.add(String.valueOf(charArray).substring(left, right + 1));
            left--;
            right++;
        }

        if (maxLen < right - left - 1) {
            maxLen = right - left - 1;
            start = left + 1;
        }
    }
}
