package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 8;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        SubsetSumFunc(0, nums, currList, result, target);
        result.forEach(res -> System.out.println(List.of(res)));
    }

    private static void SubsetSumFunc(int index, int[] nums, List<Integer> currList, List<List<Integer>> result, int target) {
 if (target == 0) {
            List<Integer> copyList = new ArrayList<>(currList);
            result.add(copyList);
            return;
        }
       else if (index >= nums.length || target < nums[index]) {
            return;
        }


        currList.add(nums[index]);
        SubsetSumFunc(index, nums, currList, result, target - nums[index]);

        currList.remove(currList.size()-1);
        SubsetSumFunc(index + 1, nums, currList, result, target);

    }
}
