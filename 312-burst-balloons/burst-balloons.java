class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0]=1;
        arr[arr.length-1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }

        int[][] dp = new int[n+2][n+2];
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j)continue;
                for(int index=i;index<=j;index++){
                    dp[i][j]=Math.max(dp[i][j],arr[i-1]*arr[index]*arr[j+1]+dp[i][index-1]+dp[index+1][j]);
                }
            }
        }
        return dp[1][n];
    }
}