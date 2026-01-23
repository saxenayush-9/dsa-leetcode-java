class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int m = amount;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<=m;j++){
            if(j%coins[0]==0){
                dp[1][j]=1;
            }
        }

        for(int i=2;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}