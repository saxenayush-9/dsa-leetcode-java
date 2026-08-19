class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(Integer i : nums){
            sum+=i;
        }
        int remaining = sum%k;
        return remaining;
    }
}