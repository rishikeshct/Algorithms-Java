package TwoDp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcds";
        String text2 = "races";

        Map<String, String> dp = new HashMap<>();
        System.out.println(findLCS(text1, text2, dp).length());

        System.out.println(findLCSDP(text1, text2));
    }

    private static int findLCSDP(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n+1];

        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= text2.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1 ;i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        for (int i = 0 ;i <= m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs.insert(0, text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println(lcs);
        return dp[text1.length()][text2.length()];
    }

    private static String findLCS(String s1, String s2, Map<String, String> dp) {
        int m = s1.length();
        int n = s2.length();

        if (m == 0 || n == 0) {
            return "";
        }

        if (dp.getOrDefault(s1+s2, "") != "") {
            return dp.getOrDefault(s1+s2, "");
        }

        char c1 = s1.charAt(m - 1);
        char c2 = s2.charAt(n - 1);

        if (c1 == c2) {
            return findLCS(s1.substring(0, m - 1), s2.substring(0, n - 1), dp) + c1;
        } else {
            String lcs1 = findLCS(s1, s2.substring(0, n - 1), dp);
            String lcs2 = findLCS(s1.substring(0, m - 1), s2, dp);
            String value = lcs1.length() > lcs2.length() ? lcs1 : lcs2;
            dp.put(s1+s2, value);
            return value;
        }
    }
}
