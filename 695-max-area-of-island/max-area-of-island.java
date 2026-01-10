class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxArea = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0)continue;
                if(visited[i][j])continue;
                int area = dfs(grid,visited,i,j,n,m);
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, boolean[][]visited, int row, int col, int n, int m){
        if(row<0 || col <0)return 0;
        if(row>=n || col>=m)return 0;
        if(grid[row][col]==0)return 0;
        if(visited[row][col])return 0;
        visited[row][col]=true;
        return 1+(dfs(grid,visited,row+1,col,n,m)+dfs(grid,visited,row-1,col,n,m)+dfs(grid,visited,row,col+1,n,m)+dfs(grid,visited,row,col-1,n,m));
    }
}