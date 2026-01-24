class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(Integer i : nums){
            total+=i;
        }
        if (Math.abs(target) > total) return 0;
        target=total+target;
        if(target%2!=0)return 0;
        target/=2;
        int n = nums.length;
        int[][]dp= new int[n+1][target+1];
        for(int i=0;i<=n;i++){
           dp[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}