package MathAndGeometry;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},
                          {3,4,5,2},
                          {1,3,1,5}};



        System.out.println(Arrays.deepToString(matrix));

        SetMatrixZeroesFuncWithMem(matrix);
        System.out.println(Arrays.deepToString(matrix));

        int[][] matrix2 = {{0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};

        SetMatrixZeroesFunc(matrix2);

        System.out.println(Arrays.deepToString(matrix2));

        int[][] matrix1 = {{0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};
        SetMatrixZeroesFunc2(matrix1);

        System.out.println(Arrays.deepToString(matrix1));
    }

    private static void SetMatrixZeroesFuncWithMem(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row = 0;
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i<n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1 ; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i<m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1 ; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row == 0) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    private static void SetMatrixZeroesFunc(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    for (int k = 0; k < n; k++) {
                        if (matrix[i][k] != 0) {
                            visited[i][k] = true;
                        }
                        matrix[i][k] = 0;
                    }

                    for (int l = 0; l < m; l++) {
                        if (matrix[l][j] != 0) {
                            visited[l][j] = true;
                        }

                        matrix[l][j] = 0;
                    }
                }
            }
        }

    }

    private static void SetMatrixZeroesFunc2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && matrix[i][j] != Integer.MAX_VALUE) {
                    for (int k = 0; k < n; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = Integer.MAX_VALUE;
                        } else {
                            matrix[i][k] = 0;

                        }
                    }

                    for (int l = 0; l < m; l++) {
                        if (matrix[l][j] != 0) {
                            matrix[l][j] = Integer.MAX_VALUE;
                        } else
                        {
                            matrix[l][j] = 0;
                        }

                    }
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
