class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,n,m);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col, int n, int m){
        if(row<0 || col<0)return;
        if(row>=n || col>=m)return;

        if(grid[row][col]=='0')return;

        grid[row][col]='0';

        dfs(grid,row+1,col,n,m);
        dfs(grid,row-1,col,n,m);
        dfs(grid,row,col+1,n,m);
        dfs(grid,row,col-1,n,m);
    }
}