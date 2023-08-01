package TwoDp;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        int[][] dp = new int[m][n];
        System.out.println(UniquePathsFunc(m , n, 0, 0, dp));
    }

    private static int UniquePathsFunc(int m, int n, int i, int j, int[][] dp) {

        if (i == m - 1 && j == n - 1) {
            return 1;
        } else if (i > m - 1 || j > n - 1) {
            return 0;
        }

        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        int a = UniquePathsFunc(m, n, i+1, j, dp);

        int b = UniquePathsFunc(m, n, i, j + 1, dp);

        dp[i][j] = a+b;

        return a + b;
    }
}
