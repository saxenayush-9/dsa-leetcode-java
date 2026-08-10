class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
        }
        int ans = 0;
        for(Integer i : dp){
            ans=Math.max(i,ans);
        }
        return ans;
    }
}