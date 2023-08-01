package BinarySearch;

public class SearchInMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        int target = 3;

        System.out.println(SearchInMatrixFunc(matrix, target));

    }

    private static boolean SearchInMatrixFunc(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int start  =0;
        int end = m * n - 1;
        while (start < end) {

            int midIdx =  (end - start) / 2;
            int rowMid = midIdx / n;
            int columnMid = midIdx % n;

            int mid = matrix[rowMid][columnMid];

            if (mid == target) {
                return true;
            } else if (target > mid) {
                start = midIdx + 1;
            } else {
                end = midIdx - 1;
            }

        }

        return false;
    }
}
