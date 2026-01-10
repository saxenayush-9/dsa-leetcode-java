class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visitedPacific = new boolean[n][m];
        boolean[][] visitedAtlantic = new boolean[n][m];
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    visitedPacific[i][j] = true;
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
                if (currRow >= 0 && currRow < n && currCol >= 0 && currCol < m && !visitedPacific[currRow][currCol]
                        && heights[currRow][currCol] >= heights[row][col]) {
                    visitedPacific[currRow][currCol] = true;
                    que.add(new int[] { currRow, currCol });
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == n - 1 || j == m - 1) {
                    visitedAtlantic[i][j] = true;
                    que.add(new int[] { i, j });
                }
            }
        }

        while (!que.isEmpty()) {
            int[] arr = que.remove();
            int row = arr[0];
            int col = arr[1];
            for (int[] dir : dirs) {
                int currRow = row + dir[0];
                int currCol = col + dir[1];
                if (currRow >= 0 && currRow < n && currCol >= 0 && currCol < m && !visitedAtlantic[currRow][currCol]
                        && heights[currRow][currCol] >= heights[row][col]) {
                    visitedAtlantic[currRow][currCol] = true;
                    que.add(new int[] { currRow, currCol });
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visitedPacific[i][j] && visitedAtlantic[i][j]) {
                    List<Integer> li = new ArrayList<>();
                    li.add(i);
                    li.add(j);
                    list.add(li);
                }
            }
        }

        return list;

    }
}