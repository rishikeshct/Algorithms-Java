package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        String str = "bacabcdbb";
        System.out.println(LongestSubstringWithoutRepeatingCharFunc(str));

        System.out.println(LongestSubstringWithoutRepeatingCharFuncMap(str));

    }

    private static int LongestSubstringWithoutRepeatingCharFuncMap(String str) {

        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int maxElement = 0;

        for (int end =0; end < str.length(); end++) {
            char currenntChar = str.charAt(end);

            if (map.containsKey(currenntChar)) {
                start = map.get(currenntChar) + 1;
            }

            map.put(currenntChar, end);
            maxElement =    Math.max(end - start + 1, maxElement);
        }

        return maxElement;
    }

    private static int LongestSubstringWithoutRepeatingCharFunc(String str) {

        int maxCount = 0;
        int currentCount = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < str.length(); right++) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                maxCount=Math.max(maxCount,right-left+1);
            }
            else {
                while (str.charAt(left) != str.charAt(right)) {
                    set.remove(str.charAt(left));
                    left++;
                }
                set.remove(str.charAt(left));
                set.add(str.charAt(right));
                left++;
            }

        }
        return maxCount;
    }
}

