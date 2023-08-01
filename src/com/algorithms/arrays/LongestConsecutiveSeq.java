package arrays;

import java.util.HashSet;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2, 5};

        System.out.println(LongestConsecutiveSeqFunc(nums));
    }

    private static int LongestConsecutiveSeqFunc(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxSeq = 0;

        for (int i = 0; i < nums.length; i++) {
            int currSeq = 1;

            if (!set.contains(nums[i] - 1)) {
                int current  = nums[i];
                while (set.contains(++current)) {
                    currSeq++;
                }
                maxSeq = Math.max(currSeq, maxSeq);
            }
        }

        return maxSeq;
    }
}
