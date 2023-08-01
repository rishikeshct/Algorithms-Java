package DP1;

import java.util.Arrays;

public class CoinChange {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] coins = {1,2 ,5};
        int amount =11;
        int max = min;
        CoinChangeFunc(coins, amount, amount, 0, 0);
        if (max == min) {
            System.out.println(-1);
        } else  {
            System.out.println(min);
        }

        System.out.println(coinChange(coins, amount));
        int res = recursion(coins, amount, 0);

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);

        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);

        System.out.println(recursionMemo(coins, amount, 0, dp));


    }

    public static int recursion(int[] coins, int n, int number){
        if(n == 0)
            return number;
        if(n<0)
            return Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++) {
            int r = recursion(coins, n-coins[i], number+1);
            res = Math.min(res, r);
        }

        return res;
    }

    public static int recursionMemo(int[] coins, int n, int number, int[] dp){
        if(n == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++) {
            if (n - coins[i] >= 0) {
                int r = 0;
                if (dp[n-coins[i]] != -1 || dp[n-coins[i]] == Integer.MAX_VALUE) {
                    r = dp[n-coins[i]];
                } else {
                    r = recursionMemo(coins, n-coins[i], number+1, dp);
                }
                if (r != Integer.MAX_VALUE) {
                    res = Math.min(res, r + 1);
                }
            }
        }

        return dp[n] = res;
    }
    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        for(int i=0;i<amount+1;i++)
        {
            dp[i]=amount+1;
        }
        dp[0]=0;
        int a;
        for(a=1;a<amount+1;a++)
        {
            for(int c:coins)
            {
                if(a-c>=0)
                {
                    dp[a]=Math.min(dp[a],1+dp[a-c]);
                }

            }
        }
        if(dp[amount]!=amount+1)
        {
            return dp[amount];
        }
        else
        {
            return -1;
        }

    }




    private static void CoinChangeFunc(int[] coins, int amount,int target, int index, int count) {
        if (amount == 0) {
            if (count < min) {
                min = count;
            }
            return;
        } else if (amount < 0 || index > coins.length -1 ) {
            return;
        }

        CoinChangeFunc(coins, amount - coins[index], target, index, count + 1);

        CoinChangeFunc(coins, amount, target, index + 1, count);
    }
}
