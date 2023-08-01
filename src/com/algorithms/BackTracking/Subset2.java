package BackTracking;

import java.util.*;

public class Subset2 {
    public static void main(String[] args) {
        int[] nums  = {1,2,2};
        List<List<Integer>> result = new ArrayList<>();
        Set<String> duplicate = new HashSet<>();
        Subset2Func(0 ,nums, result, new ArrayList<>(), duplicate);

        result.forEach(res -> System.out.println(res));

        Arrays.sort(nums);
        List<List<Integer>> result1 = new ArrayList<>();

        SubsetFuncSort(0, nums, new ArrayList<>(), result1);
        result1.forEach(res -> System.out.println(res));

    }

    private static void Subset2Func(int index, int[] nums, List<List<Integer>> result, List<Integer> currList, Set<String> duplicate) {

        if (index == nums.length) {
            if (!duplicate.contains(currList.toString())) {
                duplicate.add(currList.toString());
                System.out.println( "string " + Arrays.toString(nums));
                result.add(new ArrayList<>(currList));
            }
            return;
        }

        currList.add(nums[index]);
        Subset2Func(index + 1, nums, result, currList, duplicate);

        currList.remove(currList.size() - 1);
        Subset2Func(index + 1, nums, result, currList, duplicate);

    }

    private static void SubsetFuncSort(int index, int[] nums, List<Integer> currList, List<List<Integer>> result) {

        if (index == nums.length) {
            List<Integer> copyList = new ArrayList<>();
            for (int i = 0; i < currList.size(); i++) {
                copyList.add(currList.get(i));
            }
            result.add(copyList);
            return;
        }

        currList.add(nums[index]);
        SubsetFuncSort(index+1, nums, currList, result);

        currList.remove(currList.size()-1);

        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index += 1;
        }

        SubsetFuncSort(index+1, nums, currList, result);
    }
}
