package TwoPointers;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(TrappingRainWaterFunc(height));
    }

    private static int TrappingRainWaterFunc(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                left[i] = max;
            } else  {
                left[i] = max;
            }
        }

        max = Integer.MIN_VALUE;
        for (int i = height.length-1; i >=0 ; i--) {
            if (height[i] > max) {
                max = height[i];
                right[i] = max;
            } else {
                right[i] = max;
            }
        }
        System.out.println(Arrays.toString(height));
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < left[i] && height[i] < right[i]) {
                result += Math.min(left[i], right[i]) - height[i];
            }
        }

        return result;
    }
}
