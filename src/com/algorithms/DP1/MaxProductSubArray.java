package DP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {6, 1, 5, -3};
        //brute force
        System.out.println(MaxProductSubArrayFunc(nums));

        System.out.println(MaxProductSubArrayFunc2(nums));

        System.out.println(MaxProductSubArrayFunc3(nums));

    }

    private static int MaxProductSubArrayFunc3(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prod = 1;

        for (int i = 0; i < nums[i]; i++) {
            prod = prod * nums[i];

           max = Math.max(prod, max);
        }

        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod = prod * nums[i];
            max = Math.max(prod, max);
        }

        return max;
    }


    private static int MaxProductSubArrayFunc2(int[] nums) {
        int max = 1;
        int min = 1;
        int res = Collections.max(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                max = 1;
                min = 1;
                continue;
            }

            int temp =nums[i] * max;
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.max(temp, nums[i] * min), nums[i]);

            res = Math.max(res, max);

        }

        return res;
    }

    private static int MaxProductSubArrayFunc(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product = product * nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }
}
