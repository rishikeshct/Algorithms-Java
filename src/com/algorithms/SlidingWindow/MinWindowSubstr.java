package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstr {
    public static String minWindow(String s, String t) {

        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int count = t.length();

        for (int i =0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (end < s.length()) {

            if (map.containsKey(s.charAt(end))) {
                if (map.get(s.charAt(end)) > 0 )  {
                    count--;
                }
                map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)-1);
            }
            end++;

            while (count == 0) {

                if (minLength > end - start) {
                    minStart = start;
                    minLength = end -start;
                }

                if (map.containsKey(s.charAt(start))) {
                    if (map.get(s.charAt(start)) >= 0 )  {
                        count++;
                    }
                    map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0)+1);
                }
                start++;
            }

        }

        return s.substring(minStart, minStart +minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minWindowSubstring = minWindow(s, t);
        System.out.println("Minimum window substring: " + minWindowSubstring);
    }
}