class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j])
                    continue;
                if (solve(board, visited, i, j, n, m, word, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean solve(char[][] board, boolean[][] visited, int row, int col, int n, int m, String word,
            int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0)
            return false;
        if (row >= n || col >= m)
            return false;
        if (visited[row][col])
            return false;
        if (board[row][col] != word.charAt(index))
            return false;

        visited[row][col] = true;
        index++;
        if (solve(board, visited, row + 1, col, n, m, word, index) ||
                solve(board, visited, row - 1, col, n, m, word, index) ||
                solve(board, visited, row, col + 1, n, m, word, index) ||
                solve(board, visited, row, col - 1, n, m, word, index)) {
            visited[row][col] = false;
            index--;
            return true;
        }
        visited[row][col] = false;
        index--;
        return false;
    }
}