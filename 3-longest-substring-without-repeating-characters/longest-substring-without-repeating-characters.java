class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex,-1);
        int l=0, r=0;
        int maxLength = 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(lastIndex[ch]>=l){
                l = lastIndex[ch]+1;
            }
            lastIndex[ch]=r;
            maxLength = Math.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
    }
}