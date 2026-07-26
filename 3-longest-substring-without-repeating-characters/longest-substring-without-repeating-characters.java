class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastPosition = new int[256];
        Arrays.fill(lastPosition,-1);
        int n = s.length();
        int l=0,r=0;
        int maxLength=Integer.MIN_VALUE;

        while(r<n){
            int index = s.charAt(r);
            if(lastPosition[index]>=l){
                l=lastPosition[index]+1;
            }
            maxLength=Math.max(maxLength,r-l+1);
            lastPosition[index]=r;
            r++;
        }
        return maxLength==Integer.MIN_VALUE?0:maxLength;
    }
}