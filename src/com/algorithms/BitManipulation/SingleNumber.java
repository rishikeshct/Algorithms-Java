package BitManipulation;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,2, 3, 4};
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        System.out.println(ans);

    }
}
