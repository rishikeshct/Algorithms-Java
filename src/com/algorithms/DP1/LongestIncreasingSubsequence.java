package DP1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(LongestIncreasingSubsequenceFunc(nums));
    }

    private static int LongestIncreasingSubsequenceFunc(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = nums.length - 1; i>=0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i],1 + dp[j]);
                }
            }
        }

        return Collections.max(Arrays.stream(dp).boxed().collect(Collectors.toList()));
    }

}
