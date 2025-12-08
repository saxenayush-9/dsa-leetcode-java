class Solution {
    public int findMinIndex(int[] nums){
        int n = nums.length;
        int low=0,high=n-1;
        while(low<high){
            if(high-low==1){
                if(nums[low]<nums[high])return low;
                return high;
            }
            int mid = low+((high-low)/2);
            if(nums[mid]>nums[0]){
                low=mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n==1){
            if(nums[0]==target)return 0;
            return -1;
        }
        int minIndex = nums[0]<nums[n-1] ? 0 : findMinIndex(nums);
        if(nums[minIndex]==target)return minIndex;
        int low = 0,high = n-1;
        if(minIndex==0){
            low = 1;
        }
        else if(minIndex == n-1){
            high = n-2;
        }
        else{
            if(target>nums[n-1]){
                high = minIndex-1;
            }
            else if(target<nums[0]){
                low = minIndex+1;
            }
        }
        
        while(low<=high){
            int mid = low+((high-low)/2);
            if(nums[mid]<target){
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else return mid;
        }
        return -1;
    }
}