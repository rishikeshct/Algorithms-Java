package DP1;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        String str = "123";
        int[] dp = new int[str.length()];
        Arrays.fill(dp, -1);
        System.out.println(countDecodings(str, 0));

        System.out.println(countDecodingsMemo(str, 0, dp));

        System.out.println(numDecodings(str));
    }

    private static int countDecodings(String s, int index) {
        if (index == s.length()) {
            return 1;
        }

        char currentChar = s.charAt(index);
        if (currentChar == '0') {
            return 0;
        }

        int count = countDecodings(s, index + 1);

        if (index < s.length() - 1) {
            char nextChar = s.charAt(index + 1);
            int num = Integer.parseInt("" + currentChar + nextChar);
            if (num <= 26) {
                count += countDecodings(s, index + 2);
            }
        }

        return count;
    }

    private static int countDecodingsMemo(String s, int index, int[] dp) {
        if (index == s.length()) {
            return 1;
        }

        if (dp[index] != -1) {
            return dp[index];
        }


        char currentChar = s.charAt(index);
        if (currentChar == '0') {
            return 0;
        }

        int count = countDecodings(s, index + 1);

        if (index < s.length() - 1) {
            char nextChar = s.charAt(index + 1);
            int num = Integer.parseInt("" + currentChar + nextChar);
            if (num <= 26) {
                count += countDecodings(s, index + 2);
            }
        }

        return dp[index] = count;
    }

    static int numDecodings(String s) {
        int i,n=s.length();
        if(s.length()==0|| s.charAt(0)=='0')
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0]=1;
        dp[1]=1;

        for(i=2;i<=n;i++){
            if(s.charAt(i-1)>='1'&&s.charAt(i-1)<='9')
                dp[i]=dp[i-1];
            if(s.charAt(i-2)=='1')
                dp[i]+=dp[i-2];
            else if(s.charAt(i-2)=='2'&&(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9'))
                dp[i]+=dp[i-2];
        }
        return dp[n];
    }
}
