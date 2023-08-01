package arrays;

public class FindMaxDifference {
    public static void main(String[] args) {
        int[] arr = {2, 9, 5, 1, 6, 4};
        int maxDifference = findMaxDifference(arr);
        System.out.println("Maximum difference: " + maxDifference);
    }

    private static int findMaxDifference(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        int maxDifference = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < minElement) {
                minElement = arr[i];
            } else {
                int difference = arr[i] - minElement;
                if (maxDifference < difference) {
                    maxDifference = difference;
                }
            }

        }

        return maxDifference;
    }
}
