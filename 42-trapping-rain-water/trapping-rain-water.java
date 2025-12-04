class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int low=0,high=n-1;
        int leftMax =0,rightMax = 0;
        int res=0;
        while(low<=high){
            leftMax = Math.max(leftMax,height[low]);
            rightMax = Math.max(rightMax,height[high]);
            if(leftMax<rightMax){
                res+=leftMax-height[low];
                low++;
            }
            else{
                res+=rightMax-height[high];
                high--;
            }
        }
        return res;
    }
}