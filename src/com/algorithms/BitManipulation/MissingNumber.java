package BitManipulation;

public class MissingNumber {
    public static void main(String[] args) {

        int[] nums = {0 , 2, 3};

        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }

        System.out.println(missing);
    }
}
