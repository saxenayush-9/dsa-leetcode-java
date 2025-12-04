class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l=0,r=n-1;
        int maxWater=Integer.MIN_VALUE;
        while(l<=r){
            int length = Math.min(height[l],height[r]);
            int width = r-l;
            int water = length*width;
            maxWater=Math.max(maxWater,water);
            if(height[l]<height[r]){
                l++;
            }
            else r--;
        }
        return maxWater;
    }
}