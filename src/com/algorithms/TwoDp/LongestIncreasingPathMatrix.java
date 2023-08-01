package TwoDp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestIncreasingPathMatrix {
    public static void main(String[] args) {
        int[][] matrix =
                {{7,8,9},
                {6,6,5},
                {2,1,6}};
                System.out.println(LongestIncreasingPathMatrixFunc(matrix, matrix.length, matrix[0].length));

        Integer[][] cache = new Integer[matrix.length][matrix[0].length];
        int longest = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                longest = Math.max(longest, dfs(i, j, -1, matrix, cache));
            }
        }
        System.out.println(longest);    }

    private static int LongestIncreasingPathMatrixFunc(int[][] matrix, int m, int n) {
        int maxValue = Integer.MIN_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                Set<String> set = new HashSet<>();
                int res = FetchLongestPath2(matrix, i, j , m,n, set, map);
                maxValue = Math.max(res + 1, maxValue);
            }
        }
        map.forEach((key,value) -> System.out.println(key + " " + value));

        return maxValue;
    }

        private static int FetchLongestPath2(int[][] matrix, int i, int j, int m, int n, Set<String> set, Map<String, Integer> map) {
            if (i >= m || j >= n || i < 0 || j < 0) {
                return 0;
            }

            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;

            set.add(i + "_" + j);

            if (!set.contains(i + "_" + (j + 1)) && j + 1 < n && matrix[i][j + 1] > matrix[i][j]) {
                if (map.containsKey(i +"_"+ j + "right")) {
                    b = map.get(i +"_"+ j + "right");
                } else {
                    b = 1 + FetchLongestPath2(matrix, i, j + 1, m, n, set, map);
                    if (b != 0) {
                        map.put(i +"_"+ j + "right", b );
                    }
                }
            }

            if (!set.contains((i + 1) + "_" + j) && i + 1 < m && matrix[i + 1][j] > matrix[i][j]) {
                if (map.containsKey(i +"_"+ j + "down")) {
                    a = map.get(i +"_"+ j + "down");
                } else {
                    a = 1 + FetchLongestPath2(matrix, i + 1, j, m, n, set, map);
                    if (a != 0) {
                        map.put(i +"_"+ j + "down", a);
                    }
                }
            }

            if (!set.contains(i + "_" + (j - 1)) && j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
                if (map.containsKey(i +"_"+ j + "left")) {
                    d = map.get(i +"_"+ j + "left");
                } else {
                    d = 1 + FetchLongestPath2(matrix, i, j - 1, m, n, set, map);
                    if (d != 0) {
                        map.put(i +"_"+ j + "left", d );
                    }
                }
            }

            if (!set.contains((i - 1) + "_" + j) && i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
                if (map.containsKey(i +"_"+ j + "up")) {
                    c = map.get(i +"_"+ j + "up");
                } else {
                    c = 1 + FetchLongestPath2(matrix, i - 1, j, m, n, set, map);
                    if (c != 0) {
                        map.put(i +"_"+ j + "up", c);
                    }
                }
            }

            return Math.max(Math.max(Math.max(a, b), c), d);
        }

    public static int dfs(int row, int col, int parent, int[][] matrix, Integer[][] cache){
        if(row < 0 || row == matrix.length || col < 0 || col == matrix[0].length ||
                matrix[row][col] <= parent){
            return 0;
        }
        if(cache[row][col] != null){
            return cache[row][col];
        }
        int up = 1 + dfs(row + 1, col, matrix[row][col], matrix, cache);
        int down = 1 + dfs(row - 1, col, matrix[row][col], matrix, cache);
        int left = 1 + dfs(row, col - 1, matrix[row][col], matrix, cache);
        int right = 1 + dfs(row, col + 1, matrix[row][col], matrix, cache);

        int longestPath = Math.max(Math.max(up, down), Math.max(left, right));
        cache[row][col] = longestPath;
        return longestPath;
    }
}
