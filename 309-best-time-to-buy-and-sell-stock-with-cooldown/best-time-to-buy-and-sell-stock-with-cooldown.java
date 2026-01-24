class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[5001][2];
        for(int i=0;i<5001;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        boolean buy= true;
        return solve(prices,dp,0,buy);
    }
    public int solve(int[] prices,int[][] dp,int i, boolean buy){
        if(i>=prices.length)return 0;
        if(buy){
            if(dp[i][1]!=-1)return dp[i][1];
        }
        else{
            if(dp[i][0]!=-1)return dp[i][0];
        }
        int profit=0;
        if(buy){
            int take = solve(prices,dp,i+1,false)-prices[i];
            int notTake = solve(prices,dp,i+1,true);
            profit = Math.max(take,notTake);
        }
        else{
            int take = prices[i]+solve(prices,dp,i+2,true);
            int notTake = solve(prices,dp,i+1,false);
            profit = Math.max(take,notTake);
        }
        if(buy){
            dp[i][1]=profit;
        }
        else{
            dp[i][0]=profit;
        }
        return profit;
    }
}