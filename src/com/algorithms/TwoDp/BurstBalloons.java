package TwoDp;

public class BurstBalloons {
    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        var dp = new int[nums.length][nums.length];

        System.out.println(burst(nums, 0, nums.length - 1, dp));
    }
    private static int burst(int[] nums, int left, int right, int[][] dp) {
        if (left > right) {
            return 0;
        }
//        if (dp[left][right] != 0) {
//            return dp[left][right];
//        }

        int maxCoins = 0;
        for (int i = left; i <= right; i++) {
            int coins = nums[i];

            if (left - 1 >= 0) {
                coins *= nums[left - 1];
            }
            if (right + 1 < nums.length) {
                coins *= nums[right + 1];
            }

            coins +=
                    burst(nums, left, i - 1, dp) + burst(nums, i + 1, right, dp);
            maxCoins = Math.max(maxCoins, coins); // dp[left][right] = Math.max(dp[left][right], coins);
        }

        return maxCoins; //dp[left][right]
    }
}
