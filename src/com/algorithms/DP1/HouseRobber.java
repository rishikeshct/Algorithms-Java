package DP1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {

        /**
         * https://leetcode.com/problems/house-robber/solutions/156523/from-good-to-great-how-to-approach-most-of-dp-problems/
         */
        int[] nums = {100,1,1,100,1, 400};
        System.out.println(rob(nums, nums.length - 1));
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        System.out.println(robWithMemo(nums, memo, nums.length - 1));
        System.out.println(robWithIterative(nums));
    }

    private static int robWithIterative(int[] nums) {

        int rob1 = 0;
        int rob2 = 0;

        for (int i = 0; i < nums.length ; i++) {
            int newRoob = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = newRoob;
        }

        return  rob2;
    }

    private static int robWithMemo(int[] nums, int[] memo, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] > 0) {
            return  memo[i];
        }
        int left = rob(nums, i - 2) + nums[i];
        int right = rob(nums, i - 1);
        int result  = Math.max(left, right);
        memo[i] = result;
        return result;
    }

    private static int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        int left = rob(nums, i - 2) + nums[i];
        int right = rob(nums, i - 1);
        return Math.max(left, right);
    }
}
