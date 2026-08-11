class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            int max = 1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    max=Math.max(max,dp[j]+1);
                }
            }
            dp[i]=max;
        }

        int res=0;
        for(Integer i : dp){
            res=Math.max(res,i);
        }
        return res;
    }
}