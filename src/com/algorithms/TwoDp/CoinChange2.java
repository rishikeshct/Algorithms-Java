package TwoDp;

import java.util.Arrays;

public class CoinChange2 {
    static int count = 0;
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};

        int[][] dp = new int[6][6];
        for (int i =0; i< 5; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(CoinChange2Func(coins, amount, 0));

        System.out.println(changeDP(amount, coins));


    }

    public static int changeDP(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    private static int CoinChange2Func(int[] coins, int amount, int index) {
        if (amount == 0) {
            return 1;
        } else if (amount < 0 || index >= coins.length) {
            return 0;
        }

           int include = CoinChange2Func(coins, amount - coins[index], index);
           int exclude = CoinChange2Func(coins, amount, index+1);


        return include+exclude;
    }
}
