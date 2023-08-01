package Greedy;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {1,1,0,5,2};

        System.out.println(JumpGameFunc(nums));
        System.out.println(JumpGameFunc2(nums));
    }

    private static boolean JumpGameFunc(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            int k = nums[i];
            while (k >= 0) {
                if ((i + k  >= nums.length - 1 || (i + k < nums.length &&dp[i + k]))) {
                    dp[i] = true;
                    break;

                }
                k--;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    private static boolean JumpGameFunc2(int[] nums) {

        int goal = nums.length -  1;
        for(int i = nums.length - 1; i>= 0; i--) {
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}
