package MathAndGeometry;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};

        RotateMatrixFunc(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void RotateMatrixFunc(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int k = 0;

        int curr;
        while (k < m - 1) {
            int i = 0;
            int j = 0;
            curr = matrix[i][j];
            for (j = 1; j < n; j++) {
                int next = matrix[i][j];
                matrix[i][j] = curr;
                curr = next;
            }

            j--;
            for (i = 1; i < m; i++) {
                int next = matrix[i][j];
                matrix[i][j] = curr;
                curr = next;
            }

            i--;
            for (j = n - 2; j >= 0; j--) {
                int next = matrix[i][j];
                matrix[i][j] = curr;
                curr = next;
            }

            j++;
            for (i = n - 2; i >= 0; i--) {
                int next = matrix[i][j];
                matrix[i][j] = curr;
                curr = next;
            }

            k++;
        }
    }
}
