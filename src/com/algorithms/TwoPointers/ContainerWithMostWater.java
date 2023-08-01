package TwoPointers;

import java.awt.*;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};

        System.out.println(ContainerWithMostWaterFunc(nums));
    }

    private static int ContainerWithMostWaterFunc(int[] nums) {
        int max = 0;
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            max = Math.max(Math.min(nums[i], nums[j]) * (j - i ), max);
            if (nums[i] > nums[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}
