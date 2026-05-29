class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.MIN_VALUE;
        int n = nums.length;
        int i=0;
        double currAvg = Double.MIN_VALUE;
        double currSum = 0;
        while(i<k){
            currSum+=nums[i];
            i++;
        }
        currAvg = currSum/k;
        maxAvg = currAvg;
        while(i<n){
            currSum-=nums[i-k];
            currSum+=nums[i];
            currAvg = currSum/k;
            maxAvg=Math.max(maxAvg,currAvg);
            i++;
        }
        return maxAvg;
    }
}