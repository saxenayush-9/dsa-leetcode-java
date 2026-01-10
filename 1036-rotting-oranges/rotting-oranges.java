class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    que.add(new int[] { i, j });
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

                if (currRow >= 0 && currRow < n && currCol >= 0 && currCol < m && grid[currRow][currCol] == 1
                        && !visited[currRow][currCol]) {
                    visited[currRow][currCol] = true;
                    grid[currRow][currCol] = grid[row][col] + 1;
                    que.add(new int[] { currRow, currCol });
                }
            }
        }

        int minTime = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 2)
                    continue;
                else if (grid[i][j] == 1) {
                    return -1;
                } else {
                    minTime = Math.max(minTime, grid[i][j]);
                }
            }
        }
        return minTime == 0 ? 0 : minTime - 2;
    }
}