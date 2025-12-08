class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        if(nums[0]<nums[n-1])return nums[0];
        int low = 0,high = n-1;
        while(low<high){
            if(high-low==1)return Math.min(nums[low],nums[high]);
            int mid = low+((high-low)/2);
            if(nums[mid-1]>nums[mid] && nums[mid+1]>nums[mid])return nums[mid];
            if(nums[mid]>nums[0]){
                low = mid+1;
            }
            else if(nums[mid]<nums[n-1]){
                high = mid-1;
            }
        }
        return nums[low];
    }
}