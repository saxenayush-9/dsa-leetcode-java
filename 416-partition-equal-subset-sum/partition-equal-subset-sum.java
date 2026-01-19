class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(Integer i: nums){
            total+=i;
        }
        if(total%2!=0)return false;
        total = total/2;
        return knapsack(nums,total);
    }
    public boolean knapsack(int[] nums, int capacity){
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][capacity+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=capacity;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][capacity];
    }
}