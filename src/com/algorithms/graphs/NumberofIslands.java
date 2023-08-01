package graphs;

import java.util.Arrays;
import java.util.Objects;

public class NumberofIslands {
    public static void main(String[] args) {
        char[][]  grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(NumberofIslandsFunc(grid));
    }

    private static int NumberofIslandsFunc(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (Objects.equals(grid[i][j], '1') && !visited[i][j]) {
                    count++;
                    MarkIsland(visited, grid, grid.length, grid[0].length, i, j);
                }
            }
        }
        return count;
    }

    private static void MarkIsland(boolean[][] visited, char[][] grid, int m, int n, int i, int j) {
        if (i >= m || i < 0 || j < 0 || j >= n) {
            return;
        } else if (visited[i][j]) {
            return;
        } else if (grid[i][j] != '1') {
            return;
        }

        if (grid[i][j] == '1') {
            visited[i][j] = true;
        }


        MarkIsland(visited, grid, m, n, i + 1, j);
        MarkIsland(visited, grid, m, n, i, j + 1);
        MarkIsland(visited, grid, m, n, i - 1, j);
        MarkIsland(visited, grid, m, n, i, j - 1);

    }
}
