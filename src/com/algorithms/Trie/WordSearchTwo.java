package Trie;

import java.util.ArrayList;
        import java.util.List;


public class WordSearchTwo {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(word);
        }
        return root;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node, List<String> result) {
        char ch = board[row][col];
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // mark word as found (avoid duplicates)
        }

        board[row][col] = '#'; // mark cell as visited

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                dfs(board, newRow, newCol, node, result);
            }
        }

        board[row][col] = ch; // restore cell value
    }
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        WordSearchTwo wordSearch = new WordSearchTwo();
        List<String> foundWords = wordSearch.findWords(board, words);

        System.out.println("Found words:");
        for (String word : foundWords) {
            System.out.println(word);
        }
    }

}


