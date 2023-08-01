package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 8;

        System.out.println(Search(nums, target));
    }

    private static int Search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;


        while (left < right) {

            int mid = (left + right) / 2;

            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left= mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
