/**
 * Given an m x n board and a word, find if the word exists in the grid. The
 * word can be constructed from letters of sequentially adjacent cells, where
 * "adjacent" cells are horizontally or vertically neighboring. The same letter
 * cell may not be used more than once.
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        // We can use a recursive backtracking approach and we can either move up : i-1,
        // down : i+1, left : j-1, right: j+1
        // As we can't use a letter twice, we can use extra space to mark that letter

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (existHelper(board, word, visited, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length())
            return true;

        // Add checks for i, j, index
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || visited[i][j]
                || board[i][j] != word.charAt(index))
            return false;

        visited[i][j] = true;

        if (existHelper(board, word, visited, i, j + 1, index + 1)
                || existHelper(board, word, visited, i + 1, j, index + 1)
                || existHelper(board, word, visited, i, j - 1, index + 1)
                || existHelper(board, word, visited, i - 1, j, index + 1))

            return true;

        // Stating that current letter not used and backtrack
        visited[i][j] = false;

        return false;
    }

}