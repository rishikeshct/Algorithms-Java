package DP1;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            System.out.println(false); ;
        }

        int targetSum = sum / 2;

        System.out.println(         canPartitionRecursive(0, targetSum, nums));
    }

    private static boolean canPartitionRecursive(int currentIndex, int remainingSum, int[] nums) {
        if (remainingSum == 0) {
            return true; // Base case: Found a valid partition
        }

        if (currentIndex >= nums.length || remainingSum < 0) {
            return false; // Base case: Invalid partition
        }

        // Include the current element in the subset
        boolean includeCurrent = canPartitionRecursive(currentIndex + 1, remainingSum - nums[currentIndex], nums);

        // Exclude the current element from the subset
        boolean excludeCurrent = canPartitionRecursive(currentIndex + 1, remainingSum, nums);

        return includeCurrent || excludeCurrent;
    }

}
