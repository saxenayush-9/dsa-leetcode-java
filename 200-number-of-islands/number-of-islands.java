class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0 ;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='0')continue;
                if(visited[i][j])continue;
                dfs(grid,visited,i,j,n,m);
                count++;
            }
        }
        return count;
    }
    public void dfs(char[][]grid, boolean[][] visited, int row, int col, int n, int m){
        if(row<0 || col<0)return;
        if(row>=n || col>=m)return;
        if(grid[row][col]=='0')return;
        if(visited[row][col])return;
        visited[row][col]=true;
        dfs(grid,visited,row+1,col,n,m);
        dfs(grid,visited,row-1,col,n,m);
        dfs(grid,visited,row,col+1,n,m);
        dfs(grid,visited,row,col-1,n,m);
    }
}