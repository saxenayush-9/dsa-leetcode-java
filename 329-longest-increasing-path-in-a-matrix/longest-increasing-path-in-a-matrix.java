class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                solve(matrix,dp,i,j,n,m);
            }
        }


        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max=Integer.max(max,dp[i][j]);
            }
        }
        return max;
    }
    public int solve(int[][] matrix, int[][] dp, int row, int col , int n, int m){
        if(dp[row][col]>0)return dp[row][col];

        dp[row][col]=1;
        int[][] dirs={{-1,0},{0,-1},{0,1},{1,0}};

        for(int[] dir: dirs){
            int currRow = row+dir[0];
            int currCol = col+dir[1];
            if(currRow>=0 && currCol>=0 && currRow<n && currCol<m && matrix[currRow][currCol]>matrix[row][col]){
                if(dp[currRow][currCol]>0){
                    dp[row][col]=Math.max(dp[row][col],1+dp[currRow][currCol]);
                }
                else{
                    dp[row][col]=Math.max(dp[row][col],1+solve(matrix,dp,currRow,currCol,n,m));
                }
            }
        }
        return dp[row][col];
    }
}