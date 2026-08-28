class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<String> que = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    String str = i+","+j;
                    visited[i][j]=true;
                    que.add(str);
                }
            }
        }

        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};

        while(!que.isEmpty()){
            String str = que.remove();
            String[] st = str.trim().split(",");

            int row = Integer.parseInt(st[0]);
            int col = Integer.parseInt(st[1]);

            for(int[] dir: dirs){
                int currRow = row+dir[0];
                int currCol = col+dir[1];

                if(currRow>=0 && currCol>=0 && currRow<n && currCol<m && !visited[currRow][currCol] && grid[currRow][currCol]==1){
                    visited[currRow][currCol]=true;
                    grid[currRow][currCol]=grid[row][col]+1;
                    str = currRow+","+currCol;
                    que.add(str);
                }
            }
        }

        int res = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    continue;
                }
                else if(grid[i][j]==1){
                    return -1;
                }
                else{
                    res= Math.max(res,grid[i][j]);
                }
            }
        }
        
        return res==Integer.MIN_VALUE?0:res-2;
    }
}