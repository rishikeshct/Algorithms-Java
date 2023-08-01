package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        SubsetFunc(0, nums, currList, result);
        result.forEach(res -> System.out.println(List.of(res)));
    }

    private static void SubsetFunc(int index, int[] nums, List<Integer> currList, List<List<Integer>> result) {

        if (index == nums.length) {
            List<Integer> copyList = new ArrayList<>();
            for (int i = 0; i < currList.size(); i++) {
                copyList.add(currList.get(i));
            }
            result.add(copyList);
            return;
        }

        currList.add(nums[index]);
        SubsetFunc(index+1, nums, currList, result);

        currList.remove(currList.size()-1);
        SubsetFunc(index+1, nums, currList, result);
    }
}
