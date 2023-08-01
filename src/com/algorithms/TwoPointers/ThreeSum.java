package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0 , 1, 2, -1, -4, 4};

        System.out.println(ThreeSumFunc(nums));
    }

    private static List<List<Integer>> ThreeSumFunc(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    ans.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }
}
