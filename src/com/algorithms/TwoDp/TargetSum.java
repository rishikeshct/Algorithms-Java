package TwoDp;

import java.util.*;

public class TargetSum {
    public static void main(String[] args) {
        /**
         * You are given an integer array nums and an integer target.
         *
         * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
         *
         * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
         * Return the number of different expressions that you can build, which evaluates to target.
         */

        int nums[] = {0, 0,0,0,1};
        int target = 1;
        int sum = 0;

//        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }


        Map<String, Integer> map= new HashMap<>();
        System.out.println(TargetSumFunc(nums, target, sum,  0, map));

        System.out.println(countExpressions(nums, target, 0, 0));

    }

    private static int TargetSumFunc(int[] nums, int target, int remaining, int i, Map<String, Integer> map) {

        if (i == nums.length) {
            return remaining == target ? 1 : 0; // Reached the end of the array
        }
        String key = i + "-" + remaining;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int a = TargetSumFunc(nums, target, remaining - (nums[i] * 2), i + 1, map);
        int b = TargetSumFunc(nums, target, remaining, i + 1, map);

        map.put(key, a + b);
        return a + b;

    }

    private static int countExpressions(int[] nums, int target, int index, int currentSum) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0; // Reached the end of the array
        }

        int ways = 0;
        ways += countExpressions(nums, target, index + 1, currentSum + nums[index]); // Adding '+' symbol
        ways += countExpressions(nums, target, index + 1, currentSum - nums[index]); // Adding '-' symbol

        return ways;
    }
}
