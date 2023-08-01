package MathAndGeometry;

import java.util.Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{7},
                         {9},
                          {6}};
        System.out.println(Arrays.deepToString(matrix));
        SpiralMatrixFunc(matrix);
    }

    private static void SpiralMatrixFunc(int[][] matrix) {

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int down = matrix.length - 1;


        /**
         *         int[][] matrix = {{1,2,3,4, 13},
         *                          {5,6,7,8, 14},
         *                           {9,10,11,12, 15}};
         */
        while (left <= right && top <= down) {

            for (int i = left; i <= right; i++ ) {
                System.out.println(matrix[top][i]);
            }

            top++;

             for (int i = top; i <= down; i++) {
                 System.out.println(matrix[i][right]);
             }



            right--;

             if (top <= down) {
                 for (int i = right; i >= left; i--) {
                     System.out.println(matrix[down][i]);
                 }
             }


            down--;

            if (left <= right) {
                for (int i = down; i >= top; i--) {

                    System.out.println(matrix[i][left]);
                }

            }

            left++;
        }

    }
}
