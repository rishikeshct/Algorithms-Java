package BackTracking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,2, 3};

        List<List<Integer>> result = new ArrayList<>();

        PermutationFunc(result, new ArrayList<>(),nums);

        result.forEach(res -> System.out.println(res));
    }

    private static void PermutationFunc(List<List<Integer>> result,  List<Integer> temp, int[] nums) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            PermutationFunc(result, temp, nums);
            temp.remove(temp.size()- 1);
        }
    }
}
