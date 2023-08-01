package BinarySearch;

public class MinRotatedSorted {
    public static void main(String[] args) {
        int[] nums = {3,4,5};
        System.out.println(MinRotatedSortedFunc(nums));
    }

    private static int MinRotatedSortedFunc(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
                if (nums[mid] > nums[mid+1]) {
                    return nums[mid+1];
                } else {
                    start = mid + 1;
                }
            }


        return  -1;
    }
}
