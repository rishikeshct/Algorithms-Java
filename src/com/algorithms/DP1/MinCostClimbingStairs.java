package DP1;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};

        int[] dp = new int[cost.length];

        System.out.println(Math.min(MinCostClimbingStairsFunc(cost, cost.length-1), MinCostClimbingStairsFunc(cost, cost.length-2)));
        System.out.println(MinCostClimbingStairsFunc2(cost, dp));
    }

    private static int MinCostClimbingStairsFunc(int[] cost, int i) {

        if (i == 0 || i == 1) {
            return cost[i];
        }

        return Math.min(MinCostClimbingStairsFunc(cost, i - 1) + cost[i], MinCostClimbingStairsFunc(cost, i-2) + cost[i]);
    }

    private static int MinCostClimbingStairsFunc2(int[] cost, int[] dp) {
        dp[cost.length - 1] = cost[cost.length-1];
        dp[cost.length - 2] = cost[cost.length-2];

        for (int i = cost.length - 3; i >=0 ; i--) {
            dp[i] = Math.min(dp[i + 1], dp[i+2]) + cost[i];
        }

        return Math.min(dp[0], dp[1]);
    }

}
