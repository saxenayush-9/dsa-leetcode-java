class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] lastPosition = new int[256];
        Arrays.fill(lastPosition,-1);
        int maxLength=0;
        int l=0,r=0;
        while(r<n){
            int index = s.charAt(r);
            if(lastPosition[index]>=l){
                l=lastPosition[index]+1;
            }
            lastPosition[index]=r;
            maxLength=Math.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
    }
}