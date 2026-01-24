class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int idealSum = (n*(n+1))/2;
        int currSum = 0;
        for(Integer i : nums){
            currSum+=i;
        }
        return idealSum-currSum;
    }
}