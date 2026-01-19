class Solution {
    public int maxProduct(int[] nums) {
        int prevMax = nums[0];
        int prevMin = nums[0];
        int maxProduct = nums[0];
        for(int i=1;i<nums.length;i++){
            int currMax = Math.max(nums[i],Math.max(prevMax*nums[i],prevMin*nums[i]));
            int currMin = Math.min(nums[i],Math.min(prevMax*nums[i],prevMin*nums[i]));
            maxProduct = Math.max(maxProduct,currMax);
            prevMax = currMax;
            prevMin = currMin;
        }
        return maxProduct;
    }
}