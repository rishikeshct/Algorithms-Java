package BitManipulation;

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) {
        int n = 5;

        int bits[] = new int[n+1];
        int bits_per_digit = 0;

        for (int i=0;i<=n;i++){
            int j = i;
            while (j != 0){
                int d = j % 2;
                bits_per_digit += d;
                j = j / 2;
            }
            bits[i] = bits_per_digit;
            bits_per_digit = 0;
        }

        System.out.println(Arrays.toString(bits));

         int[] dp = new int[n+1];
         int[] ans = new int[n+1];
         int offset = 1;
         dp[0] = 0;
         ans[0] = 0;
         for (int i = 1; i <=n; i++) {
             if (offset * 2 == i) {
                 offset = i;
             }

             dp[i] = 1 + dp [i % offset];
         }

        System.out.println(Arrays.toString(dp));

    }
}
