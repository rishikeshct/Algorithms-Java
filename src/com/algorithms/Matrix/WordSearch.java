package Matrix;

import java.util.Arrays;
import java.util.Objects;

public class WordSearch {

     static boolean[][] visited;


    static boolean found = false;

    public static void main(String[] args) {
       char[][] board = {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};
       String word  = "CCSE";

        System.out.println(WordSearchFunc(board, word));
    }

    private static boolean WordSearchFunc(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int i =0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
//                    wordDfs(board,word, i, j , 0);
//                if (found) {
//                        return true;
//                    }
                    if ( wordDfs2(board,word, i, j , 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void wordDfs(char[][] b, String word, int r, int c,int ptr) {

        visited[r][c] = true;
        ptr++;

        // base case
        if(ptr == word.length()) {
            found = true;
            return;
        }

        // dfs
        if(r + 1 < b.length && !visited[r + 1][c] && word.charAt(ptr) == b[r+1][c]) // down
            wordDfs(b, word, r + 1, c, ptr);
        if(!found && r - 1 >= 0 && !visited[r - 1][c] && word.charAt(ptr) == b[r-1][c]) // up
            wordDfs(b, word, r - 1, c, ptr);
        if(!found && c + 1 < b[0].length && !visited[r][c + 1] && word.charAt(ptr) == b[r][c+1])  // right
            wordDfs(b, word, r, c + 1, ptr);
        if(!found && c - 1 >= 0 && !visited[r][c - 1] && word.charAt(ptr) == b[r][c-1]) // left
            wordDfs(b, word, r, c - 1, ptr);

        // backtrack
        visited[r][c] = false;
    }

    private static boolean wordDfs2(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(wordDfs2(board, word, i-1, j, index+1) ||
                wordDfs2(board, word, i+1, j, index+1) ||
                wordDfs2(board, word, i, j-1, index+1) ||
                wordDfs2(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
