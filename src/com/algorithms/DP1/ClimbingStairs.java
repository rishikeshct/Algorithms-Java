package DP1;

public class ClimbingStairs {
    static int count = 0;
    static int[] dp = new int[6];
    public static void main(String[] args) {

        int n = 5;
        ClimbingStairsFunc(n, 0);
        System.out.println(count);

        System.out.println(ClimbingStairFunc2(n));
        System.out.println(ClimbingStairFunc3(n));
        ;
    }

    private static void ClimbingStairsFunc(int n, int target) {
        if (target == n) {
            count++;
            return;
        } else if (target > n) {
            return;
        }

        ClimbingStairsFunc(n, target + 1);

        ClimbingStairsFunc(n, target + 2);
    }

    private static int ClimbingStairFunc2(int n) {
        if (n <= 2) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = ClimbingStairFunc2(n - 1) + ClimbingStairFunc2(n - 2);
        return dp[n];
    }

    private static int ClimbingStairFunc3(int n) {
        int a = 1;
        int b = 1;

        for (int i =0; i < n -1 ; i++) {
            int temp = a;
            a = a + b;
            b = temp;
        }

        return a;
    }
}
