class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;
        
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=m;i++){
            dp[0][i]=Integer.MAX_VALUE-1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(j>=coins[i-1]){
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m]==Integer.MAX_VALUE-1?-1:dp[n][m];
    }
}