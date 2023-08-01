package BinarySearch;

import java.util.Map;
import java.util.TreeMap;

public class SearchRotatedSorted {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 0, 1, 2};
        int target = 0;


        System.out.println(SearchRotatedSortedFunc(nums, target));

    }

    private static int SearchRotatedSortedFunc(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[low] < nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid -1;
                } else  {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else  {
                    high = mid - 1;
                }
            }
        }

        return low;
    }

}