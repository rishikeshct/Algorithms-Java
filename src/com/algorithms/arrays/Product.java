package arrays;

import java.util.Arrays;

public class Product {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};
        int[] res = new Product().productExceptSelf(array);
        System.out.println(Arrays.toString(res));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int right=1,left=1;
        for(int i=0;i<n;i++){
            res[i]=1;
        }
        for (int i=0;i<n;i++) {
            res[i]*=left;
            left*=nums[i];
        }
        for(int i=n-1;i>=0;i--) {
            res[i]*=right;
            right*=nums[i];
        }
        return res;
    }
}
