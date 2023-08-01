package Greedy;

import java.util.Arrays;

public class Jump2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        System.out.println(JumpGame2Func(nums));
    }

    private static int JumpGame2Func(int[] nums) {

            int left = 0;
            int right = 0;
            int res =0;

            while (right < nums.length - 1) {
                int farthest = 0;
                for (int i = left; i <= right; i++) {
                    farthest = Math.max(farthest, nums[i] + i);
                }
                left = right+1;
                right = farthest;
                res +=1;
            }

            return res;
    }
}
