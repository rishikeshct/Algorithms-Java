package TwoDp;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(EditDistanceFunc(word1, word2, 0 , 0, dp));
    }

    private static int EditDistanceFunc(String word1, String word2, int i, int j, int[][] dp) {
        if (i >= word1.length() && j >= word2.length() ) {
            return 0;
        } else if (i >= word1.length() && j < word2.length()) {
            return word2.length() - j;
        } else if (i < word1.length() && j >= word2.length()) {
            return word1.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
           return dp[i][j] = EditDistanceFunc(word1,word2, i + 1, j + 1, dp);
        } else {
           return dp[i][j] = Math.min(Math.min(EditDistanceFunc(word1,word2, i , j + 1, dp),
            EditDistanceFunc(word1,word2, i + 1 , j, dp)),
            EditDistanceFunc(word1,word2, i + 1, j + 1, dp)) + 1;
        }
    }
}
