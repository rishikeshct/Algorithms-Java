package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};

        int target = 8;

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        CombinationSumFunc(0, nums, new ArrayList<>(), result, target);

        result.forEach(res -> System.out.println(res));

    }

    private static void CombinationSumFunc(int index, int[] nums, List<Integer> currList, List<List<Integer>> result, int target) {
        if (target == 0) {
            List<Integer> copyList = new ArrayList<>(currList);
            result.add(copyList);
            return;
        }
        else if (index >= nums.length || target < nums[index]) {
            return;
        }


        currList.add(nums[index]);
        CombinationSumFunc(index + 1, nums, currList, result, target - nums[index]);

        currList.remove(currList.size()-1);

        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index += 1;
        }

        CombinationSumFunc(index + 1, nums, currList, result, target);

    }
}
