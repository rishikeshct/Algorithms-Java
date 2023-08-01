package DP1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {

        String s  = "rishikesh";
        String[] wordDict = {"rishi", "kesh"};
        System.out.println(wordBreakHelper(s, new HashSet<>(List.of(wordDict))));
        System.out.println(wordBreakHelper2(s, wordDict));
    }

    private static boolean wordBreakHelper(String s, Set<String> wordSet) {
        if (s.isEmpty()) {
            return true; // Base case: empty string can be segmented
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix) && wordBreakHelper(s.substring(i), wordSet)) {
                return true; // If prefix is in dictionary and remaining string can be segmented, return true
            }
        }

        return false; // No segmentation found
    }
    private static boolean wordBreakHelper2(String s, String[] words) {
      boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
             for (String word : words) {
                 if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
                     dp[i] = dp[i + word.length()];
                     break;
                 }
             }
        }

        return dp[0];
    }
}
