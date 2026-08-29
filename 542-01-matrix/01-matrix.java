class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] visited = new boolean[m][n];
        
        Queue<int[]> que = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    visited[i][j]=true;
                    que.add(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!que.isEmpty()){
            int[] arr = que.remove();
            int row = arr[0];
            int col = arr[1];

            for(int[] dir: dirs){
                int currRow = row+dir[0];
                int currCol = col+dir[1];

                if(currRow>=0 && currCol>=0 && currRow<m && currCol<n && !visited[currRow][currCol] && mat[currRow][currCol]==1){
                    visited[currRow][currCol]=true;
                    mat[currRow][currCol]=mat[row][col]+1;
                    que.add(new int[] {currRow,currCol});
                }
            }
        }

        return mat;
    }
}