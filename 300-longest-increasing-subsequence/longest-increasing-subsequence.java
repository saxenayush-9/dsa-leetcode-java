class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxLength = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int currMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    currMax = Math.max(currMax, dp[j]);
                }
            }
            currMax++;
            dp[i] = currMax;
            maxLength = Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}