class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (board[i][j] == 'O') {
                        que.add(new int[] { i, j });
                        visited[i][j] = true;
                    }
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        while (!que.isEmpty()) {
            int[] arr = que.remove();
            int row = arr[0];
            int col = arr[1];

            for (int[] dir : dirs) {
                int currRow = row + dir[0];
                int currCol = col + dir[1];
                if (currRow >= 0 && currCol >= 0 && currRow < n && currCol < m && !visited[currRow][currCol]
                        && board[currRow][currCol] == 'O') {
                    que.add(new int[] { currRow, currCol });
                    visited[currRow][currCol] = true;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
}